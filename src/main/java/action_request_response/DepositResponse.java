package action_request_response;

public class DepositResponse extends ActionResponse{
    private final boolean result;
    public DepositResponse(boolean result){
        this.result = result;
    }

    public boolean getResult(){
        return result;
    }
}
