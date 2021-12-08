package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;
import action_request_response.CompareBudgetResponse;
import action_request_response.ViewBudgetPerformanceResponse;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ViewBudgetPerformance extends SendReceive {
    public ViewBudgetPerformance(ObjectOutputStream outbound, ObjectInputStream inbound) {
        super(outbound, inbound);
    }

    public void viewBudgetPerformance(String username) {
        ActionRequest request = new ActionRequest(username, Commands.VIEWBUDGETPERFORMANCE, new ArrayList<>());
        sendReceiveObject(request);
        if (response != null) {
            System.out.println(((ViewBudgetPerformanceResponse) response).getDisplay());
        }
    }
}
