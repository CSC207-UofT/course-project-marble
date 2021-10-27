package actions;

import entity.Owner;
import server.OwnerRepository;

public class CreateOwner extends Actions {
    private final String fullName;
    private final String username;
    private final String password;

    public CreateOwner(String fullName, String username, String password) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

    public boolean process() {
        OwnerRepository ownerRepo = OwnerRepository.getOwnerRepository();
        Owner owner = new Owner(fullName, username, password);
        return ownerRepo.addOwner(owner);
    }

}
