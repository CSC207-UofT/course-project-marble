package action_request_response;

public class ActivateBudgetResponse extends ActionResponse{
    private final boolean result;

    public ActivateBudgetResponse(boolean result){ this.result = result;

    }
    public boolean getResult(){return this.result;}
}
