package action_request_response;

import entity.Depositable;
import entity.Owner;

public class DepositRequest extends ActionRequest{
    private final Owner owner;
    private final Depositable depositable;
    private final int amount;

    public DepositRequest(Owner owner, int amount){
        super(owner.getName());
        this.owner = owner;
        this.amount = amount;
        this.depositable = null;
    }

    public DepositRequest(Owner owner, int amount, Depositable depositable){
        super(owner.getName());
        this.owner = owner;
        this.amount = amount;
        this.depositable = depositable;
    }

    public Owner getOwner(){ return owner; }
    public int getAmount(){ return amount; }
    public Depositable getDepositable(){ return depositable; }
}
