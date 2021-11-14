package actions;

import entity.Owner;
import action_request_response.ActionResponse;
import action_request_response.OwnerInfoRequest;
import action_request_response.OwnerInfoResponse;

import entity.OwnerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testOwnerInfo {
    private OwnerInfo callOwnerInfo;

    @BeforeEach
    public void setup(){
        Owner own = new Owner("Alice Liddell", "Liddy", "M@tHa!!3r");
        OwnerRepository.getOwnerRepository().addOwner(own);
        OwnerInfoRequest request = new OwnerInfoRequest("Liddy");
        callOwnerInfo = new OwnerInfo(request);
    }

    @AfterEach
    public void teardown(){
        OwnerRepository.getOwnerRepository().deleteOwner("Liddy");
    }

    @Test
    public void testInfoDisplayed(){
        String expected = "User Profile:\n Name: Alice Liddell" + "\n" +
                "Username: Liddy" + "\n" + "Balance: $0.0"  + "\n";
        ActionResponse result = callOwnerInfo.process();
        assertEquals(expected, ((OwnerInfoResponse)result).getDisplay());
    }
}
