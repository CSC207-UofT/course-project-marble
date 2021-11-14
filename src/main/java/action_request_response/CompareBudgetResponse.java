package action_request_response;

/**
 * Class is responsible for containing data on the CompareBudget
 * object created to display
 */
public class CompareBudgetResponse extends ActionResponse{
    private final String display;

    /**Initializer
     *
     * @param display String that will be shown to User
     */
    public CompareBudgetResponse(String display){
        this.display = display;
    }

    public String getDisplay(){
        if (display.equals("")){
            return "No Budget Formed to Compare\n";
        } else {
            return display;
        }
    }
}
