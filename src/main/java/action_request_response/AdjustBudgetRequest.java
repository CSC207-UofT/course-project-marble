package action_request_response;

import java.util.HashMap;

public class AdjustBudgetRequest extends ActionRequest{
    private final HashMap<String, Double> newAdjustedBudget;

    public AdjustBudgetRequest(String username, HashMap<String, Double> newAdjustedBudget){
        super(username);
        this.newAdjustedBudget = newAdjustedBudget;

    }
    public HashMap<String, Double> getNewAdjustedBudget(){return this.newAdjustedBudget;}
}
