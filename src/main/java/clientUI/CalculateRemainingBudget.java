package clientUI;

import action_request_response.ActionRequest;
import action_request_response.CalculateRemainingBudgetResponse;
import action_request_response.Commands;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CalculateRemainingBudget extends SendReceive {
    public CalculateRemainingBudget(ObjectOutputStream outbound, ObjectInputStream inbound) {
        super(outbound, inbound);
    }

    public void calculateRemainingBudget(String username) {
        ActionRequest request = new ActionRequest(username, Commands.CALCULATEREMAININGBUDGET, new ArrayList<>());
        sendReceiveObject(request);
        if (response != null) {
            System.out.println(((CalculateRemainingBudgetResponse) response).getResult());
        }
    }
}
