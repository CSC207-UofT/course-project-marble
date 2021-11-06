package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testSavings0Interest {
    private Savings SavingAcc;
    @BeforeEach
    public void setUp() {
        SavingAcc = new Savings(0.0);
    }
    @Test
    public void checkAddInterest0Times() {
        assertEquals(0, SavingAcc.getValue());
    }
    @Test
    public void checkAddInterest0Times0Balance(){
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