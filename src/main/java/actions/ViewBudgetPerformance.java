package actions;

import action_request_response.ActionResponse;
import action_request_response.ViewBudgetPerformanceResponse;
import entity.Date;
import entity.Owner;
import entity.OwnerRepository;
import action_request_response.ViewBudgetPerformanceRequest;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewBudgetPerformance extends Actions{

    private final Owner owner;


    public ViewBudgetPerformance(ViewBudgetPerformanceRequest request) {
        this.owner = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
    }

    /**
     * ViewBudgetPerformance returns a Hashmap of
     * ex: {January 1rst, 2021: {"food":[100, 110]}}, with 100 being the goal budget for that category period and -10
     * being the amount remaining for that category period. This means that the client went 10 over the limit.*/
    @Override
    public ActionResponse process(){
        HashMap<Date, HashMap<String, ArrayList<Double>>> budgetPerformance = new HashMap<Date, HashMap<String, ArrayList<Double>>>();

        for (Date period : owner.getBudget().getBudgetHistory().keySet()){
            for (String category: owner.getBudget().getBudgetHistory().get(period).getRemainingBudget().keySet()){
                budgetPerformance.put(period, new HashMap<>());
                budgetPerformance.get(period).put(category, new ArrayList<>() );
                budgetPerformance.get(period).get(category).add(owner.getBudget().getBudgetHistory().get(period).getGoalCategoryBudget(category));
                budgetPerformance.get(period).get(category).add
                        (owner.getBudget().getBudgetHistory().get(period).getGoalCategoryBudget(category) -
                                owner.getBudget().getBudgetHistory().get(period).getRemainingBudget().get(category));
            }
        }
        return new ViewBudgetPerformanceResponse(budgetPerformance.toString());
    }

    }

