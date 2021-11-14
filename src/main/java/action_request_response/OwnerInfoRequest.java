package action_request_response;
import entity.OwnerRepository;

/** Class is responsible for getting the information
 * OwnerInfo needs to process a request
 */
public class OwnerInfoRequest extends ActionRequest{
    private final String fullname;
    private final double balance;

    /**Initializer
     *
     * @param username username of the Owner the request is for
     */
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
