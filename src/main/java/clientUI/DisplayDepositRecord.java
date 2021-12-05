package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;
import action_request_response.DisplayDepositRecordResponse;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DisplayDepositRecord extends SendReceive{

    public DisplayDepositRecord(ObjectOutputStream outbound, ObjectInputStream inbound) {
        super(outbound, inbound);
    }

    public void displayDepositRecord(String username){
        ActionRequest request = new ActionRequest(username, Commands.DISPLAYDEPOSITRECCORD, new ArrayList<>());
        sendReceiveObject(request);
        if (response != null){
            System.out.println(((DisplayDepositRecordResponse)response).getResult());
        }
    }
}
