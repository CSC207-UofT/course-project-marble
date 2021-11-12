package entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testDateMonthDifference {
    private Date d1;
    private Date d2;
    private Date d3;
    private Date d4;
    private Date d5;

    @BeforeEach
    public void setup() {
        d1 = new Date(6, 1, 2021);
        d2 = new Date(6, 1, 2021);
        d3 = new Date(6, 30, 2021);
        d4 = new Date(9, 30, 2021);
        d5 = new Date(9, 30, 2020);
    }

    @Test
    public void zeroMonthSameDate() {
      assertEquals(0, d1.monthDifference(d1));
      assertEquals(0, d2.monthDifference(d1));
      assertEquals(0, d1.monthDifference(d2));
    }

    @Test
    public void zeroMonthDifferentDate() {
        assertEquals(0, d1.monthDifference(d3));
        assertEquals(0, d3.monthDifference(d1));
    }

    @Test
    public void lessThanYearDifferenceSameDay(){
        assertEquals(3, d3.monthDifference(d4));
        assertEquals(3, d4.monthDifference(d3));
    }

    @Test
    public void lessThanYearDifferenceDiffDay(){
        assertEquals(3, d1.monthDifference(d4));
        assertEquals(3, d4.monthDifference(d1));
    }

    @Test
    public void YearDifference(){
        assertEquals(12, d4.monthDifference(d5));
        assertEquals(12, d5.monthDifference(d4));
    }

    @Test
    public void YearDifferenceDiffMonthDiffDay(){
        assertEquals(8, d1.monthDifference(d5));
        assertEquals(8, d5.monthDifference(d1));
    }
}
