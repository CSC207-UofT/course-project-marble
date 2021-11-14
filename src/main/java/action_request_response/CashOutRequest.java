package action_request_response;

import entity.NonDepositable;

public class CashOutRequest extends ActionRequest{
    private final NonDepositable investment;

    public CashOutRequest(String username, NonDepositable investment){
        super(username);
        this.investment = investment;
    }


    public NonDepositable getInvestment(){ return investment; }
}
