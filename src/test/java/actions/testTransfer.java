package actions;
import entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class testTransfer {
    private Owner user;
    private Savings account1;
    private CreditCard account2;

    @BeforeEach
    public void setup() {
        user = new Owner("John Doe", "jd_123", "password");
        account1 = new Savings(2.4, "Savings1");
        account2 = new CreditCard("CreditCard1");
        user.setBalance(1000);
        account1.setBalance(2000);
        account2.setBalance(-1567);

    }

    @Test
    public void testTransferBalanceSuccess(){
        Transfer userTransfer = new Transfer(user);
        assertTrue(userTransfer.transferBalance(200, account1));
        assertEquals(800, user.getBalance());
        assertEquals(2200, account1.getBalance());

    }
    @Test
    public void testTransferBalanceFail(){
        Transfer userTransfer = new Transfer(user);
        assertFalse(userTransfer.transferBalance(2000, account1));
        assertEquals(1000, user.getBalance());
        assertEquals(2000, account1.getBalance());
    }

    @Test
    public void testTransferDepositableSuccess(){
        Transfer userTransfer = new Transfer(user);
        assertTrue(userTransfer.transferDepositable(200, account1, account2));
        assertEquals(1800, account1.getBalance());
        assertEquals(-1367, account2.getBalance());
    }
    @Test
    public void testTransferDepositableFail(){
        Transfer userTransfer = new Transfer(user);
        assertFalse(userTransfer.transferDepositable(2005, account1, account2));
        assertEquals(2000, account1.getBalance());
        assertEquals(-1567, account2.getBalance());
    }

    @Test
    public void testTransferDepositableToBalanceSuccess(){
        Transfer userTransfer = new Transfer(user);
        assertTrue(userTransfer.transferDepositable(200, account1));
        assertEquals(1800, account1.getBalance());
        assertEquals(1200, user.getBalance());
    }
    @Test
    public void testTransferDepositableToBalanceFail(){
        Transfer userTransfer = new Transfer(user);
        assertFalse(userTransfer.transferDepositable(3500, account1));
        assertEquals(2000, account1.getBalance());
        assertEquals(1000, user.getBalance());
    }
}
