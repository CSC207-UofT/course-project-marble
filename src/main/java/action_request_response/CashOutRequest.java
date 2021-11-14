package action_request_response;

import entity.NonDepositable;
import entity.OwnerRepository;

public class CashOutRequest extends ActionRequest{
    private final String username;
    private final NonDepositable investment;

    public CashOutRequest(String username, NonDepositable investment){
        super(username);
        this.username = username;
        this.investment = investment;
    }

    public String getUsername(){ return username; }

    public NonDepositable getInvestment(){ return investment; }
}
