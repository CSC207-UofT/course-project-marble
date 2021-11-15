package action_request_response;

public class StoreDataInJsonResponse extends ActionResponse{
    public final boolean result;

    /**
     * Constructor that creates a StoreDataInJsonResponse request that is used in the StoreDataInJson action
     *
     * @param result if data was actually stored or not
     */
    public StoreDataInJsonResponse(boolean result) {
        this.result = result;
    }

    public boolean getResult() {
        return this.result;
    }

}
