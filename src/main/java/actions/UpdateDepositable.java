package actions;

import entity.Depositable;

import entity.Date;

public class UpdateDepositable{
    private Depositable account;

    public UpdateDepositable(Depositable account) {
        this.account = account;
    }
    /**
     * This method calculates the current balance of Depositable accounts.
     * @return balance of Depositable account.
     */
    public double valueDepositable(){
        Date d = new Date();
        int numMonth = d.monthDifference(account.getDateCreated());
        for(int i=0; i<numMonth;i++){
            account.addInterest();
        }
        return account.getBalance();
    }

}
