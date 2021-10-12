package entity;

import java.util.ArrayList;

public class Saving extends Account{
    /**
     * TODO: setup a way for the bank to adjust the interestRate
     */
    private int interestRate;

    public Saving(ArrayList<Integer> listOfAccountsID) {
        super(listOfAccountsID);
    }


    /**
     * get the interest rate of the savings account
     * @return the current interest rate
     */
    public int getInterestRate() {
        return interestRate;
    }
}
