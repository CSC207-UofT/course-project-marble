package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;
import action_request_response.DisplayBudgetResponse;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DisplayBudget extends SendReceive {
    public DisplayBudget(ObjectOutputStream outbound, ObjectInputStream inbound) {
        super(outbound, inbound);
    }

    public void displayBudget(String username) {
        ActionRequest request = new ActionRequest(username, Commands.DISPLAYBUDGET, new ArrayList<>());
        sendReceiveObject(request);
        if (response != null) {
            System.out.println(((DisplayBudgetResponse) response).getResult());
        }
    }
}
