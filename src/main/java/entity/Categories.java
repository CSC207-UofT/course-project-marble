package entity;

import java.util.HashMap;

public class Categories {
    private final String name;
    private int budget;
    private HashMap<Date, Double> Spending;



    public Categories(String name) {
        this.name = name;
        Spending = new HashMap<Date, Double>();
    }
    public void addSpending(Date date, double amount){
        if (Spending.containsKey(date)){
            Double temp = Spending.get(date);
            Spending.put(date, (Double) temp + amount);
        }
        else {
            Spending.put(date, (Double) amount);
        }

    }
    public double getSpendingOnDate(Date date){
        if (Spending.containsKey(date)){
            return (double) Spending.get(date);
        }
        return 0;
    }

    public String getName() {
        return name;
    }
}
