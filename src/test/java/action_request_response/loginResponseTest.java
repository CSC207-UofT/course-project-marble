package action_request_response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class loginResponseTest {
    @Test
    void getUsernameTrueResult() {
        LoginResponse loginResponse = new LoginResponse(true);
        boolean result = loginResponse.getResult();
        assertTrue(result);
    }

    @Test
    void getUsernameFalseResult() {
        LoginResponse loginResponse = new LoginResponse(false);
        boolean result = loginResponse.getResult();
        assertFalse(result);
    }
}
