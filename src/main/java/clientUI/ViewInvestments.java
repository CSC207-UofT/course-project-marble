package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;
import action_request_response.ViewInvestmentsResponse;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ViewInvestments extends SendReceive {

    public ViewInvestments(ObjectOutputStream outbound, ObjectInputStream inbound) {
        super(outbound, inbound);
    }

    public void viewInvestment(String username) {
        ActionRequest request = new ActionRequest(username, Commands.VIEWINVESTMENTS, new ArrayList<>());
        sendReceiveObject(request);
        if (response != null) {
            System.out.println(((ViewInvestmentsResponse) response).getResult());
        }
    }
}
