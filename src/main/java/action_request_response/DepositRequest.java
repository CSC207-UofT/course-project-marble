package action_request_response;

import entity.Depositable;
import entity.Owner;

public class DepositRequest extends ActionRequest{
    private final Owner owner;
    private final Depositable depositable;
    private final double amount;

    public DepositRequest(Owner owner, double amount){
        super(owner.getName());
        this.owner = owner;
        this.amount = amount;
        this.depositable = null;
    }

    public DepositRequest(Owner owner, double amount, Depositable depositable){
        super(owner.getName());
        this.owner = owner;
        this.amount = amount;
        this.depositable = depositable;
    }

    public Owner getOwner(){ return owner; }
    public double getAmount(){ return amount; }
    public Depositable getDepositable(){ return depositable; }
}
