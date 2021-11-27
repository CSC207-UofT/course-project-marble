package action_request_response;

public class ResetBudgetResponse extends ActionResponse{
    private final boolean result;

    public ResetBudgetResponse(boolean result){this.result = result;}
    public boolean getResult(){return this.result;}
}
