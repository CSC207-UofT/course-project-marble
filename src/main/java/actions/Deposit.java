package actions;
import action_request_response.ActionResponse;
import action_request_response.DepositResponse;
import entity.*;

/**
 * Class is responsible for handling a request by user to
 * put money into a Depositable object or their account balance
 *
 * Note that this does not allow negative values to be put in (must
 * use Withdraw class)
 */
public class Deposit extends Actions{
    private final Owner owner;
    private final double amount;
    private final Date date;

    /**
     * Initializer for class
     * @param request contains all data for an object of the class to
     *                process
     */
    public Deposit(DepositRequest request){
        this.owner = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
        this.amount = request.getAmount();
        this.date = new Date();

    }

    /**
     * Processes the request the class object was made for
     * @return the response to if the process was successful or not
     */
    @Override
    public ActionResponse process(){
        if (amount < 0){
            return new DepositResponse(false);
        }
        double currentAmount = owner.getBalance();
        owner.setBalance(currentAmount + amount);
        Record deposit = new Record(amount, date, "Deposit",
                "Into Balance");
        owner.addRecord(deposit);
        return new DepositResponse(true);
    }
}
