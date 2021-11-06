package entity;

import java.util.Date;
import java.util.TreeMap;

public abstract class ExpenseType {
    private final Date date; // DD/MM/YYYY
    private final TreeMap<Date, Integer> paymentInfo;
    private int budget;

    /**
     * This is a constructor method for an abstract class of expenses. Used as an entity when keeping
     * track of user spending.
     */
    public ExpenseType(){
        this.date = new Date();
        this.paymentInfo = new TreeMap<Date, Integer>();
    }

    public TreeMap<Date, Integer> getPaymentInfo() {
        return this.paymentInfo;
    }

    public Date getDate() {
        return this.date;
    }

    /**
     * This method updates the payment information TreeMap when a payment is made toward an expense.
     * @param payment the amount that was spent toward the expense.
     */
    public void updatePaymentInfo(int payment){
        this.paymentInfo.put(this.date, payment);
    }

    public abstract void setBudget(int budget);  // hook method

    /**
     * This method updates the users budget towards an expense.
     * @param payment the amount that was spent toward the expense.
     * @return returns true if the payment toward the expenses is possible.
     */
    public boolean updateBudget(int payment) {
        if (payment < this.budget) {
            this.budget -= payment;
            return true;
        } else {
            return false;
        }
    }
    /** template method */
    public void makePayment(int payment, int budget){
        setBudget(budget);
        if (updateBudget(payment)){
            updatePaymentInfo(payment);
        } else {
            System.out.println("Unable to make payment. Over budget!");  // remove once UI is implemented
        }
    }
}
