package cinema;
import java.util.*;
import java.util.stream.Collectors;

public class PollMaster {
    
    //--------ATTRIBUTES----------
    
    private List<Poll> polls = new ArrayList<>();
    private List<Broadcastable> broadcast = new ArrayList<>();
    
    //--------ATTRIBUTES----------
    
    //--------GETTERS----------

    public List<Poll> getPolls() {
        return polls;
    }

    public List<Broadcastable> getBroadcast() {
        return broadcast;
    }
    
    //--------GETTERS----------
    
    //--------SETTERS----------

    public void setPolls(List<Poll> polls) {
        this.polls = polls;
    }

    public void setBroadcast(List<Broadcastable> broadcast) {
        this.broadcast = broadcast;
    }
    
    //--------SETTERS----------
    
    //--------METHODS----------
    
    private Integer checkForCompletedPolls(){
        int count = 0;
        Date now = new Date(); //current date
        
        //extracting just the date to loop through and see the completed polls
        List<Date> pollEndDates = polls.stream()
                                       .map(p -> p.getEndDateTime())
                                       .collect(Collectors.toList());
        
        for (Date pollEndDate : pollEndDates) {
            if(pollEndDate.compareTo(now) < 0){ //if date is before means end date has passed
                //keep a count of how many are finished
                count++;
            }
        }
        return count;
    }
    
    public void createPoll(String name, String description, Date startDateTime, Date endDateTime, Movie[] movies){
        //a movie has one or more movie this hashmap store that
        HashMap<Movie, Integer> movieList = new HashMap<>();
        
        //loop through the array passed in and store the movie object and intialize its score to zero
        for (Movie movie : movies) {
            movieList.put(movie, 0);
            
        }
        //new poll instance
        Poll newPoll = new Poll(name, description, startDateTime, endDateTime, movieList);
        //add ot to the poll master's list of polls
        polls.add(newPoll);
        
    }
    
    public void broadcastPollsResult(){
        //print everything out
        
        for(Poll poll : polls){
            System.out.println("Name: " + poll.getName());
            System.out.println("Description: " + poll.getDescription());
            System.out.println("Start Date: " + poll.getStartDateTime());
            System.out.println("End Date: " + poll.getEndDateTime());
            System.out.println("Number of voters: " + poll.getVoted().size());
            for(Map.Entry<Movie, Integer> entry : poll.getResults().entrySet()){
                System.out.println("Movie name: " + entry.getKey().getName() + " : " + entry.getValue());
            }
        }
    }
       
}
