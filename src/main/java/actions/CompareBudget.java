package actions;
import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import action_request_response.CompareBudgetResponse;
import entity.Budget;
import java.util.ArrayList;
import java.lang.StringBuilder;

/**
 * This class is responsible for handling the User request to compare their
 * budget with a standard ideal budget
 */
public class CompareBudget extends Actions{
    private final Budget budget = null;
    private final double total = Double.parseDouble(null);
    private final ArrayList<String> ruleBudget = null;

    /**
     *  Initializer for a CompareBudget object
     * @param request object containing all the information an object of
     *      *                the class needs to process and respond back
     */
    public CompareBudget(ActionRequest request){
    }

    /**
     * Method that processes the request
     * @return returns a response that should contain a string displaying
     * the two bugdets in a readable format to compare
     */
    @Override
    public ActionResponse process(){
        if (total == -1){
            return new CompareBudgetResponse("");
        } else {
            String display = format();
            return new CompareBudgetResponse(display);
        }
    }

    // helper function to create the String format that will be contained
    // in display
    private String format(){
        ArrayList<String> categories = budget.getCategories();
        StringBuilder display = new StringBuilder();
        display.append("Total Amount to Budget: $");
        display.append(total);
        display.append("\nBudget Based on 50/30/20 Rule: \nNeeds: $");
        display.append(ruleBudget.get(0));
        display.append("\nWants: $");
        display.append(ruleBudget.get(1));
        display.append("\nInvestment/Debt: $");
        display.append(ruleBudget.get(2));
        display.append("\nRemaining amount: $0.00 \n ---------------\n");
        display.append("Current Budget (from Categories written in):\n");
        for (String categoryName : categories) {
            display.append(categoryName);
            display.append(": $");
            display.append(budget.getGoalCategoryBudget(categoryName));
            display.append("\n");
        }
        return display.toString();
    }


}
