package action_request_response;

/**
 * Class is responsible for getting the information
 * OwnerInfo needs to process a request
 */
public class OwnerInfoRequest extends ActionRequest {


    /**
     * Initializer
     *
     * @param username username of the Owner the request is for
     */
    public OwnerInfoRequest(String username) {
        super(username);
    }
}
