package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testSavingsPositiveInterest {
    private Savings savings;

    @BeforeEach
    void setup() {
        this.savings = new Savings(12, "Savings1");
    }

    @Test
    void noDeposit() {
        savings.addInterest();
        assertEquals(0, savings.getValue());
    }

    @Test
    void depositWithdraw() {
        savings.deposit(10);
        savings.addInterest();
        savings.deposit(-0.1);
        assertEquals(10, savings.getValue());
    }

    @Test
    void depositOnce() {
        savings.deposit(100.5);
        savings.addInterest();
        savings.addInterest();
        assertEquals(102.53, savings.getValue());
    }

    @Test
    void depositTwice() {
        savings.deposit(10);
        savings.addInterest();
        savings.addInterest();
        savings.deposit(8);
        savings.addInterest();
        savings.addInterest();
        assertEquals(18.56, savings.getValue());
    }
}
