package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;

import java.util.ArrayList;

public class DisplayWithdrawalRecord {
    public ActionRequest displayWithdrawalRecord(String username){
        return new ActionRequest(username, Commands.DISPLAYWITHDRAWALRECORD, new ArrayList<>());
    }
}
