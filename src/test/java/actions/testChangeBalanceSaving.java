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

public class testChangeBalanceSaving {
    private Owner user;
    @BeforeEach
    public void setup(){
        OwnerRepository.getOwnerRepository().addOwner(new Owner("John Doe", "jd_123", "password"));
        user = OwnerRepository.getOwnerRepository().findOwner("jd_123");

        Date maturityDate = new Date(1, 1, 2022);

        Depositable assetSaving1 = new Savings(12.0, "Savings1");
        assetSaving1.setBalance(200);
        Depositable assetSaving2 = new Savings(12.0, "Savings2");
        assetSaving2.setBalance(300);
        NonDepositable assetBond = new Bond(2, 7.0, 1000, maturityDate, "Bond1");

        user.addAsset(assetSaving1);
        user.addAsset(assetSaving2);
        user.addAsset(assetBond);

        user.setBalance(1000);
    }

    @AfterEach
    public void teardown() {OwnerRepository.getOwnerRepository().deleteOwner("jd_123");}

    @Test
    public void testAddSavingSuccess(){
        ActionRequest request = new ActionRequest("jd_123", Commands.DEPOSITSAVINGS,
                new ArrayList<>(List.of("Savings1", "300")));
        ChangeBalanceSaving result = new ChangeBalanceSaving(request);
        DepositSavingResponse response = (DepositSavingResponse) result.process();
        assertTrue(response.getResult());
        for (FinancialAsset asset: user.getListAssets()){
            if(asset instanceof Savings && Objects.equals(asset.getName(), "Savings1")){
                assertEquals(((Savings) asset).getBalance(), 500);
            }
        }
        assertEquals(user.getBalance(), 700);
        assertTrue(response.getResult());
    }

    @Test
    public void testRemoveSavingSuccess(){
        ActionRequest request = new ActionRequest("jd_123", Commands.DEPOSITSAVINGS,
                new ArrayList<>(List.of("Savings2", "-150")));
        ChangeBalanceSaving result = new ChangeBalanceSaving(request);
        DepositSavingResponse response = (DepositSavingResponse) result.process();
        for (FinancialAsset asset: user.getListAssets()){
            if(asset instanceof Savings && Objects.equals(asset.getName(), "Savings2")){
                assertEquals(((Savings) asset).getBalance(), 150);
            }
        }
        assertEquals(user.getBalance(), 1150);
        assertTrue(response.getResult());
    }

    @Test
    public void testNullSavingFailure(){
        ActionRequest request = new ActionRequest("jd_123", Commands.DEPOSITSAVINGS,
                new ArrayList<>(List.of("Bond1", "200")));
        ChangeBalanceSaving result = new ChangeBalanceSaving(request);
        DepositSavingResponse response = (DepositSavingResponse) result.process();
        assertFalse(response.getResult());
        assertEquals(user.getBalance(), 1000);
    }

    @Test
    public void testChangeBalanceSavingFailure(){
        ActionRequest request = new ActionRequest("jd_123", Commands.DEPOSITSAVINGS,
                new ArrayList<>(List.of("Savings1", "-300")));
        ChangeBalanceSaving result = new ChangeBalanceSaving(request);
        DepositSavingResponse response = (DepositSavingResponse) result.process();
        assertFalse(response.getResult());
        assertEquals(user.getBalance(), 1000);
    }

}
