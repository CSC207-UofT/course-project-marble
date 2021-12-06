package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;
import action_request_response.OwnerInfoResponse;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class OwnerInfo extends SendReceive {

    public OwnerInfo(ObjectOutputStream outbound, ObjectInputStream inbound) {
        super(outbound, inbound);
    }

    public void ownerInfo(String username) {
        ActionRequest request = new ActionRequest(username, Commands.OWNERINFO, new ArrayList<>());
        sendReceiveObject(request);
        if (response != null) {
            System.out.println("Processing");
            System.out.println(((OwnerInfoResponse) response).getDisplay());
        }
    }
}
