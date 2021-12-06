package entity;

import java.util.*;

public class Budget {


    /**
     * Instances of Budget
     * categories: the types of budget categories (ex: food, clothing, gas...)
     * date: the date the budget is created. This would likely be the first of the month.
     * goalActualBudget: a hashmap with categories as keys, corresponding to an array list of 2 doubles; (1) the goal amount
     * and (2) the actual amount.
     * active: boolean that indicates whether the budget was set (True) or not (False).
     */
    private final HashMap<String, Double> actualSpending;
    private final HashMap<String, Double> goalBudget;
    List<String> categories;
    private Date date;
    private boolean active;

    public String toString(){
        if(this.active){
            return "This is an active budget.";
        }
        else{
            return "This is an inactive budget.";
        }
    }

    public Budget(Date date) {
        this.categories = Arrays.asList( "Groceries", "Gas", "Bill Payments", "Entertainment", "Public Transport");
        this.actualSpending = new HashMap<>();
        this.goalBudget = new HashMap<>();
        for (String categoryName : this.categories){
            this.actualSpending.put(categoryName, 0.0);
            this.goalBudget.put(categoryName, 0.0);
        }
        this.date = date;
        this.active = true;

    }
    /**
     * Getter for  Date.
    * getDate returns the date that the Budget was created.*/
    public Date getDate() {
        return this.date;
    }

    /**
     * setDate replaces the initial date with a new date.
     * @param newDate: new date of the budget.*/
    public void setDate(Date newDate) {
        this.date = newDate;
    }

    /**
     * getGoalBudget returns all the goal budgets and current amounts in the budget*/
    public HashMap<String, Double> getGoalBudget() {
        return this.goalBudget;
    }

    /**
     *  setGoalBudget sets the goal budget in the category to its new value.
     * @param category : the category the user wants budget.
     * @param newGoalAmount : the new value of the category budget.*/
    public boolean setGoalBudget(String category, Double newGoalAmount){
        if (this.goalBudget.containsKey(category)){
            goalBudget.replace(category, newGoalAmount);
            return true;
        }
        else{
            return false;
        }
    }

    /** getGaolBudget gets the goal amount spent in the category.
     * @param category : the category chosen to know the goal amount.
     * */
    public Double getGoalBudget(String category){
        return goalBudget.getOrDefault(category, null);

    }


    /** setActualBudget sets the actual amount spent in the category to its new value.
     * @param category : the category the user wants budget.
     * @param newAmount : the new value of the category budget.*/

    public boolean setActualSpending(String category, Double newAmount){
        if(actualSpending.containsKey(category)){
            this.actualSpending.replace(category, newAmount);
            return true;
        }
        else{
            return false;
        }
    }

    /** getActualBudget gets the actual amount spent in the category.
     * @param category : the category chosen to know the amount spent.
     * */
    public Double getActualSpending(String category){
        return actualSpending.getOrDefault(category, null);
    }


    /**getActive returns whether the client set a budget for the month. True for if they did and false otherwise.
     * */
    public boolean getActive(){return this.active;}

    /**setActive makes the budget active or inactive depending on the input.*/
    public void setActive(boolean set){this.active = set;}


    /**
     * get an ArrayList of categories
     *
     * @return an ArrayList of categories of the budget
     */
    public ArrayList<String> getCategories() {
        return (ArrayList<String>) this.categories;
    }

}


