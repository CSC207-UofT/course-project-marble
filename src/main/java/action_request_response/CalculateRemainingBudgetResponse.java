package action_request_response;

public class CalculateRemainingBudgetResponse extends ActionResponse{
    private final boolean exists;
    private final double amount;


    public CalculateRemainingBudgetResponse(boolean exists) {
        this.exists = exists;
        this.amount = 0;
    }

    public  CalculateRemainingBudgetResponse(boolean exists, double amount) {
        this.exists = exists;
        this.amount = amount;
    }
    public String getResult(){
        if (!exists) {
            return "Budget Inactive or Does Not Exist";
        }
        return ("Total Remaining Budget: 4" + String.valueOf(amount));
    }
}
