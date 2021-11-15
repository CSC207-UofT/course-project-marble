package action_request_response;

/**
 * Class is responsible for containing the information
 * a Deposit object needs to process a request from the User
 * to deposit
 */
public class DepositRequest extends ActionRequest {
    private final double amount;

    /**
     * Initializer for when request wants to deposit into an Owner's
     * balance
     *
     * @param username username connected owner object the request is for
     * @param amount   amount of money that the request wants to deposit in
     */
    public DepositRequest(String username, double amount) {
        super(username);
        this.amount = amount;
    }


    public double getAmount() {
        return amount;
    }

}
