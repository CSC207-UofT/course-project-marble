package action_request_response;

public class CreateSavingRequest extends ActionRequest{
    private final double interestRate;
    private final String name;
    
    public CreateSavingRequest(String username, double interestRate, String name) {
        super(username);
        this.interestRate = interestRate;
        this.name = name;
    }
    
    public double getInterestRate() {
        return this.interestRate;
    }

    public String getName() {
        return this.name;
    }
}
