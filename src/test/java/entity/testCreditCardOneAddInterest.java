package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class testCreditCardOneAddInterest {
    private CreditCard creditCard;
    @BeforeEach
    void setUp() {
        creditCard = new CreditCard();
    }
    @Test
    void zeroBalance(){
        creditCard.addInterest();
        assertEquals(0, creditCard.getBalance());
    }
    @Test
    void positiveBalance(){
        creditCard.deposit(4);
        assertEquals(4, creditCard.getBalance());
    }
    @Test
    void negativeBalance(){
        creditCard.deposit(-100);
        creditCard.addInterest();
        assertEquals(-101.66, creditCard.getBalance());
    }
}