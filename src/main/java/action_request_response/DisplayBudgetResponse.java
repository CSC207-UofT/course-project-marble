package action_request_response;

public class DisplayBudgetResponse extends ActionResponse {
    private String result;

    public DisplayBudgetResponse(){
        this.result = "No Active or Existing Budget to View\n";
    }

    public DisplayBudgetResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
