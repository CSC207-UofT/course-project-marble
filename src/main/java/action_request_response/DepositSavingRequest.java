package action_request_response;

public class DepositSavingRequest extends ActionRequest {
    private final String name;
    private final String amount;

    public DepositSavingRequest(String username,String name,String amount){
        super(username);
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getAmount() {
        return amount;
    }
}
