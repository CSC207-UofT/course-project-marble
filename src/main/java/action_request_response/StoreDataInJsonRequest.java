package action_request_response;

public class StoreDataInJsonRequest extends ActionRequest{

    /**
     * Constructor that creates an instance of ActionRequest given a fileName that will used in StoreDataJson Action
     *
     * @param fileName is the name of the file the data will be stored at
     */
    public StoreDataInJsonRequest(String fileName) {
        super(fileName);
    }
}
