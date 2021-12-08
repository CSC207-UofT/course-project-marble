package action_request_response;

public class DisplayBudgetResponse extends ActionResponse {
    private String result;

    public DisplayBudgetResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
