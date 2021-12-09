package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testBond {
    private Bond bond;
    @BeforeEach
    void setUp() {
        bond = new Bond(12, 0.7, 12, new Date(10,10, 2021), "bond");
    }

    @Test
    void getValue() {
        double value = bond.getValue();
        assert(value == 144.084);
        bond.cashOut();
        assert(bond.getValue() == 0);
    }

    @Test
    void getDateOfMaturity() {
        Date date = bond.getDateOfMaturity();
        assert(date.getYear() == 2021);
        assert(date.getMonth() == 10);
        assert(date.getDay() == 10);


    }

    @Test
    void getTotalCost() {
        assert(bond.getTotalCost() == 144.0);
    }

    @Test
    void getPricePerBond() {
        assert(bond.getPricePerBond() == 12);
    }

    @Test
    void cashOut() {
        Bond bond2 = new Bond(1,0.2,23, new Date(10,10, 2022), "miggy");
        double returnVal = bond.getValue();
        double bondVal = bond.cashOut();
        assert(bondVal == returnVal);
        bondVal = bond.cashOut();
        assert(bondVal == -1);
        bondVal = bond2.cashOut();
        assert(bondVal == -1);

    }
}