package action_request_response;

public class DepositSavingRequest extends ActionRequest {
    private final String name;
    private final double amount;

    public DepositSavingRequest(String username, String name, double amount) {
        super(username);
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }
}
