package entity;

public class Transaction {
    /**
     *
     */
    private final String date; // DD/MM/YYYY
    private final Owner owner;
    private final Account initAccount;
    private final Account targetAccount;
    private final String transactionType;
    private String transactionStatus;

    /**
     * @param date The date of the transaction
     * @param owner The owner that made the transaction
     * @param initAccount The account that the owner performed the transactions on
     * @param targetAccount The account that the transactions is targeting
     * @param transactionType The type of transactions: Deposit, Withdrawal, Transfer
     * @param transactionStatus The transaction status: Hold, Success
     */
    public Transaction(String date,
                       Owner owner,
                       Account initAccount,
                       Account targetAccount,
                       String transactionType,
                       String transactionStatus){

        this.date = date;
        this.owner = owner;
        this.initAccount = initAccount;
        this.targetAccount = targetAccount;
        this.transactionType = transactionType;
        this.transactionStatus = transactionStatus;
    }


    public String getDate(){return this.date;}
    public Owner getOwner(){return this.owner;}
    public Account getInitAccount(){return this.initAccount;}
    public Account getTargetAccount(){return this.targetAccount;}
    public String getTransactionType(){return this.transactionType;}
    public String getTransactionStatus(){return this.transactionStatus;}


    /**
     * This method lets you update the status of the transactions.
     * If it's Hold, it'll update to "Hold".
     * If it's Success, it'll update to "Success".
     * If it's neither, return false, else return true.
     * @param status is the status to update
     */
    public Boolean updateTransactionStatus(String status){
        String hold = "Hold";
        String success = "Success";
        if(status.equals(hold)){this.transactionStatus = hold;}
        else if(status.equals(success)){this.transactionStatus = success;}
        else{return false;}
        return true;
    }
}
