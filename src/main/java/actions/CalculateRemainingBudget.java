package actions;
import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import action_request_response.CalculateRemainingBudgetResponse;
import entity.Budget;
import entity.Owner;
import entity.OwnerRepository;

import java.util.ArrayList;

public class CalculateRemainingBudget extends Actions {
    private Owner user;
    private Budget budget;

    public CalculateRemainingBudget(ActionRequest request) {
        this.user = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
        this.budget = user.getBudget();
    }

    @Override
    public ActionResponse process(){
        if ((budget == null)|| !(budget.getActive())){
            return new CalculateRemainingBudgetResponse(false);
        }
        ArrayList<String> categories = budget.getCategories();
        double amountLeft = 0;
        double goal;
        double actual;
        for (String category : categories) {
            if (budget.getGoalBudget(category) != null) {
                goal = budget.getGoalBudget(category);
                actual = budget.getActualBudget(category);
                amountLeft = amountLeft + goal - actual;
            }
        }
        return new CalculateRemainingBudgetResponse(true, amountLeft);

    }
}
