package actions;

import clientUI.LoginRequest;
import entity.OwnerRepository;

public class CheckLogin {
    String username;
    String password;

    public CheckLogin(LoginRequest request) {
        this.username = request.getUsername();
        this.password = request.getPassword();
    }

    public boolean Process() {
        OwnerRepository ownerRepo = new OwnerRepository();
        boolean result = ownerRepo.loginCheck(username, password);
        return result;
    }
}
