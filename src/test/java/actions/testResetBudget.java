//package actions;
//
//import action_request_response.ActionRequest;
//import action_request_response.ActionResponse;
//import action_request_response.Commands;
//import entity.Budget;
//import entity.Date;
//import entity.Owner;
//import entity.OwnerRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class testResetBudget {
//    private Owner owner;
//    private HashMap<String, Double> categories;
//    private final Date date = new Date(11, 13, 2021);
//
//    @BeforeEach
//    public void setup(){
//        Owner newOwner = new Owner("Kevin Thomas", "K.Thomas", "123");
//        OwnerRepository.getOwnerRepository().addOwner(newOwner);
//        owner = OwnerRepository.getOwnerRepository().findOwner("K.Thomas");
//        categories = new HashMap<>();
//        categories.put("Needs", 1000.00);
//        categories.put("Wants", 700.00);
//        categories.put("Savings/Investment", 100.00);
//    }
//
//    @AfterEach
//    public void teardown() {OwnerRepository.getOwnerRepository().deleteOwner("K.Thomas");}
//
//    @Test
//    public void testResetting(){
//        owner.setBudget(categories, date, "monthly");
//        Budget budget = owner.getBudget();
//        categories.put("Needs", 500.00);
//        budget.setRemainingBudget(categories);
//        ActionRequest request = new ActionRequest("K.Thomas", Commands.RESETBUDGET, new ArrayList<>());
//        ActionResponse result = new ResetBudget(request).process();
//        assertEquals(1000.00, owner.getBudget().getRemainingBudget().get("Needs"));
//    }
//}
