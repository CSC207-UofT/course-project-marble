package actions;

import entity.*;

public class ViewInvestments{
    private Depositable account;

    public ViewInvestments(Depositable account){
        this.account = account;
    }

    /**
     * This method displays information on the Depositable accounts.
     */
    public void displayDepositable(){
        UpdateDepositable update = new UpdateDepositable(account);
        if (account instanceof Savings){
            System.out.printf("%-18s%-18s%-18s%-18s\n","Account Type","Date Created", "Current Balance",
                    "Annual Interest Rate");
            System.out.printf("%-18s%-18s%-18s%-18s\n","Savings",account.getDateCreated(), update.valueDepositable(),
                    account.getAnnualInterestRate());
        }
        else{
            System.out.printf("%-18s%-18s%-18s%-18s\n","Account Type","Date Created", "Current Balance",
                    "Annual Interest Rate");
            System.out.printf("%-18s%-18s%-18s%-18s\n","Credit",account.getDateCreated(), update.valueDepositable(),
                    account.getAnnualInterestRate());
        }

    }
}
