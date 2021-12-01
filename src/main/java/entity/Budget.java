package entity;

import java.util.ArrayList;
import java.util.HashMap;


public class Budget {


    /**
     * Instances of Budget
     * categories: the types of budget categories (ex: food, clothing, gas...)
     * date: the date the budget is created
     * period: The period of the renewal of the budget (ex: weekly, bi-weekly, monthly)
     */

    private double totalBudget;
    private HashMap<String, Double> goalBudget;
    private HashMap<String, Double> remainingBudget;
    private Date date;
    private String period;
    private boolean active;


    public String toString(){
        if(this.active){
            return "This is an active budget, with a total: "+this.totalBudget;
        }
        else{
            return "This is an inactive budget.";
        }

    }

    public Budget(HashMap<String, Double> categories, Date date, String period) {
        for (Double value : categories.values()) {
            this.totalBudget += value;
        }
        this.goalBudget = new HashMap<>(categories);
        this.remainingBudget = new HashMap<>(categories);
        this.date = date;
        this.period = period;
    }


    public double getTotalBudget() {
        return this.totalBudget;
    }

    public double getTotalRemainingBudget() {
        double sum = 0;
        for (Double value : this.remainingBudget.values()) {
            sum += value;
        }
        return sum;
    }

    public String getPeriod() {
        return this.period;
    }

    public Date getDate() {
        return this.date;
    }

    public HashMap<String, Double> getRemainingBudget() {
        return this.remainingBudget;
    }

    public void adjustPeriod(String newPeriod) {
        this.period = newPeriod;
    }

    public void adjustDate(Date newDate) {
        this.date = newDate;
    }

    public boolean getActive(){return this.active;}

    public void setActive(boolean set){this.active = set;}

    /**
     * adjust the remainingBudget of a single category. Checks first if there's enough leftover, then subtract the
     * remaining budget if so.
     * THIS IS THE METHOD YOU USE TO TRACK THE SPENDINGS OF THE USER
     *
     * @param category   the category that the owner has listed in the hashmap.
     * @param decreaseBy the amount that is going to decrease the budget of the category by.
     * @return True if the amount still has left over or = 0, else False
     */
    public boolean adjustOneCategoryInRemainingBudget(String category, double decreaseBy) {
        if (this.remainingBudget.get(category) - decreaseBy >= 0) {
            this.remainingBudget.put(category, this.remainingBudget.get(category) - decreaseBy);
            return true;
        } else {
            return false;
        }
    }

    /**
     * get an ArrayList of categories of the budget
     *
     * @return an ArrayList of categories of the budget
     */
    public ArrayList<String> getCategories() {
        return new ArrayList<>(this.goalBudget.keySet());
    }

    /**
     * reset the remainingBudget, use when the set time of the budget is over
     */
    public void resetRemainingBudget() {
        this.remainingBudget = new HashMap<>(this.goalBudget);
    }

    /**
     * adds extra or take away the remaining amount of budget.
     * This method lets the user adjust the overall Budget and the changes will sync up
     * with the remaining budget. More budget? Increase the remaining budget in that category. Less budget?
     * Decrease the remaining budget in that category.
     * <p>
     * eg: if the new budget is decreasing the money u can spend on the category: groceries by 20$
     * then the remaining budget will -20$ on the category groceries
     * and the goalBudget becomes the new budget.
     * Will not work if remaining budget goes < 0.
     * <p>
     * It'll change the initialBudget too.
     *
     * @param newBudget a new map of budget
     * @return True if the adjustment is successful
     * <p>
     * Best done together with resetRemainingBudget FIRST, then call adjustBudget, if the new
     * budget is going LESS than the current Budget.
     */
    public boolean adjustBudget(HashMap<String, Double> newBudget) {
        for (String key : newBudget.keySet()) {
            if (this.remainingBudget.get(key) + (newBudget.get(key) - this.goalBudget.get(key)) < 0) {
                return false;
            }
            this.remainingBudget.put(key, this.remainingBudget.get(key) +
                    (newBudget.get(key) - this.goalBudget.get(key)));
        }
        this.goalBudget = newBudget;
        return true;
    }

    /**
     * New methods for added because some Action classes needed them
     */
    public double getGoalCategoryBudget(String catergoryName) {
        return goalBudget.get(catergoryName);
    }


}
