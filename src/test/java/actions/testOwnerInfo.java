package actions;

import entity.Owner;
import action_request_response.ActionResponse;
import action_request_response.OwnerInfoRequest;
import action_request_response.OwnerInfoResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testOwnerInfo {
    private OwnerInfo callOwnerInfo;

    @BeforeEach
    public void setup(){
        Owner owner = new Owner("Alice Liddell", "Liddy", "M@tHa!!3r");
        OwnerInfoRequest request = new OwnerInfoRequest(owner);
        callOwnerInfo = new OwnerInfo(request);
    }

    @Test
    public void testInfoDisplayed(){
        String expected = "User Profile:\n Name: Alice Liddell" + "\n" +
                "Username: Liddy" + "\n" + "Balance: $0.0"  + "\n";
        ActionResponse result = callOwnerInfo.process();
        assertEquals(expected, ((OwnerInfoResponse)result).getDisplay());
    }
}
