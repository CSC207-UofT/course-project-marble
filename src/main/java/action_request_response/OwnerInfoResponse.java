package action_request_response;

/**  Class is responsible for containing the String that
 * the user will see after their OwnerInfo request is processed
 */
public class OwnerInfoResponse extends ActionResponse{
    private final String display;

    /** Initializer
     *
     * @param display the String that will be shown to the user
     */
    public OwnerInfoResponse(String display){
        this.display = display;
    }

    public String getDisplay(){
        return display;
    }
}
