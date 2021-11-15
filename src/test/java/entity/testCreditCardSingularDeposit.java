package entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class testCreditCardSingularDeposit {
    private CreditCard creditCard;
    @BeforeEach
    void setUp() {
        creditCard = new CreditCard("CreditCard1");
    }
    @Test
    void checkAmount(){
        creditCard.deposit(-10.0);
        assertEquals(-10.0, creditCard.getValue());
    }

}
