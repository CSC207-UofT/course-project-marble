package actions;
import entity.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class testViewBudgetPerformance {
    @BeforeEach
    public void setup(){
        OwnerRepository.getOwnerRepository().addOwner(new Owner("John Doe", "jd_123", "password"));
        Owner user = OwnerRepository.getOwnerRepository().findOwner("jd_123");
        Budget budget = new Budget(new Date(1, 1, 2021));
        user.setBudget(budget);
        user.addBudgetHistory(user.getBudget().getDate(), budget.toString());
    }

    //TODO: make test

    @AfterEach
    public void teardown() {
        OwnerRepository.getOwnerRepository().deleteOwner("jd_123");
    }



}
