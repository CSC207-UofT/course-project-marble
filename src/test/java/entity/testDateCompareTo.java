package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testDateCompareTo {
    private Date d1;
    private Date d2;
    private Date d3;
    private Date d4;

    @BeforeEach
    public void setup() {
        d1 = new Date(11, 1, 2021);
        d2 = new Date(11, 4, 2021);
        d3 = new Date(12, 4, 2021);
        d4 = new Date(11, 1, 2021);
    }

    @Test
    public void checkDateSmallerTrue() {
        assertEquals(1, d2.compareTo(d1));
    }

    @Test
    public void smallerOnLargerDates() {
        assertEquals(-1, d1.compareTo(d2));
    }

    @Test
    public void dateEqual() {
        assertEquals(d1, d4);
    }

    @Test
    public void checkDateBigger() {
        assertEquals(1, d3.compareTo(d2));
    }
}
