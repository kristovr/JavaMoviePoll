package cinema;
import java.util.*;

public class Poll {
    
    //--------ATTRIBUTES----------
    
    private String name;
    private String description;
    private Date startDateTime;
    private Date endDateTime;
    private List<Person> voted; // not specifying the arraylist here
    private HashMap<Movie, Integer> results;

    //--------ATTRIBUTES----------
    
    //--------CONSTRUCTOR----------
    
    public Poll(String name, String description, Date startDateTime, Date endDateTime, HashMap<Movie, Integer> results) {
        this.name = name;
        this.description = description;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.voted = new ArrayList<>(); //specifying it here to have it in the instance instead
        this.results = results;
    }
    
    //--------CONSTRUCTOR----------
    
    //--------GETTERS----------

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public List<Person> getVoted() {
        return voted;
    }

    public HashMap<Movie, Integer> getResults() {
        return results;
    }
    
    //--------GETTERS----------
    
    //--------SETTERS----------
    
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public void setVoted(List<Person> voted) {
        this.voted = voted;
    }

    public void setResults(HashMap<Movie, Integer> results) {
        this.results = results;
    }
    
    //--------SETTERS----------
    
    //--------METHODS----------
    
    public void vote(String movieID, Person person){
        
        /* we need to loop though the hashmap of movies for this instance to find the 
           corresponding id once we find that id we add plus one to its score we add 
           that voter to the list of voters
        */
        
        for(Map.Entry<Movie, Integer> entry: this.results.entrySet()){
            if(entry.getKey().getId().equals(movieID)){
                this.results.put(entry.getKey(), entry.getValue() + 1);
                this.voted.add(person);
                System.out.print("Vote Casted\n");
            }
        }   
    }    
}
