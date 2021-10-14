package actions;
//potentially delete this class. undeeded
import action_request_response.LoginRequest;
import entity.Owner;
import server.OwnerRepository;

import java.util.Iterator;

public class CheckLogin {
    String username;
    String password;

    public CheckLogin(LoginRequest request) {
        this.username = request.getUsername();
        this.password = request.getPassword();
    }

    /**
     * Process is a method that Server calls to check if the username and the password matches with the data
     * stored here on OwnerRepository. It'll return True if the credential matches, otherwise false (e.g. wrong
     * password or user does not exist).
     * @return true if the password matches, return false if not
     */
    public boolean Process(){
        OwnerRepository ownerRepo = new OwnerRepository();
        Iterator owners = ownerRepo.getOwners();
        while (owners.hasNext()) {
            Owner owner = (Owner) owners.next();
            if (username.equals(owner.getUsername())) {
                return owner.comparePassword(password);
            }
        }
        return false;
    }

}
