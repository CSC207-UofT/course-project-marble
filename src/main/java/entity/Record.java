package entity;

public class Record implements Comparable<Record>{
    private double amount;
    private Date date;
    private String category;
    private String description;

    /**
     *
     * @param amount : the amount of money recorded.
     * @param date : the date of the activity.
     * @param category :
     * @param description : description of activity.
     */
    public Record(double amount, Date date, String category, String description){
        this.amount = -amount;
        this.date = date;
        this.category = category;
        this.description = description;
    }

    /**
     * Getter for the amount
     * @return the double amount of the record.
     */
    public double getAmount(){return this.amount;}
    /**
     * Getter for the date
     * @return Date object of the record.
     */
    public Date getDate(){return this.date;}
    /**
     * Getter for the category
     * @return String category of the record.
     */
    public String getCategory(){return this.category;}
    /**
     * Getter for the description
     * @return String description of the record.
     */
    public String getDescription(){return this.description;}

    /**
     * Compare the current Record object to another one that is passed based on the date of the record.
     * @param record Date object being compared too
     * @return -1 if less than, 0 if equal, 1 if greater than
     */
    @Override
    public int compareTo(Record record) {
        return this.date.compareTo(record.date);
    }

}
