package action_request_response;

public class AdjustBudgetResponse extends ActionResponse {
    private final boolean result;
    public AdjustBudgetResponse(boolean result){this.result = result;}

    public boolean getResult(){return this.result;}
}

