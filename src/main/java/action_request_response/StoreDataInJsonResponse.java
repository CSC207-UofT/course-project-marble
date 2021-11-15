package action_request_response;

public class StoreDataInJsonResponse extends ActionResponse{
    public final boolean result;

    public StoreDataInJsonResponse(boolean result) {
        this.result = result;
    }

    public boolean getResult() {
        return this.result;
    }

}
