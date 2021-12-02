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
    private Owner user;
    private Budget budget;

    public DisplayBudget(ActionRequest request) {
        this.user = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
        this.budget = user.getBudget();
    }

    @Override
    public ActionResponse process() {
        if (!(budget.getActive()) || (budget == null)) {
            return (new DisplayBudgetResponse());
        }
        String display = createDisplay(budget);
        return (new DisplayBudgetResponse(display));
    }

    //helper method to create the complete budget the user will see
    private String createDisplay(Budget budget){
        StringBuilder display = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        double goal = 0;
        double remaining = 0;
        display.append("Budget Created on: " + budget.getDate().toString());
        display.append("Period of Budget " + budget.getPeriod());
        display.append("The total budget amount is: $" + budget.getTotalBudget());
        display.append("Budget Broken Down:\n");

        for (String category : budget.getCategories()) {
            goal = budget.getGoalCategoryBudget(category);
            remaining = budget.getRemainingCategoryBudget(category);
            temp.append("\t Category Name: " + category + "\n");
            temp.append("\t\t Goal Budget: $" + goal + "\n");
            temp.append("\t\t Remaining Budget: $" + remaining + "\n");
        }
        return display.toString();
    }

}
