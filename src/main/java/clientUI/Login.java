package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;
import action_request_response.LoginResponse;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login extends SendReceive{

    public Login(ObjectOutputStream outbound, ObjectInputStream inbound) {
        super(outbound, inbound);
    }

    public String login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your username");
        String username = sc.nextLine();
        System.out.println("Please enter your password");
        String password = sc.nextLine();
        ActionRequest request = new ActionRequest(username, Commands.LOGIN, new ArrayList<>(List.of(password)));
        sendReceiveObject(request);
        if (response != null) {
            if (((LoginResponse) response).getResult()) {
                System.out.println("Login successful!");
                return username;
            } else {
                System.out.println("Login Failed. Please try again.");
                return null;
            }
        }
        return null;
    }

}
