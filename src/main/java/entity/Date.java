package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import static java.lang.Math.max;

public class Date implements Comparable<Date>, Serializable {
    private final int month;
    private final int year;
    private final int day;
    private final LocalDate date;

    /**
     * Returns a Date object corresponding to a giving date String in the format "yyyy=mm-dd"
     * @param date date String in the format "yyyy=mm-dd"
     * @return a corresponding Date object to input date
     */
    public static Date parseDate(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return new Date(localDate.getMonthValue(), localDate.getDayOfMonth(), localDate.getYear());
    }

    /**
     * Constructor to create a date Object at a certain date.
     *
     * @param month The month [1,12]
     * @param year  The year
     * @param day   The day [0,31]
     */
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
        this.date = LocalDate.of(year, month, day);
    }

    /**
     * Constructor that creates a date object
     */
    public Date() {
        this.date = LocalDate.now();
        this.year = date.getYear();
        this.month = date.getMonthValue();
        this.day = date.getDayOfMonth();
    }

    /**
     * Returns the date in dd/mm/yyyy form.
     *
     * @return String representation of the day
     */
    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }

    /**
     * Check if a passed object is equal to the instantiated date
     *
     * @param obj Object that is being checked
     * @return returns true if they are the same object and date
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        return this.month == ((Date) obj).getMonth() && this.day == ((Date) obj).getDay() && this.year == ((Date) obj).getYear();
    }

    /**
     * Compare the current date object to another one that is passed
     *
     * @param date Date object being compared too
     * @return -1 if less than, 0 if equal, 1 if greater than
     */
    @Override
    public int compareTo(Date date) {
        int myDate = this.year * 10000 + this.month * 100 + this.day;
        int inputDate = date.getYear() * 10000 + date.getMonth() * 100 + date.getDay();
        return Integer.compare(myDate, inputDate);
    }

    public LocalDate getDate(){
        return this.date;
    }

    /**
     * Returns the month difference between this date and a given date
     *
     * @param date a date in Date type
     * @return difference between this date and a given date
     */
    public int monthDifference(Date date) {
        Period period = Period.between(this.date, date.getDate());
        Period periodOtherWayAround = Period.between(date.getDate(), this.date);
        return max(period.getMonths(), periodOtherWayAround.getMonths());
    }

    /**
     * Getter for the month
     *
     * @return integer value of the month.
     */
    public int getMonth() {
        return this.month;
    }

    /**
     * Getter for the year
     *
     * @return integer value of the year.
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Getter for the day
     *
     * @return integer value of the day.
     */
    public int getDay() {
        return this.day;
    }
}