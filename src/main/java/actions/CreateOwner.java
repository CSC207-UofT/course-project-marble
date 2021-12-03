package actions;

import action_request_response.ActionRequest;
import action_request_response.ActionResponse;
import action_request_response.CreateUserResponse;
import entity.Owner;
import entity.OwnerRepository;

import java.util.ArrayList;

public class CreateOwner extends Actions {
    private final String fullName;
    private final String username;
    private final String password;

    public CreateOwner(ActionRequest request) {
        username = request.getUsername();
        ArrayList<String> userInputs = request.getUserInputs();
        fullName = userInputs.get(0);
        password = userInputs.get(1);
    }

    @Override
    public ActionResponse process() {
        System.out.println("CreateOwner processing");
        OwnerRepository ownerRepo = OwnerRepository.getOwnerRepository();
        Owner owner = new Owner(fullName, username, password);
        return new CreateUserResponse(ownerRepo.addOwner(owner));
    }

}
