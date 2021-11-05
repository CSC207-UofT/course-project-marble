package actions;

import entity.Owner;

public class CheckBalance extends Actions {
    private Integer accountID;
    private final Owner owner;

    public CheckBalance(Owner owner) {
        this.owner = owner;
    }

    public CheckBalance(Owner owner, Integer accountID) {
        this.accountID = accountID;
        this.owner = owner;
    }

    /**
     * This method checks the owners total account balance of a specific account.
     *
     * @return return the balance of the owners account.
     */
    public int checkAccountBalance() {
        return this.owner.getAccounts().get(this.accountID).getBalance();
    }

    /**
     * This method checks the owners total account balance.
     *
     * @return return the total balance of the owners accounts.
     */
    public int checkTotalBalance() {
        int total = 0;
        for (Account account : this.owner.getAccounts().values()) {
            total += account.getBalance();
        }
        return total;
    }
}
