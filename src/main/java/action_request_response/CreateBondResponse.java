package action_request_response;

public class CreateBondResponse extends ActionResponse{
    private final boolean result;

    public CreateBondResponse(boolean result){
        this.result = result;
    }

    public boolean getResult(){
        return result;
    }
}
