package action_request_response;

import entity.Depositable;
import entity.Owner;

public class DepositRequest extends ActionRequest{
    private final Depositable depositable;
    private final double amount;

    public DepositRequest(String username, double amount){
        super(username);
        this.amount = amount;
        this.depositable = null;
    }

    public DepositRequest(String username, double amount, Depositable depositable){
        super(username);
        this.amount = amount;
        this.depositable = depositable;
    }

    public double getAmount(){ return amount; }
    public Depositable getDepositable(){ return depositable; }
}
