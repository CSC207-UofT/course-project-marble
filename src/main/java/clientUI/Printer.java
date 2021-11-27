package clientUI;

import java.util.Arrays;

public class Printer {
    public static void menu(){
        for (String s : Arrays.asList("\nHello. You may now enter the following:", "Get basic owner info: a", "Deposit enter: b", "Withdraw money: c", "View your deposit record history: d", "View your withdrawal record history: e", "View all of your assets: f", "Cash out a non-depositable asset: g", "Buy a new bond: h", "Create a new savings account: i", "Add or remove money from a Savings account : j", "To quit: q")) {
            System.out.println(s);
        }
    }
}
