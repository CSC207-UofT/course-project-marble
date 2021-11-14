package action_request_response;
import entity.Owner;
import entity.OwnerRepository;

public class OwnerInfoRequest extends ActionRequest{
    private final String fullname;
    private final double balance;
    public OwnerInfoRequest(String username){
        super(username);
        fullname = OwnerRepository.getOwnerRepository().findOwner(username).getName();
        balance = OwnerRepository.getOwnerRepository().findOwner(username).getBalance();
    }

    public String getFullName() {
        return fullname;
    }
    public double getBalance() {
        return balance;
    }
}
