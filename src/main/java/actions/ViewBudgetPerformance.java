package actions;

import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import action_request_response.ViewBudgetPerformanceResponse;
import entity.Owner;
import entity.OwnerRepository;

import java.util.HashMap;

public class ViewBudgetPerformance extends Actions{

    private final Owner owner;


    public ViewBudgetPerformance(ActionRequest request) {
        this.owner = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
    }

    /**
     * ViewBudgetPerformance returns a Hashmap of
     * ex: {January 1rst, 2021: {"food":-10, "clothes": 0, ...}, February 1rst, 2021: {"food": 0, "clothes": 10,...}...}
     * This means that in January, the client went over budget by $10 on food, and was on budget for clothes.
     * And in February, the client was on budget for food and went under budget by $10 on clothes.*/
    @Override
    public ActionResponse process(){
        HashMap<String, HashMap<String, Double>> budgetPerformance = new HashMap<>();

        for (String date : owner.getBudgetHistory().keySet()){
            for (String category: owner.getBudgetHistory().keySet()){
                budgetPerformance.put(owner.getBudget().getDate(), new HashMap<>());
                budgetPerformance.get(date).put(category,owner.getBudgetHistory().get(date).getGoalBudget(category)-
                        owner.getBudgetHistory().get(date).getActualBudget(category));
            }
        }
        return new ViewBudgetPerformanceResponse(budgetPerformance.toString());
    }

    }

