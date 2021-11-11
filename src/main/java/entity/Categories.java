package entity;

import java.util.HashMap;

public class Categories {
    private final String name;
    private double budget;
    private HashMap<Date, Double> Spending;



    public Categories(String name, double budget) {
        this.name = name;
        this.budget = budget;
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

    public double getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
