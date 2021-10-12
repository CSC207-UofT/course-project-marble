package clientUI;

public abstract class ActionRequest {
    String actionName;

    public ActionRequest(String actionName){
        this.actionName = actionName;
    }
}
