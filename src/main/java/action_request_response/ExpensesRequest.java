package action_request_response;

import entity.Owner;

public class ExpensesRequest extends ActionRequest{
    private final Owner owner;
    private final String category;
    private final double amount;

    public ExpensesRequest(Owner owner, String category, double amount){
        super(owner.getUserName());
        this.owner = owner;
        this.category = category;
        this.amount = amount;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }
}
