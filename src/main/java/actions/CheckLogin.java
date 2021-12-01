package actions;

import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import action_request_response.LoginResponse;
import entity.Owner;
import entity.OwnerRepository;

import java.util.ArrayList;
import java.util.Iterator;

public class CheckLogin extends Actions {
    private final String username;
    private final String password;

    public CheckLogin(ActionRequest request) {
        username = request.getUsername();
        ArrayList<String> userInputs = request.getUserInputs();
        password = userInputs.get(0);
    }

    /**
     * Process is a method that Server calls to check if the username and the password matches with the data
     * stored here on OwnerRepository. It'll return True if the credential matches, otherwise false (e.g. wrong
     * password or user does not exist).
     */
    @Override
    public ActionResponse process() {
        System.out.println("CheckLogin processing");
        OwnerRepository ownerRepo = OwnerRepository.getOwnerRepository();
        Iterator<Owner> owners = ownerRepo.getOwners();
        while (owners.hasNext()) {
            Owner owner = owners.next();
            if (username.equals(owner.getUserName())) {
                return new LoginResponse(owner.comparePassword(password));
            }
        }
        return new LoginResponse(false);
    }

}
