package actions;
import action_request_response.ActionResponse;
import action_request_response.CompareBudgetRequest;
import action_request_response.CompareBudgetResponse;
import entity.Budget;
import java.util.ArrayList;

public class CompareBudget extends Actions{
    private final Budget budget;
    private final double total;
    private final ArrayList<String> ruleBudget;

    public CompareBudget(CompareBudgetRequest request){
        budget = request.getBudget();
        total = request.getTotal();
        ruleBudget = request.getRuleBudget();
    }

    @Override
    public ActionResponse process(){
        if (total == -1){
            return new CompareBudgetResponse("");
        } else {
            String display = format();
            return new CompareBudgetResponse(display);
        }
    }



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
