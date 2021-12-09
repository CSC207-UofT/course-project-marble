package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class testBond {
    private Bond bond;
    @BeforeEach
    void setUp() {
        bond = new Bond(12, 0.7, 12, new Date(10,10, 2021), "bond");
    }

    @Test
    void getValue() {
        double value = bond.getValue();
        assertEquals(value,144.084);
        bond.cashOut();
        assertEquals(bond.getValue(),0);
    }

    @Test
    void getDateOfMaturity() {
        Date date = bond.getDateOfMaturity();
        assertEquals(date.getYear(), 2021);
        assertEquals(date.getMonth(), 10);
        assertEquals(date.getDay(), 10);


    }

    @Test
    void getTotalCost() {
        assertEquals(bond.getTotalCost(), 144.0);
    }

    @Test
    void getPricePerBond() {
        assertEquals(bond.getPricePerBond(), 12);
    }

    @Test
    void cashOut() {
        Bond bond2 = new Bond(1,0.2,23, new Date(10,10, 2022), "miggy");
        double returnVal = bond.getValue();
        double bondVal = bond.cashOut();
        assertEquals(bondVal, returnVal);
        bondVal = bond.cashOut();
        assertEquals(bondVal, -1);
        bondVal = bond2.cashOut();
        assertEquals(bondVal, -1);

    }
}