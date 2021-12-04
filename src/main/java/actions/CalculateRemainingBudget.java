package actions;
import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import action_request_response.CalculateRemainingBudgetResponse;
import entity.Budget;
import entity.Owner;
import entity.OwnerRepository;

public class CalculateRemainingBudget extends Actions {
    private Owner user;
    private Budget budget;

    public CalculateRemainingBudget(ActionRequest request) {
        this.user = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
        this.budget = user.getBudget();
    }

    @Override
    public ActionResponse process(){
        if ((budget == null)|| !(budget.getActive())){
            return new CalculateRemainingBudgetResponse(false);
        }
        double amountLeft = budget.getTotalRemainingBudget();
        return new CalculateRemainingBudgetResponse(true, amountLeft);

    }
}
