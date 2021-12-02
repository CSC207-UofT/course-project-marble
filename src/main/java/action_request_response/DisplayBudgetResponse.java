package action_request_response;

public class DisplayBudgetResponse extends ActionResponse {
    private final boolean possible;
    private String viewBudget;

    public DisplayBudgetResponse(boolean possible){
        this.possible = possible;
        this.viewBudget = "";
    }

    public DisplayBudgetResponse(boolean possible, String viewBudget) {
        this.possible = possible;
        this.viewBudget = viewBudget;
    }
}
