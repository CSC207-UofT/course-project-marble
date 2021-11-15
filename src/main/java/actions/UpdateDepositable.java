package actions;

import entity.Depositable;

import entity.Date;

public class UpdateDepositable extends Actions{
    private Depositable account;

    public UpdateDepositable(Depositable account) {
        this.account = account;
    }
    /**
     * This method calculates the current balance of Depositable account.
     */
    public void valueDepositable(Depositable asset){
        int numMonth = date.monthDifference(asset.getDateCreated());
        for(int i=0; i<numMonth;i++){
            asset.addInterest();
        }
    }

}
