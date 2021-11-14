package action_request_response;

public class CompareBudgetResponse extends ActionResponse{
    private final String display;
    public CompareBudgetResponse(String display){
        this.display = display;
    }

    public String getDisplay(){
        if (display.equals("")){
            return "No Budget Formed to Compare";
        } else {
            return display;
        }
    }
}
