package actions;
import action_request_response.ActionResponse;
import action_request_response.AddExpenseRequest;
import action_request_response.AddExpenseResponse;
import entity.Budget;
import entity.Owner;
import entity.OwnerRepository;

import java.util.ArrayList;
/**
 * This class is responsible for handling the User request to attempt to add an
 * expense into their budget (if their budget exists)
 *
 * At the moment for phase 1 expenses only works if the category for the expense already
 * exists in the budget. Note it only adjusts the budget. Value in balance and
 * a record must be done separately by calling on different Actions by the user
 */
public class AddExpense extends Actions{
    private final Owner owner;
    private final String category;
    private final double amount;

    /**
     * Initializes an AddExpense object
     * @param request object containing all the information an object of
     *                the class needs to process and respond back
     */
    public AddExpense(AddExpenseRequest request){
        this.owner = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
        this.category = request.getCategory();
        this.amount = request.getAmount();
    }

    /**
     *
     * @return the response from attempted use of an object of this class
     */
    @Override
    public ActionResponse process(){
        if (owner.getBudget() == null){
            return new AddExpenseResponse(false);
        } else if (checkCategory(category, owner.getBudget())) {
            Budget budget = owner.getBudget();
            boolean result = budget.adjustOneCategoryInRemainingBudget(category, amount);
            return new AddExpenseResponse(result);
        } else {
            return new AddExpenseResponse(false);
        }
    }
    //helper function to see if category given in request exists
    private boolean checkCategory(String category, Budget budget){
        ArrayList<String> categories = budget.getCategories();
        return categories.contains(category);
    }

}
