package clientUI;

import action_request_response.ActionRequest;
import action_request_response.CashOutResponse;
import action_request_response.Commands;
import action_request_response.SimulateResponse;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulate extends SendReceive{
    public Simulate(ObjectOutputStream outbound, ObjectInputStream inbound) {
        super(outbound, inbound);
    }
    public void simulate(String username){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a date to simulate the worth of asset.");
        String endDate = sc.nextLine();
        ActionRequest request = new ActionRequest(username, Commands.SIMULATE, new ArrayList<>());
        sendReceiveObject(request);
        if (response != null) {
            System.out.println(((SimulateResponse) response).getResult());
        }
    }
}
