package action_request_response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginRequestTest {

    //there really isnt much to test other than getters on most of these
    @Test
    void getUsername() {
        LoginRequest login_req = new LoginRequest("username", "password");
        String user = login_req.getUsername();
        assertEquals("username", user);
    }

    @Test
    void getPassword() {
        LoginRequest login_req = new LoginRequest("username", "password");
        String pwd = login_req.getPassword();
        assertEquals("password", pwd);
    }
}