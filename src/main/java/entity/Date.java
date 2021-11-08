package entity;
import java.time.LocalDate;
public class Date implements Comparable<Date>{
    private final int month;
    private final int year;
    private final int day;

    public Date(int month, int year, int day) {
        this.month = month;
        this.year = year;
        this.day = day;
    }

    public Date() {
        LocalDate date = LocalDate.now();
        this.year = date.getYear();
        this.month = date.getMonthValue();
        this.day = date.getDayOfMonth();
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (this.getClass() != obj.getClass()){
            return false;
        }
        return this.month == ((Date) obj).getMonth() && this.day == ((Date) obj).getDay() && this.year == ((Date) obj).getYear();
    }

    @Override
    public int compareTo(Date date) {
        int myDate = this.year * 10000 + this.month * 100 + this.day;
        int inputDate = date.getYear() * 10000 + date.getMonth() * 100 + date.getDay();
        return Integer.compare(myDate, inputDate);
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public int getDay() {
        return this.day;
    }
}