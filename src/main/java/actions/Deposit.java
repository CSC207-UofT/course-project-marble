package actions;
import action_request_response.ActionResponse;
import action_request_response.DepositRequest;
import action_request_response.DepositResponse;
import entity.Owner;
import entity.Depositable;

public class Deposit extends Actions{
    private final Owner owner;
    private final Depositable depositable;
    private final double amount;

    public Deposit(DepositRequest request){
        this.owner = request.getOwner();
        this.depositable = request.getDepositable();
        this.amount = request.getAmount();
    }

    @Override
    public ActionResponse process(){
        if (amount < 0){
            return new DepositResponse(false);
        }
        if (depositable == null) {
            double currentAmount = owner.getBalance();
            owner.setBalance(currentAmount + amount);
        } else {
            depositable.deposit(amount);
        }
        return new DepositResponse(true);
    }
}
