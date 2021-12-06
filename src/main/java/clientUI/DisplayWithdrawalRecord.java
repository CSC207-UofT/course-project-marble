package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;
import action_request_response.DisplayWithdrawalRecordResponse;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DisplayWithdrawalRecord extends SendReceive {

    public DisplayWithdrawalRecord(ObjectOutputStream outbound, ObjectInputStream inbound) {
        super(outbound, inbound);
    }

    public void displayWithdrawalRecord(String username) {
        ActionRequest request = new ActionRequest(username, Commands.DISPLAYWITHDRAWALRECORD, new ArrayList<>());
        sendReceiveObject(request);
        if (response != null) {
            System.out.println(((DisplayWithdrawalRecordResponse) response).getResult());
        }
    }
}
