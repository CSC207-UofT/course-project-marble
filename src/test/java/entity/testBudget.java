package entity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** A set of test for the Budget class entity.
 * */
public class testBudget {
    private Budget budget;
    @BeforeEach
    void setup() {
        budget = new Budget(new Date(1, 1,2021));
    }
/**Test date instance in Budget.*/
    @Test
    void testGetDate(){
        assertEquals("1/1/2021", budget.getDate().toString());
    }

    @Test
    void testSetDate(){
        budget.setDate(new Date(2,1,2021));
        assertEquals("1/2/2021", budget.getDate().toString());
    }

/**Set and get goals and actual spending amounts in budget.*/
    @Test
    void testSetAndGetGoalBudget(){
        budget.setGoalBudget("Groceries", 100.00);
        assertEquals(100.00, budget.getGoalBudget("Groceries"));
    }
    @Test
    void testSetAndGetActualBudget(){
        budget.setActualSpending("Groceries", 90.00);
        assertEquals(90, budget.getActualSpending("Groceries"));
    }

/**Test categories that don't exist return null.*/
    @Test
    void testGetNullCategoryActualSpending(){
        assertNull(budget.getActualSpending("Telephone"));
    }

    @Test
    void testGetNullCategoryGoalBudget(){
        assertNull(budget.getGoalBudget("Telephone"));
    }

    @Test
    void testSetNullCategoryGoalBudget(){
        assertFalse(budget.setGoalBudget("Telephone", 1.00));
    }

    @Test
    void testSetNullCategoryActualSpending(){
        assertFalse(budget.setActualSpending("Telephone", 1.00));
    }

/**Test active status*/
    @Test
    void testGetActiveStatus() {assertTrue(budget.getActive());}
    @Test
    void testSetActiveStatus() {
        assertTrue(budget.getActive());
        budget.setActive(false);
        assertFalse(budget.getActive());
    }
}
