package actions;

import action_request_response.ActionResponse;
import action_request_response.AdjustBudgetRequest;
import action_request_response.AdjustBudgetResponse;
import entity.Budget;
import entity.Owner;
import entity.OwnerRepository;

import java.util.HashMap;

public class AdjustBudget extends Actions{
    private final Owner user;
    private final HashMap<String, Double> newAdjustedBudget;


    public AdjustBudget(AdjustBudgetRequest request){
        this.user = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
        this.newAdjustedBudget = request.getNewAdjustedBudget();
    }

    @Override
    public ActionResponse process(){
        Budget budget = this.user.getBudget();
        HashMap<String, Double> remainingBudget = new HashMap<>(budget.getRemainingBudget());
        HashMap<String, Double> goalBudget = new HashMap<>(budget.getGoalBudget());

        for(String key : this.newAdjustedBudget.keySet()){
            if (remainingBudget.get(key) + (this.newAdjustedBudget.get(key) -
                    goalBudget.get(key)) < 0) {
                System.out.println("Unable to adjust the budget. Please try again.");
                return new AdjustBudgetResponse(false);
            }
            remainingBudget.put(key, remainingBudget.get(key) +
                    (this.newAdjustedBudget.get(key) - goalBudget.get(key)));
        }
        budget.setGoalBudget(this.newAdjustedBudget);
        budget.setRemainingBudget(remainingBudget);
        return new AdjustBudgetResponse(true);
        }
    }

