package action_request_response;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginRequestTest {

    //there really isn't much to test other than getters on most of these
    @Test
    void getUsername() {
        ActionRequest login_req = new ActionRequest("username", Commands.LOGIN, new ArrayList<>(List.of("password")));
        String user = login_req.getUsername();
        assertEquals("username", user);
    }

    @Test
    void getPassword() {
        ActionRequest login_req = new ActionRequest("username", Commands.LOGIN, new ArrayList<>(List.of("password")));
        String pwd = login_req.getUserInputs().get(0);
        assertEquals("password", pwd);
    }
}