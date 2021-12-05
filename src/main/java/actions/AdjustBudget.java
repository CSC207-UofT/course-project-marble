package actions;

import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import action_request_response.AdjustBudgetResponse;
import entity.Budget;
import entity.Owner;
import entity.OwnerRepository;

import java.util.ArrayList;
import java.util.HashMap;

/**This Action allows for the user to adjust the actual amount for a single category in Budget.
 * ex:
 *  * note that the arraylist of doubles of a budget category is first [the goal amount, the actual amount]. *
 * We want to change the actual amount of the groceries category.
 * The current budget is: ("Groceries": [100,0], "Furniture": [100, 0], "Restaurant": [100, 0], "Vacation": [100, 0],
 * "Gas": [100, 0], "Recurring Bill Payment": [100, 0], "Health and Beauty": [100, 0], "Home Improvement": [100, 0],
 * "Entertainment": [100, 0], "Public Transportation and Parking": [100, 0])
 *
 * Now the user wants to adjust the Groceries category because they just spent $55 on groceries.
 * The new budget after adjustments is: ("Groceries": [100,55], "Furniture": [100, 0], "Restaurant": [100, 0],
 * "Vacation": [100, 0], "Gas": [100, 0], "Recurring Bill Payment": [100, 0], "Health and Beauty": [100, 0],
 * "Home Improvement": [100, 0], "Entertainment": [100, 0], "Public Transportation and Parking": [100, 0])
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

        if (budget.setActualBudget(this.category, this.newAmount)){
            return new AdjustBudgetResponse(true);
        }
        return new AdjustBudgetResponse(false);
        }
    }

