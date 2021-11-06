package entity;

public class Bills extends ExpenseType{
    private int budget;

    public Bills(int budget){
        super();
        this.budget = budget;
    }

    /**
     * This method sets the budget based on the expense.
     * @param budget the amount the user has selected to budget for the expense.
     */
    @Override
    public void setBudget(int budget) {
        this.budget = budget;
    }
}