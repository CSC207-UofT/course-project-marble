import action_request_response.LoginRequest;
import actions.CheckLogin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import server.OwnerRepository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckLoginTest {
    OwnerRepository ownerRepo;

    @Before
    public void setUp() {
        ownerRepo = OwnerRepository.getOwnerRepository();
        ownerRepo.createOwner("Name1", "User1", "password");
    }

    @Test(timeout = 200)
    public void testCheckLoginCorrectInfo() {
        LoginRequest request = new LoginRequest("User1", "password");
        CheckLogin ck = new CheckLogin(request);
        System.out.println(ck.process());
        assertTrue(ck.process());
    }

    @Test(timeout = 200)
    public void testCheckLoginIncorrectUsername() {
        LoginRequest request = new LoginRequest("User2", "password");
        CheckLogin ck = new CheckLogin(request);
        assertFalse(ck.process());
    }

    @Test(timeout = 200)
    public void testCheckLoginIncorrectPassword() {
        LoginRequest request = new LoginRequest("User1", "pass");
        CheckLogin ck = new CheckLogin(request);
        assertFalse(ck.process());
    }

    @After
    public void tearDown() {
        ownerRepo.deleteOwner("User1");
    }

}
