package action_request_response;

/**
 * Class is responsible for containing the information CashOut
 * uses to process a CashOut request
 */
public class CashOutRequest extends ActionRequest{
    private final String name;

    /** Initializer
     *
     * @param username username attached to the Owner object request is for
     * @param name The name of the asset.
     */
    public CashOutRequest(String username, String name){
        super(username);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
