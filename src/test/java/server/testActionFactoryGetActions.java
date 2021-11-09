package server;

import action_request_response.ActionRequest;
import action_request_response.CreateUserRequest;
import action_request_response.LoginRequest;
import action_request_response.UserQuitRequest;
import actions.Actions;
import actions.CheckLogin;
import actions.CreateOwner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testActionFactoryGetActions {
    private ActionFactory factory;

    @BeforeEach
    void setup() {
        this.factory = new ActionFactory();
    }

    @Test
    void loginRequest() {
        ActionRequest request = new LoginRequest("person1", "password1");
        Actions action = this.factory.getAction(request);
        assertTrue(action instanceof CheckLogin);
    }

    @Test
    void createUserRequest() {
        ActionRequest request = new CreateUserRequest("Person1", "person1", "password1");
        Actions action = this.factory.getAction(request);
        assertTrue(action instanceof CreateOwner);
    }

    @Test
    void requestWithNoAvailableAction() {
        ActionRequest request = new UserQuitRequest("person1");
        Actions action = this.factory.getAction(request);
        assertNull(action);
    }
}
