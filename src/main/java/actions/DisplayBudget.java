package actions;
import action_request_response.ActionRequest;
import action_request_response.ActionResponse;

import action_request_response.DisplayBudgetResponse;
import entity.Budget;
import entity.OwnerRepository;

/**
 * Class is responsible for returning a string of the User's
 * current budget (if they have one)
 */
public class DisplayBudget extends Actions {
    private final Budget budget;

    public DisplayBudget(ActionRequest request) {
        this.budget = OwnerRepository.getOwnerRepository().findOwner(request.getUsername()).getBudget();
    }

    @Override
    public ActionResponse process() {
        String result;
        if ((budget == null) || (!budget.getActive())) {
            result = "No Active or Existing Budget to View";
        } else {
            result = "Budget Created on: " + budget.getDate().toString() + "\n" +
                    "The total budget amount is: $" + getTotalBudget() + "\n" + budget;
        }
        return new DisplayBudgetResponse(result);
    }

    public double getTotalBudget() {
        double total = 0.0;
        for (String category : budget.getCategories()) {
            total += budget.getGoalBudget((category));
        }
        return total;
    }

}