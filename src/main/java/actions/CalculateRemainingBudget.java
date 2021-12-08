package actions;
import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import action_request_response.CalculateRemainingBudgetResponse;
import entity.Budget;
import entity.Owner;
import entity.OwnerRepository;

import java.util.ArrayList;

/**
 * Class is responsible for seeing if the user has an active budget, and
 * (if they do) calculating how much of their budget in each category is
 * still unspent to be shown to the user
 */
public class CalculateRemainingBudget extends Actions {
    private final Owner user;
    private final Budget budget;

    public CalculateRemainingBudget(ActionRequest request) {
        this.user = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
        this.budget = user.getBudget();
    }

    @Override
    public ActionResponse process(){
        if ((budget == null)|| !(budget.getActive())){
            return new CalculateRemainingBudgetResponse(false, "");
        }
        ArrayList<String> categories = budget.getCategories();
        StringBuilder result = new StringBuilder("You have the following amounts left in each category: \n");
        for (String category : categories) {
            if (budget.getGoalBudget(category) != null) {
                Double goal = budget.getGoalBudget(category);
                Double actual = budget.getActualSpending(category);
                result.append(category);
                result.append(": ");
                result.append(goal - actual);
                result.append("\n");

            }
        }
        return new CalculateRemainingBudgetResponse(true, result.toString());

    }
}
