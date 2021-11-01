package entity;

public class Entertainment extends ExpenseType{
    private int budget;

    public Entertainment(int budget){
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

