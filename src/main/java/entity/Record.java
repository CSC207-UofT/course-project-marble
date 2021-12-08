package entity;

public class Record implements Comparable<Record> {
    private final double amount;
    private final Date date;
    private final String category;
    private final String description;

    /**
     * @param amount      : the amount of money recorded.
     * @param date        : the date of the activity.
     * @param category    : category of record.
     * @param description : description of activity.
     */
    public Record(double amount, Date date, String category, String description) {
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.description = description;
    }

    @Override
    public String toString() {
        if (this.amount > 0) {
            return "On " + this.date + " you deposited " + this.amount + " dollars " + "because:  "  +  this.description;
        } else {
            return "On " + this.date + " you spent " + this.amount + " dollars" + "because:  "  +  this.description;
        }
    }

    /**
     * Getter for the amount
     *
     * @return the double amount of the record.
     */
    public double getAmount() {
        return this.amount;
    }

    /**
     * Getter for the date
     *
     * @return Date object of the record.
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Getter for the category
     *
     * @return String category of the record.
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * Compare the current Record object to another one that is passed based on the date of the record.
     *
     * @param record Date object being compared too
     * @return -1 if less than, 0 if equal, 1 if greater than
     */
    @Override
    public int compareTo(Record record) {
        return this.date.compareTo(record.date);
    }

}
