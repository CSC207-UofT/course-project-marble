package clientUI;

import action_request_response.ActionResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SendReceive {
    private final ObjectOutputStream outbound;
    private final ObjectInputStream inbound;
    public ActionResponse response;

    public SendReceive(ObjectOutputStream outbound, ObjectInputStream inbound) {
        this.outbound = outbound;
        this.inbound = inbound;
    }

    public boolean sendReceiveObject(Object obj){
        try {
            outbound.writeObject(obj);
            outbound.flush();

            response = (ActionResponse) inbound.readObject();

            return true;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("There was an error. Please try again.");
            return false;
        }
    }
}
