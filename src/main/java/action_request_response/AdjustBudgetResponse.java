package action_request_response;

public class AdjustBudgetResponse extends ActionResponse {
    private final String result;
    public AdjustBudgetResponse(String result){this.result = result;}

    public String getResult(){return this.result;}
}

