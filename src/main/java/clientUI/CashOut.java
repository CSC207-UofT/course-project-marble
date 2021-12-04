package clientUI;

import action_request_response.ActionRequest;
import action_request_response.CashOutResponse;
import action_request_response.Commands;
import action_request_response.LoginResponse;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CashOut extends SendReceive{

    public CashOut(ObjectOutputStream outbound, ObjectInputStream inbound) {
        super(outbound, inbound);
    }
    public void Cashout(String username){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the name of the asset you want to cash out?");
        String name = sc.nextLine();
        ActionRequest request = new ActionRequest(username, Commands.CASHOUT, new ArrayList<>(List.of(name)));
        sendReceiveObject(request);
        if (response != null) {
            if (((CashOutResponse) response).getResult()) {
                System.out.println("You were successful");
            } else {
                System.out.println("You were not successful");
            }
        }
    }
}