package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;
import action_request_response.SimulateResponse;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulate extends SendReceive{
    public Simulate(ObjectOutputStream outbound, ObjectInputStream inbound) {
        super(outbound, inbound);
    }
    public void simulate(String username){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the year to simulate the worth of asset");
        int year = Integer.parseInt(sc.nextLine());
        System.out.println("Please enter the month to simulate the worth of asset");
        int month = Integer.parseInt(sc.nextLine());
        System.out.println("Please enter the day to simulate the worth of asset");
        int day = Integer.parseInt(sc.nextLine());

        String strYear = "" + year;
        String strMonth = "" + month;
        String strDay = "" + day;

        String date = strYear + "-" + strMonth + "-" + strDay;

        ActionRequest request = new ActionRequest(username, Commands.SIMULATE, new ArrayList<>(List.of(date)));
        sendReceiveObject(request);
        if (response != null) {
            System.out.println(((SimulateResponse) response).getResult());
        }
    }
}
