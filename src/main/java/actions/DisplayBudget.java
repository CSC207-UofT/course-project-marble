package actions;

import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import action_request_response.DisplayBudgetResponse;
import entity.Budget;
import entity.Owner;
import entity.OwnerRepository;

/**
 * Class is responsible for returning a string of the User's
 * current budget (if they have one)
 */
public class DisplayBudget extends Actions {
    private final Owner user;
    private final Budget budget;

    public DisplayBudget(ActionRequest request) {
        this.user = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
        this.budget = user.getBudget();
    }

    @Override
    public ActionResponse process(){
        if ((budget == null) || !(budget.getActive())){
            return new DisplayBudgetResponse("There is no budget set.");
        }
        return new DisplayBudgetResponse(createDisplay());
    }

    /**
     * helper methods
     */
    public String createDisplay() {
        StringBuilder temp = new StringBuilder();
        double goal;
        double remaining;
        String display = "Budget Created on: " + budget.getDate() +
                "The total budget amount is: $" + getTotalBudget() +
                "Budget Broken Down:\n";

        for (String category : budget.getCategories()) {
            goal = budget.getGoalBudget(category);
            remaining = calculateRemaining(category);
            temp.append("\t Category Name: ").append(category).append("\n");
            temp.append("\t\t Goal Budget: $").append(goal).append("\n");
            temp.append("\t\t Remaining Budget Unspent: $").append(remaining).append("\n");
        }
        return display + temp;
    }

    public double getTotalBudget() {
        double total = 0;
        for (String category : budget.getCategories()) {
            total += budget.getGoalBudget((category));
        }
        return total;
    }

    public double calculateRemaining(String category) {
        return (budget.getGoalBudget(category) - budget.getActualBudget(category));
    }
}