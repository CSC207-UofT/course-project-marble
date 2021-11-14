package action_request_response;

public class OwnerInfoResponse extends ActionResponse{
    private final String display;

    public OwnerInfoResponse(String display){
        this.display = display;
    }

    public String getDisplay(){
        return display;
    }
}
