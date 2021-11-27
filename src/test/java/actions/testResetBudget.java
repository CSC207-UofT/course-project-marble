package actions;

import action_request_response.ActionResponse;
import action_request_response.ResetBudgetRequest;
import entity.Budget;
import entity.Date;
import entity.Owner;
import entity.OwnerRepository;

import java.util.HashMap;

public class testResetBudget {
    private Owner owner;
    private HashMap<String, Double> categories;
    private Date date = new Date(11, 13, 2021);
    private ResetBudgetRequest request;
    private ResetBudget callResetBudget;

    @BeforeEach
    public void setup(){
        Owner newOwner = new Owner("Kevin Thomas", "K.Thomas", "123");
        OwnerRepository.getOwnerRepository().addOwner(newOwner);
        owner = OwnerRepository.getOwnerRepository().findOwner("K.Thomas");
        categories = new HashMap<String, Double>();
        categories.put("Needs", 1000.00);
        categories.put("Wants", 700.00);
        categories.put("Savings/Investment", 100.00);
    }

    @AfterEach
    public void teardown() {OwnerRepository.getOwnerRepository().deleteOwner("K.Thomas");}

    @Test
    public void testResetting(){
        owner.setBudget(categories, date, "monthly");
        Budget budget = owner.getBudget();
        categories.put("Needs", 500.00);
        budget.setRemainingBudget(categories);
        request = new ResetBudgetRequest("K.Thomas");
        callResetBudget = new ResetBudget(request);
        ActionResponse result = callResetBudget.process();
        assertEquals(1000.00, owner.getBudget().getRemainingBudget().get("Needs"));
    }
}
