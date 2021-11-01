package actions;

import action_request_response.CreateUserRequest;
import entity.Owner;
import server.OwnerRepository;

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
    public boolean process() {
        System.out.println("CreateOwner processing");
        OwnerRepository ownerRepo = OwnerRepository.getOwnerRepository();
        Owner owner = new Owner(fullName, username, password);
        return ownerRepo.addOwner(owner);
    }

}
