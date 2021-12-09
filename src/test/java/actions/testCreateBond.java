package actions;
import action_request_response.*;
import entity.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


public class testCreateBond {
    private Owner user;
    @BeforeEach
    public void setup(){
        OwnerRepository.getOwnerRepository().addOwner(new Owner("John Doe", "jd_123", "password"));
        user = OwnerRepository.getOwnerRepository().findOwner("jd_123");

        user.setBalance(2000);
    }

    @AfterEach
    public void teardown() {OwnerRepository.getOwnerRepository().deleteOwner("jd_123");}

    @Test
    public void testCreateBondSuccess(){
        ActionRequest request = new ActionRequest("jd_123", Commands.CREATEBOND,
                new ArrayList<>(List.of("Bond1", "1.2", "900","2","2022-01-01")));
        CreateBond result = new CreateBond(request);
        CreateBondResponse response = (CreateBondResponse) result.process();
        assertTrue(response.getResult());
        assertEquals(user.getBalance(),200);
        Date maturityDate = new Date(1, 1, 2022);
        NonDepositable expected = new Bond(2, 7.0, 900, maturityDate, "Bond1");
        for(FinancialAsset asset : user.getListAssets()){
            if(asset instanceof NonDepositable && Objects.equals(asset.getName(), "bond1")){
                assertEquals(asset.toString(), expected.toString());
            }
        }
    }

    @Test
    public void testCreateBondFailure(){
        ActionRequest request = new ActionRequest("jd_123", Commands.CREATEBOND,
                new ArrayList<>(List.of("Bond1", "1.2", "900","3","2022-01-01")));
        CreateBond result = new CreateBond(request);
        CreateBondResponse response = (CreateBondResponse) result.process();
        assertFalse(response.getResult());
        assertEquals(user.getBalance(),2000);
    }
}
