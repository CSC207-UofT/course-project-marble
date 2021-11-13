package action_request_response;

import entity.NonDepositable;
import entity.Owner;

public class CashOutRequest extends ActionRequest{
    private final Owner owner;
    private final NonDepositable investment;

    public CashOutRequest(Owner owner, NonDepositable investment){
        super(owner.getUserName());
        this.owner = owner;
        this.investment = investment;
    }

    public Owner getOwner(){ return owner; }

    public NonDepositable getInvestment(){ return investment; }
}
