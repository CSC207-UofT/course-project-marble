package actions;

import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import action_request_response.ActivateBudgetResponse;
import action_request_response.AdjustBudgetResponse;
import entity.Budget;
import entity.Owner;
import entity.OwnerRepository;

import javax.swing.*;
import java.util.ArrayList;

public class ActivateBudget extends Actions {

    private final Owner user;


    public ActivateBudget(ActionRequest request){
        this.user = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
    }

    /**False response means the Budget is deactivated.
     * True response means the Budget is activated.*/
    @Override
    public ActivateBudgetResponse process(){
        Budget budget = this.user.getBudget();
        if (budget.getActive()){
            budget.setActive(false);
            return new ActivateBudgetResponse(false);
        }
        budget.setActive(true);
        return new ActivateBudgetResponse(true);
    }

}
