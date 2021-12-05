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

    private final HashMap<String, ArrayList<Double>> goalActualBudget;
    private Date date;
    private boolean active;
    List<String> categories = Arrays.asList( "Groceries", "Furniture", "Restaurant", "Vacation", "Gas", "Recurring Bill Payment", "Health and Beauty", "Home Improvement", "Entertainment", "Public Transportation and Parking");
    private final ArrayList<Double> initialList = new ArrayList<>();

    public String toString(){
        if(this.active){
            return "This is an active budget.";
        }
        else{
            return "This is an inactive budget.";
        }

    }

    public Budget(Date date) {
        this.goalActualBudget = new HashMap<>();
        this.initialList.add(0.00);
        this.initialList.add(0.00);
        for (String categoryName : this.categories){
            this.goalActualBudget.put(categoryName, initialList);
        }

        this.date = date;
        this.active = false;

    }

    /**Getter and Setter for Date.
    * getDate returns the date that the Budget was created.*/
    public String getDate() {
        return this.date.toString();
    }
    /**setDate replaces the initial date with a new date.
     * @param newDate: new date of the budget.*/
    public void setDate(Date newDate) {
        this.date = newDate;
    }

    /**getGoalActualBudget returns all the category budgets and current amounts in the budget*/
    public HashMap<String, ArrayList<Double>> getGoalActualBudget() {
        return this.goalActualBudget;
    }

    /** setGoalBudget sets the goal budget in the category to its new value.
     * @param category : the category the user wants budget.
     * @param goalBudget : the new value of the category budget.*/
    public boolean setGoalBudget(String category, Double goalBudget){
        if (goalActualBudget.containsKey(category)){
            goalActualBudget.get(category).set(0, goalBudget);
            return true;
        }
        else{
            return false;
        }
    }


    /** getActualBudget gets the actual amount spent in the category.
     * @param category : the category chosen to know the amount spent.
     * */

    public Double getActualBudget(String category){
        if (goalActualBudget.containsKey(category)){
            return goalActualBudget.get(category).get(1);
        }
        else{
            return null;
        }
    }

    public boolean setActualBudget(String category, Double actualAmount){
        if(goalActualBudget.containsKey(category)){
            this.goalActualBudget.get(category).add(1, actualAmount);
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
        if (goalActualBudget.containsKey(category)){
            return goalActualBudget.get(category).get(0);
        }
        else{
            return null;
        }
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
        return new ArrayList<>(this.categories);
    }

}


