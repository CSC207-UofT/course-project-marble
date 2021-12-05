package actions;
import action_request_response.ActionRequest;
import action_request_response.Commands;
import action_request_response.DisplayWithdrawalRecordResponse;
import action_request_response.ViewBudgetPerformanceResponse;
import entity.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testViewBudgetPerformance {
    @BeforeEach
    public void setup(){
        OwnerRepository.getOwnerRepository().addOwner(new Owner("John Doe", "jd_123", "password"));
        Owner user = OwnerRepository.getOwnerRepository().findOwner("jd_123");
        user.setBudget(new Date(1, 1, 2021));
        user.addBudgetHistory(user.getBudget());
    }
    @AfterEach
    public void teardown() {
        OwnerRepository.getOwnerRepository().deleteOwner("jd_123");
    }


//    @Test
//    public void testViewBudgetPerformanceSuccess(){
//        ActionRequest request = new ActionRequest("jd_123", Commands.VIEWBUDGETPERFORMANCE, new ArrayList<>());
//        ViewBudgetPerformance budgetPerformance = new ViewBudgetPerformance(request);
//        ViewBudgetPerformanceResponse response = (ViewBudgetPerformanceResponse) budgetPerformance.process();
//        HashMap<Date, HashMap<String,Double>> expected = new HashMap<>();
//        List<String> categories = Arrays.asList( "Groceries", "Furniture", "Restaurant", "Vacation", "Gas", "Recurring Bill Payment", "Health and Beauty", "Home Improvement", "Entertainment", "Public Transportation and Parking");
//        expected.put(new Date(1,1,2021),new HashMap<>());
//        for (String category: categories){
//            expected.get( new Date(1, 1, 2021)).put(category,0.00);
//        }
//
//        assertEquals(expected.toString(), response.getDisplay());
//    }



}
