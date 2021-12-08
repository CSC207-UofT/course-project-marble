package action_request_response;

public class CalculateRemainingBudgetResponse extends ActionResponse{
    private final boolean exists;
    private final String result;

    public  CalculateRemainingBudgetResponse(boolean exists, String result) {
        this.exists = exists;
        this.result = result;
    }
    public String getResult(){
        if (!exists) {
            return "Budget Inactive or Does Not Exist";
        }
        return (result);
    }
}
