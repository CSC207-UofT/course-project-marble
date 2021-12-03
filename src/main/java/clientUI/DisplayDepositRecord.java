package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;

import java.util.ArrayList;

public class DisplayDepositRecord {
    public ActionRequest displayDepositRecord(String username){
        return new ActionRequest(username, Commands.DISPLAYDEPOSITRECCORD, new ArrayList<>());
    }
}
