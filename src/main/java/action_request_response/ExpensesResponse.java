package action_request_response;

public class ExpensesResponse extends ActionResponse{
    private final boolean result;

    public ExpensesResponse(boolean result){
        this.result = result;
    }

    public boolean getResult(){
        return result;
    }
}
