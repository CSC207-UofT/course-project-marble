package actions;

import entity.*;

public class ViewInvestments extends Actions{
    private Depositable account;

    public ViewInvestments(Depositable account){
        this.account = account;
    }

    /**
     * This method displays information on the Depositable accounts.
     * @return String of Depositable accounts.
     */
    public String displayDepositable(){
        StringBuilder display = new StringBuilder();
        UpdateDepositable update = new UpdateDepositable(account);
        if (account instanceof Savings){
            display.append(String.format("%-18s%-18s%-18s%-18s\n","Account Type","Date Created", "Current Balance",
                    "Annual Interest Rate"));
            display.append(String.format("%-18s%-18s%-18s%-18s\n","Savings",account.getDateCreated(), update.valueDepositable(),
                    account.getAnnualInterestRate()));
        }
        else{
            display.append(String.format("%-18s%-18s%-18s%-18s\n","Account Type","Date Created", "Current Balance",
                    "Annual Interest Rate"));
            display.append(String.format("%-18s%-18s%-18s%-18s\n","Credit",account.getDateCreated(), update.valueDepositable(),
                    account.getAnnualInterestRate()));
        }
        return display.toString();
    }
}
