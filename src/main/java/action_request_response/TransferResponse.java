package action_request_response;

public class TransferResponse extends ActionResponse{
    private final boolean result;

    public TransferResponse(boolean result){
        this.result = result;
    }

    public boolean getResult(){
        return this.result;
    }
}
