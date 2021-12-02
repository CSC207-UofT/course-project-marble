package actions;
import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import action_request_response.AddExpenseResponse;
import entity.Budget;
import entity.Owner;
import entity.OwnerRepository;

/**
 * Class is responsible for returning a string of the User's
 * current budget (if they have one)
 */
public class DisplayBudget extends Actions {
    private Owner user;
    private Budget budget;

    public DisplayBudget(ActionRequest request) {
        this.user = OwnerRepository.getOwnerRepository().findOwner(request.getUsername());
        this.budget = user.getBudget();
    }

}
