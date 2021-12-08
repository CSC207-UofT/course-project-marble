package actions;
import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import action_request_response.CompareBudgetResponse;
import entity.Budget;
import entity.Owner;
import entity.OwnerRepository;

import java.util.ArrayList;
import java.lang.StringBuilder;

/**
 * This class is responsible for handling the User request to compare their
 * budget with a standard ideal budget
 */
public class CompareBudget extends Actions{
    private final Owner user;
    private final Budget budget;

    /**
     *  Initializer for a CompareBudget object
     * @param request object containing all the information an object of
     *      *                the class needs to process and respond back
     */
    public CompareBudget(ActionRequest request){
        this.user = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
        this.budget = user.getBudget();
    }

    /**
     * Method that processes the request
     * @return returns a response that should contain a string displaying
     * the two bugdets in a readable format to compare
     */
    @Override
    public ActionResponse process(){
        if ((budget == null) || !(budget.getActive())){
            return new CompareBudgetResponse("");
        }
        double total = calculateTotal();
        ArrayList<String> ruleBudget = calculateOptimal(total);
        String display = format(total, ruleBudget);
        return new CompareBudgetResponse(display);
    }

    // helper function to create the String format that will be contained
    // in display
    private String format(double total, ArrayList<String> ruleBudget){
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
            display.append(budget.getGoalBudget(categoryName));
            display.append("\n");
        }
        return display.toString();
    }

    //helper method to calculate the amount of money a budget has to work with
    private double calculateTotal() {
        ArrayList<String> categories = budget.getCategories();
        double total = 0;
        for (String category : categories) {
            total += budget.getGoalBudget(category);
        }
        return total;
    }

    //helper method to calculate the ideal allocation of total budget
    private ArrayList<String> calculateOptimal(double total){
        ArrayList<String> optimal = new ArrayList<>();
        optimal.add(String.valueOf(total*0.5));
        optimal.add(String.valueOf(total*0.3));
        optimal.add(String.valueOf(total*0.2));
        return optimal;
    }


}
