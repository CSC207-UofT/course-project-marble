package actions;
import action_request_response.ActionResponse;
import action_request_response.WithdrawalResponse;
import entity.*;

public class Withdrawal extends Actions{
    private final Owner user;
    private final Date date;
    private final double cost;
    private final String category;
    private final String description;

    public Withdrawal(WithdrawalRequest request){
        this.user = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
        this.date = new Date();
        this.cost = request.getCost();
        this.category = request.getCategory();
        this.description = request.getDescription();
    }

    /**
     * This method withdraws money from the users balance and updates the users record.
     * @return an action response result of true if money is withdrawn,
     * an action response of false if money can not be withdrawn.
     */
    @Override
    public ActionResponse process(){
        if (cost <= user.getBalance()) {
            Record withdraw = new Record(-cost, this.date, this.category, this.description);
            user.addRecord(withdraw);
            user.setBalance(user.getBalance() - cost);
            return new WithdrawalResponse(true);
        }
        System.out.println("Unable to withdraw. Please Try Again.");
        return new WithdrawalResponse(false);
    }
}
