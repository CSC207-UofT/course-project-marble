package actions;

import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import action_request_response.AdjustBudgetResponse;
import entity.Budget;
import entity.Owner;
import entity.OwnerRepository;

import java.util.ArrayList;

/**This Action allows for the user to adjust the actual amount for a single category in Budget.
 *
 * The method will return true if successful and false if the category doesn't exist.
 *
 * UserInputs: 0: category, 1: newAmount.*/
public class AdjustBudget extends Actions{
    private final Owner user;
    private final String category;
    private final Double newAmount;

    public AdjustBudget(ActionRequest request){
        this.user = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
        ArrayList<String> userInputs = request.getUserInputs();
        this.category = userInputs.get(0);
        this.newAmount = Double.parseDouble(userInputs.get(1));
    }

    @Override
    public ActionResponse process(){
        Budget budget = this.user.getBudget();

        if (budget.setGoalBudget(this.category, this.newAmount)){
            return new AdjustBudgetResponse(true);
        }
        return new AdjustBudgetResponse(false);
    }
}
