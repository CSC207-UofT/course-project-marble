package actions;
import action_request_response.ActionResponse;
import action_request_response.CompareBudgetRequest;
import action_request_response.CompareBudgetResponse;
import entity.Budget;
import java.util.ArrayList;

public class CompareBudget extends Actions{
    private final Budget budget;
    private final int total;
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
        String display = "Total Amount to Budget: " + Integer.toString(total) + "\n";
        display = display + "Budget Based on 50/30/20 Rule: \n" +
                "Needs: $" + ruleBudget.get(0) + "\n" +
                "Wants: $" + ruleBudget.get(1) + "\n" +
                "Investment/Debt: $" + ruleBudget.get(2) + "\n" +
                "Remaining amount: $0.00 \n --------------- \n";
        display = display + "Current Budget (from Categories written in):" + "\n";
        for (int i = 0; i < categories.size(); i++){
            String categoryName = categories.get(i);
            display = display + categoryName + ": $" +
                    budget.getGoalCategoryBudget(categoryName) + "\n";
        }
        return display;
    }


}
