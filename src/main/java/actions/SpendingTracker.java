package actions;

import entity.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

public class SpendingTracker {
    private final ArrayList<TreeMap<Date, Integer>> expenseHistory;
    private final ExpenseType expenseType;

    /**
     * This is a constructor method used to keep track of a users spending of a particular expense.
     * @param type The type of expense the user is tracking.
     */
    public SpendingTracker(ExpenseType type){
        this.expenseHistory = new ArrayList<TreeMap<Date, Integer>>();
        this.expenseType = type;
    }

    public ArrayList<TreeMap<Date, Integer>> getExpenseHistory() {
        return this.expenseHistory;
    }

    public ExpenseType getExpenseType() {
        return this.expenseType;
    }

    /** This method updates and stores the expense history for when a payment is made for an expense
     */
    public boolean updateExpenseHistory(){
        this.expenseHistory.add(this.expenseType.getPaymentInfo());
        return true;
    }
}