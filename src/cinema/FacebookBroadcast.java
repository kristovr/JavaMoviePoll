package cinema;
import java.util.ArrayList;
import java.util.List;


public class FacebookBroadcast implements Broadcastable{
    
    //--------ATTRIBUTE----------
    
    private List<Poll> pollResults = new ArrayList<>();

    //--------GETTER----------
    
    public List<Poll> getPollResults() {
        return pollResults;
    }
    
    //--------SETTER----------

    public void setPollResults(List<Poll> pollResults) {
        this.pollResults = pollResults;
    }
    
    //--------METHOD----------
    
    @Override
    public void broadcast(){
        //broadcast to facebook
    }
    
}
