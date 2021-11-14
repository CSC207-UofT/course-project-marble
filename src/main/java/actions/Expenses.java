package actions;
import action_request_response.ActionResponse;
import action_request_response.ExpensesRequest;
import action_request_response.ExpensesResponse;
import entity.Budget;
import entity.Owner;

import java.util.ArrayList;
/* Atm for phase 1 expenses only works if the category for the expense already
exists in the budget. Spending record needs to adjusted separately
 */
public class Expenses extends Actions{
    private final Owner owner;
    private final String category;
    private final double amount;
    public Expenses(ExpensesRequest request){
        this.owner = request.getOwner();
        this.category = request.getCategory();
        this.amount = request.getAmount();
    }

    @Override
    public ActionResponse process(){
        if (owner.getBudget() == null){
            return new ExpensesResponse(false);
        } else if (checkCategory(category, owner.getBudget())) {
            Budget budget = owner.getBudget();
            boolean result = budget.adjustOneCategoryInRemainingBudget(category, (int)amount);
            return new ExpensesResponse(result);
        } else {
            return new ExpensesResponse(false);
        }
    }

    private boolean checkCategory(String category, Budget budget){
        ArrayList<String> categories = budget.getCategories();
        if (categories.contains(category)){
            return true;
        }
        return false;
    };

}
