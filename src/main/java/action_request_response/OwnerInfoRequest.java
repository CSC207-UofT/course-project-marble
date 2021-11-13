package action_request_response;
import entity.Owner;

public class OwnerInfoRequest extends ActionRequest{
    private final String fullname;
    private final double balance;
    public OwnerInfoRequest(Owner owner){
        super(owner.getUserName());
        fullname = owner.getName();
        balance = owner.getBalance();
    }

    public String getFullname() {
        return fullname;
    }
    public double getBalance() {
        return balance;
    }
}
