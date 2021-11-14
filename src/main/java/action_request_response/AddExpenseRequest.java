package action_request_response;

/**
 * Class is responsible for keeping a record of the needed information
 * that will be used when AddExpense is called for
 */
public class AddExpenseRequest extends ActionRequest{
    private final String category;
    private final double amount;

    /**Initializer
     *
     * @param username username of the account we're processing the request
     *                 for
     * @param category where the expense falls under for the budget
     * @param amount the amount/value of the expense
     */
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
