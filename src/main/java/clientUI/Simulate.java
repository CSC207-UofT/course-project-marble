package clientUI;

import action_request_response.ActionRequest;
import action_request_response.CashOutResponse;
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

        String str_year = "0000" + year;
        str_year = str_year.substring(str_year.length() - 4);

        String str_month = "0" + month;
        str_month = str_month.substring(str_month.length() - 2);

        String str_day = "0" + day;
        str_day = str_day.substring(str_day.length() - 2);

        String date = str_year + "-" + str_month + "-" + str_day;

        ActionRequest request = new ActionRequest(username, Commands.SIMULATE, new ArrayList<>(List.of(date)));
        sendReceiveObject(request);
        if (response != null) {
            System.out.println(((SimulateResponse) response).getResult());
        }
    }
}
