package action_request_response;

public class AddExpenseRequest extends ActionRequest{
    private final String category;
    private final double amount;

    public AddExpenseRequest(String username, String category, double amount){
        super(username);
        this.category = category;
        this.amount = amount;
    }


    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }
}
