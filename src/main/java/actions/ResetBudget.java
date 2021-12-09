package actions;

import action_request_response.ActionResponse;
import action_request_response.ActionRequest;
import action_request_response.ResetBudgetResponse;
import entity.Budget;
import entity.Owner;
import entity.OwnerRepository;

import java.util.ArrayList;

public class ResetBudget extends Actions{
    private final Owner user;

    public ResetBudget(ActionRequest request){
        this.user = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
    }

    @Override
    public ActionResponse process(){
        Budget budget = this.user.getBudget();
        String budgetCopy = budget.toString();
        ArrayList<String> categories = budget.getCategories();
        if (!(budget.getActive())){
            return new ResetBudgetResponse(false, 0.0);
        }
        double totalRemainingBudget = 0;
        for(String category : categories){
            totalRemainingBudget += budget.getGoalBudget(category) - budget.getActualSpending(category);
            budget.setActualSpending(category, 0.0);
        }
        user.addBudgetHistory(budget.getDate(), budgetCopy);
        return new ResetBudgetResponse(true, totalRemainingBudget);
    }
}