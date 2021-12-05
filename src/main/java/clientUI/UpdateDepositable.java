package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UpdateDepositable extends SendReceive{

    public UpdateDepositable(ObjectOutputStream outbound, ObjectInputStream inbound) {
        super(outbound, inbound);
    }

    public void updateDepositable(String username){
        ActionRequest request = new ActionRequest(username, Commands.UPDATEDEPOSITABLE, new ArrayList<>());
        sendReceiveObject(request);
        if(response != null){
            System.out.println("You were successful");
        }
    }
}
