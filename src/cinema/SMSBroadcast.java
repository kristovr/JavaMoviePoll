package cinema;
import java.util.*;

public class SMSBroadcast implements Broadcastable{
    
    //--------ATTRIBUTE----------
    
    private List<Poll> pollResults = new ArrayList<>();
    
    //--------GETTERS----------
    
    public List<Poll> getPollResults() {
        return pollResults;
    }
    
    //--------SETTERS----------

    public void setPollResults(List<Poll> pollResults) {
        this.pollResults = pollResults;
    }
    
    //--------METHODS----------
    
    @Override
    public void broadcast(){
        //broadcast sms
    }

}
