package action_request_response;

public class ViewInvestmentsResponse extends ActionResponse {
    private final String result;

    public ViewInvestmentsResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return this.result;
    }
}
