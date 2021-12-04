package action_request_response;

import java.util.ArrayList;

public class ViewBudgetPerformanceRequest extends ActionRequest{
    private final ArrayList<Integer> budgetHistory;
    /**
     * Constructor that creates an instance of ActionRequest given a username
     *
     * @param username String username of the user
     * @param budgetHistory
     */
    public ViewBudgetPerformanceRequest(String username, ArrayList<Integer> budgetHistory) {
        super(username);

        this.budgetHistory = budgetHistory;
    }

    public ArrayList<Integer> getBudgetHistory(){
        return budgetHistory;
    }
}
