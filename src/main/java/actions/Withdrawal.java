package actions;
import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import action_request_response.WithdrawalResponse;
import entity.*;
import entity.Record;

import java.util.ArrayList;

public class Withdrawal extends Actions{
    private final Owner user;
    private final Date date;
    private final double cost;
    private final String category;
    private final String description;

    public Withdrawal(ActionRequest request){
        this.user = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
        this.date = new Date();
        ArrayList<String> userInputs = request.getUserInputs();
        this.cost = Double.parseDouble(userInputs.get(0));
        this.category = userInputs.get(1);
        this.description = userInputs.get(2);
    }

    /**
     * This method withdraws money from the users balance and updates the users record and budget.
     * @return an action response result of true if money is withdrawn,
     * an action response of false if money can not be withdrawn.
     */
    @Override
    public ActionResponse process(){
        if (cost <= user.getBalance()) {
            Record withdraw = new Record(-cost, this.date, this.category, this.description);
            user.addRecord(withdraw);
            user.setBalance(user.getBalance() - cost);

            Budget budget = user.getBudget();
            if (budget.getActive()){
                budget.setActualSpending(category, cost);
            }
            return new WithdrawalResponse(true);
        }
        System.out.println("Unable to withdraw. Please Try Again.");
        return new WithdrawalResponse(false);
    }
}
