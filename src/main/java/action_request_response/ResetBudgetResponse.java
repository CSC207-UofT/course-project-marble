package action_request_response;

public class ResetBudgetResponse extends ActionResponse{
    private final boolean result;
    private final double amount;

    public ResetBudgetResponse(boolean result, double amount){
        this.result = result;
        this.amount = amount;
    }
    public String getResult(){
        if(result){
            return "The total remaining budget from last month is: $" + this.amount;
        }
        return "Budget Inactive or Does Not Exist";
    }
}