package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testSavingsZeroInterest {
    private Savings SavingAcc;
    @BeforeEach
    public void setUp() {
        SavingAcc = new Savings(0.0, "Savings1");
    }
    @Test
    public void checkAddInterestZeroTimes() {
        assertEquals(0, SavingAcc.getValue());
    }
    @Test
    public void checkAddInterestZeroTimes0Balance(){
        SavingAcc.addInterest();
        assertEquals(0, SavingAcc.getValue());
    }
    @Test
    public void checkDeposit(){
        SavingAcc.deposit(1);
        assertEquals(1, SavingAcc.getValue());
    }
    @Test
    public void checkDepositInterest2Times(){
        SavingAcc.deposit(1);
        SavingAcc.addInterest();
        SavingAcc.addInterest();
        assertEquals(1, SavingAcc.getValue());
    }

}