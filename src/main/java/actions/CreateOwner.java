package actions;

import action_request_response.ActionResponse;
import action_request_response.CreateUserRequest;
import action_request_response.CreateUserResponse;
import action_request_response.LoginResponse;
import entity.Owner;
import entity.OwnerRepository;

public class CreateOwner extends Actions {
    private final String fullName;
    private final String username;
    private final String password;

    public CreateOwner(CreateUserRequest request) {
        fullName = request.getFullname();
        username = request.getUsername();
        password = request.getPassword();
    }

    @Override
    public ActionResponse process() {
        System.out.println("CreateOwner processing");
        OwnerRepository ownerRepo = OwnerRepository.getOwnerRepository();
        Owner owner = new Owner(fullName, username, password);
        return new CreateUserResponse(ownerRepo.addOwner(owner));
    }

}
