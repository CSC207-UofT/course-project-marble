package actions;
import entity.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testWithdrawal {
    private Owner user;

    @BeforeEach
    public void setup() {
        user = new Owner("John Doe", "jd_123", "password");
        user.setBalance(1000);
    }

    @Test
    public void testWithdrawSuccess(){
        Withdrawal userWithdrawal = new Withdrawal(user);
        assertTrue(userWithdrawal.withdraw(200));
        assertEquals(800, user.getBalance());
    }
    @Test
    public void testWithdrawFailure(){
        Withdrawal userWithdrawal = new Withdrawal(user);
        assertFalse(userWithdrawal.withdraw(2000));
        assertEquals(1000, user.getBalance());
    }
}
