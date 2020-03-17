package cinema;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;


public class Cinema {
    
    static Scanner input = new Scanner(System.in);
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    
    public static void main(String[] args) throws ParseException {
        
        //one pollmaster needed keeps tabs on all polls
        PollMaster newPoll = new PollMaster(); 
        display(newPoll);
    }
    
    private static void display(PollMaster poll) throws ParseException{
     
        System.out.println("-----------Welcome to Tony's Cinema------------");
        System.out.println("---------------Select an action----------------");
        System.out.print("1. Create a Poll\n2. Vote\n3. View Results\n>>");
        int choice = input.nextInt();
        
        switch(choice){
            case 1:
                createNewPoll(poll); 
                //creates a new poll with its own list of movies
            case 2:
                castVote(poll); 
                //allows a poll to be selected then a movie, vote is cast
            case 3:
                viewResults(poll); 
                //returns a breakdown of each poll, number of voters for that poll and votes received
        }
    }
    
    private static void createNewPoll(PollMaster poll) throws ParseException{
       //gathering user input
       System.out.print("Enter name of poll\n>>");
       String name = input.next();
                
       System.out.print("Enter a brief description\n>>");
       String description = input.next();
                
       System.out.print("Enter a start date\nyyyy-mm-dd\n>>");
       String strStartDate = input.next();
       Date startDate = sdf.parse(strStartDate);
                
       System.out.print("Enter a end date\nyyyy-mm-dd\n>>");
       String strEndDate = input.next();
       Date endDate = sdf.parse(strEndDate);
       
       //storing all the movies objects
       Movie movies[] = createMovies();
       
       //creating a new poll
       poll.createPoll(name, description, startDate, endDate, movies); 
       display(poll);
    }
    
    private static Movie[] createMovies(){
        //gathering movie data
        System.out.print("Enter amount of movies to be added to poll:\n>>");
        int numOfMovies = input.nextInt();
        
        //array of instances
        Movie[] newMovies = new Movie[numOfMovies];
        
        for(int i = 0; i < numOfMovies; i++){
            //gathering more data
            System.out.print("Enter movie ID\n>>");
            String id = input.next();
            System.out.print("Enter movie name:\n>>");
            String name = input.next();
            
            //some hardcoded data
            String description = "Lorem ipsum dolor sit";
            String[] genre = {"Action", "Comedy"}; 
            HashMap<String, Integer> rating = new HashMap<>();
            String[] directors = {"Robert B Weide", "Jim Jones"}; 
            String[] actors = {"Jim Carrey", "Ryan Reynolds"}; 
            String[] language = {"English", "Spanish"}; 
            String countryOfOrigin = "Guyana";
            
            //append those instances to the array
            newMovies[i] = new Movie(id,name,description,genre,rating,directors,actors,language,countryOfOrigin);
        }
        return newMovies;
    }
    
    private static void castVote(PollMaster poll){
        
        //loop through the list of polls stored in this pollmaster instance
        for(Poll listPoll : poll.getPolls()){
            
            //returning all the polls for the user to choose to cast vote
            System.out.println("Name: " + listPoll.getName());
            System.out.println("Description: " + listPoll.getDescription());
            
            //looping through the hashmap
            for(Map.Entry<Movie, Integer> entry : listPoll.getResults().entrySet()){
                System.out.println("Movie ID: " + entry.getKey().getId()+ " : " + entry.getKey().getName()+"\n");
            }
        }
        
        //user selects poll name, movie id and their name and id
        System.out.println("Select the poll to enter: \n>>");
        String choice = input.next();
        System.out.println("Select the movie ID to vote for: \n>>");
        String movieID = input.next();
        System.out.println("Enter your ID: \n>>");
        String id = input.next();
        System.out.println("Enter your name: \n>>");
        String name = input.next();
        //separating the voting logic 
        addVote(poll, choice, movieID, id, name);  
    }
    
    private static void addVote(PollMaster poll, String pollName, String movieID, String personID, String personName){
        //new instance of a voter created
        Person voter = new Person(personID, personName);
        
        /*looping through the current list of created polls and 
          call the vote function to update the movie in that poll*/
        
        for(Poll listPoll : poll.getPolls()){
            if(listPoll.getName().equals(pollName)){
                //movieID and person instance sent to the vote function
               listPoll.vote(movieID, voter);
            }
        }
    }
    
    private static void viewResults(PollMaster poll) throws ParseException{
        //calling for the broadcast to return all results
        poll.broadcastPollsResult();
        display(poll);
    }
}
