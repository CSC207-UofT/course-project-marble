package actions;
import action_request_response.ActionResponse;
import action_request_response.DepositRequest;
import action_request_response.DepositResponse;
import entity.*;

public class Deposit extends Actions{
    private final Owner owner;
    private final Depositable depositable;
    private final double amount;
    private final Date date;

    public Deposit(DepositRequest request){
        this.owner = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
        this.depositable = request.getDepositable();
        this.amount = request.getAmount();
        this.date = new Date();

    }

    @Override
    public ActionResponse process(){
        if (amount < 0){
            return new DepositResponse(false);
        }
        if (depositable == null) {
            double currentAmount = owner.getBalance();
            owner.setBalance(currentAmount + amount);
            Record deposit = new Record(amount, date, "Deposit",
                    "Into Balance");
            owner.addRecord(deposit);
        } else {
            depositable.deposit(amount);
            Record deposit = new Record(amount, date, "Deposit",
                    "Other");
            owner.addRecord(deposit);
        }
        return new DepositResponse(true);
    }
}
