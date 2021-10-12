package entity;

import java.util.ArrayList;
import java.util.Random;

public abstract class Account{
    private final int accountID;
    private int balance;
    private ArrayList<Transaction> transactionHistory;


    /**
     * This method takes in listOfAccountsID to prevent creating duplicated accountIDs. It loops until it generates a
     * totally random 9 digits integer that unique in the list and save that 9 digits integer as the accountID.
     * @param listOfAccountsID takes in a list of account IDs so that this initializer doesn't create a duplicated
     *                         account ID.
     */
    public Account(ArrayList<Integer> listOfAccountsID){
        while(true) {
            Random rnd = new Random();
            int n = 100000000 + rnd.nextInt(900000000);
            if (!listOfAccountsID.contains(n)) {
                this.accountID = n;
                break;
            }
        }
    }


    public int getAccountID() {
        return accountID;
    }


    public int getBalance(){
        return this.balance;
    }


    public boolean increaseBalance(int increasing){
        this.balance += increasing;
        return true;
    }


    public boolean decreaseBalance(int decreasing){
        if (this.balance - decreasing < 0){return false;}
        this.balance -= decreasing;
        return true;
    }
}
