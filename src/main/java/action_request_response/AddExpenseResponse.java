package action_request_response;

public class AddExpenseResponse extends ActionResponse{
    private final boolean result;

    public AddExpenseResponse(boolean result){
        this.result = result;
    }

    public boolean getResult(){
        return result;
    }
}
