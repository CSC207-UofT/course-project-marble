package actions;

import action_request_response.ActionResponse;
import action_request_response.ActionRequest;
import action_request_response.ResetBudgetResponse;
import entity.Budget;
import entity.Owner;
import entity.OwnerRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class ResetBudget extends Actions{
    private Owner user;

    public ResetBudget(ActionRequest request){
        this.user = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());

    }

    @Override
    public ActionResponse process(){
//        Budget budget = this.user.getBudget();
//        HashMap<String, Double> remainingBudget = new HashMap<>(budget.getRemainingBudget());
//        budget.setRemainingBudget(budget.getGoalBudget());
//        double totalRemainingBudget = 0;
//        for(double value : remainingBudget.values()){
//            totalRemainingBudget +=  value;
//        }
//        System.out.println("This is the total remaining budget for last month: " + totalRemainingBudget);
//        user.addBudgetHistory(totalRemainingBudget);
//        return new ResetBudgetResponse(true);
        Budget budget = this.user.getBudget();
        ArrayList<String> categories = budget.getCategories();

        double totalRemainingBudget = 0;
        for(String category : categories){
            //budget.setActualBudget(category, 0);
            totalRemainingBudget += budget.getGoalBudget(category) - budget.getActualBudget(category);
        }
        System.out.println("This is the total remaining budget for last month: " + totalRemainingBudget);
        return new ResetBudgetResponse(true);
    }
}
