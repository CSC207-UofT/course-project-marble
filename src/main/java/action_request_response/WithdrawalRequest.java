package action_request_response;

public class WithdrawalRequest extends ActionRequest {
    private final double cost;
    private final String category;
    private final String description;

    /**
     * Constructor that create a Withdrawal request that is used in the Withdrawal action.
     *
     * @param username users username
     * @param cost The amount of money withdrawn
     * @param category The category the user has withdrawn the money for.
     * @param description The description of the money being withdrawn is used for.
     */
    public WithdrawalRequest(String username, double cost, String category, String description) {
        super(username);
        this.cost = cost;
        this.category = category;
        this.description = description;
    }

    public double getCost() {
        return this.cost;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }
}
