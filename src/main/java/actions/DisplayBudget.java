package actions;
import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import action_request_response.AddExpenseResponse;
import action_request_response.DisplayBudgetResponse;
import entity.Budget;
import entity.Owner;
import entity.OwnerRepository;

/**
 * Class is responsible for returning a string of the User's
 * current budget (if they have one)
 */
public class DisplayBudget extends Actions {
    private Owner user;
    private Budget budget;

    public DisplayBudget(ActionRequest request) {
        this.user = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
        this.budget = user.getBudget();
    }

    /**
     * helper methods
     */
    public String createDisplay() {
        StringBuilder display = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        double goal = 0;
        double remaining = 0;
        display.append("Budget Created on: " + budget.getDate());
        display.append("The total budget amount is: $" + getTotalBudget());
        display.append("Budget Broken Down:\n");

        for (String category : budget.getCategories()) {
            goal = budget.getGoalBudget(category);
            remaining = calculateRemaining(category);
            temp.append("\t Category Name: " + category + "\n");
            temp.append("\t\t Goal Budget: $" + goal + "\n");
            temp.append("\t\t Remaining Budget Unspent: $" + remaining + "\n");
        }
        return display.toString();
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