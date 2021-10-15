package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public abstract class Account {
    private int balance;
    private final int accountID;
    private final ArrayList<Transaction> transactionHistory;
    private final Date dateCreated;


    /**
     * This method takes in listOfAccountsID to prevent creating duplicated accountIDs. It loops until it generates a
     * totally random 9 digits integer that unique in the list and save that 9 digits integer as the accountID.
     *
     * @param listOfAccountsID takes in a list of account IDs so that this initializer doesn't create a duplicated
     *                         account ID.
     */
    public Account(ArrayList<Integer> listOfAccountsID) {
        this.dateCreated = new Date();
        this.transactionHistory = new ArrayList<>();
        while (true) {
            Random rnd = new Random();
            int n = 100000000 + rnd.nextInt(900000000);
            if (!listOfAccountsID.contains(n)) {
                this.accountID = n;
                break;
            }
        }
    }


    /**
     * Add a single transaction under this account
     *
     * @param transaction takes in a Transaction object
     * @return true if it's added successfully, else false(?)
     */
    public boolean addTransactionHistory(Transaction transaction) {
        this.transactionHistory.add(transaction);
        return true;
    }


    /**
     * Get the ArrayList of the transactionHistory
     *
     * @return an ArrayList with Transaction object at each element
     */
    public ArrayList<Transaction> getTransactionHistoryArray() {
        return transactionHistory;
    }


    public Date getAccountCreationDate() {
        return this.dateCreated;
    }


    public int getAccountID() {
        return accountID;
    }


    public int getBalance() {
        return this.balance;
    }


    /**
     * takes in an int to add to the balance.
     *
     * @param increasing the amount to increase the balance
     * @return true when the process is successful. Unable to fail.
     */
    public boolean increaseBalance(int increasing) {
        this.balance += increasing;
        return true;
    }


    /**
     * takes in an int, decrease the set amount if there's enough balance. Else it returns false
     *
     * @param decreasing the amount to decrease the balance
     * @return true when the process is successful. Else return false if there's not enough balance.
     */
    public boolean decreaseBalance(int decreasing) {
        if (this.balance - decreasing < 0) {
            return false;
        }
        this.balance -= decreasing;
        return true;
    }
}
