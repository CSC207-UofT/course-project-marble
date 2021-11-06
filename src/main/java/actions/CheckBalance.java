package actions;

import entity.Owner;

public class CheckBalance extends Actions {
    private final Owner owner;

    public CheckBalance(Owner owner) {
        this.owner = owner;
    }

    /**
     * This method checks the owners total account balance.
     *
     * @return return the total balance of the owners accounts.
     */
    public int checkTotalBalance() {
        return owner.getBalance();
    }
}
