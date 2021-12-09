package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class testOwner {
    private Owner owner;
    private Record record;
    private Budget budget;
    private Savings saving;

    @BeforeEach
    void setUp() {
        owner = new Owner("Miguel Weerasinghe", "miggyboi", "POGGERS");
        record = new Record(500, new Date(10,10,2021), "Monkey", "goin' Bananas");
        owner.addRecord(record);
        budget = new Budget(new Date(9,9,2021));
        owner.addBudgetHistory(new Date(), budget.toString());
        saving = new Savings(0.12, "Miguel-Savings");
        owner.addAsset(saving);
    }

    @Test
    void testToString() {
        String ownerString = "User Profile:\nName: Miguel Weerasinghe" + "\nUsername: miggyboi" + "\nBalance: $0.0\n";
        assertEquals(ownerString, owner.toString());
    }

    @Test
    void getName() {
        assertEquals(owner.getName(), "Miguel Weerasinghe");
    }

    @Test
    void getUserName() {
        assertEquals(owner.getUserName(), "miggyboi");
    }

    @Test
    void getListRecord() {
        ArrayList<Record> listRecord = new ArrayList<>();
        listRecord.add(record);
        assertEquals(owner.getListRecord(), listRecord);
    }

    @Test
    void addRecord() {
        assertEquals(owner.getListRecord().size(), 1);
        owner.addRecord(record);
        assertEquals(owner.getListRecord().size(), 2);
        assertEquals(owner.getListRecord().get(1), record);
    }

    @Test
    void addAsset() {
        assertEquals(owner.getListAssets().size(), 1);
        owner.addAsset(saving);
        assertEquals(owner.getListAssets().size(), 2);
        assertEquals(owner.getListAssets().get(1), saving);
    }

    @Test
    void getListAssets() {
        ArrayList<FinancialAsset> listAsset = new ArrayList<>();
        listAsset.add(saving);
        assertEquals(owner.getListAssets(), listAsset);
    }

    @Test
    void addBudgetHistory() {
        String ownerBudgetHist = owner.getBudgetHistory().toString();
        owner.addBudgetHistory(new Date(), budget.toString());
        assertEquals(owner.getBudgetHistory().toString().length(), ownerBudgetHist.length());
        assert(owner.getBudgetHistory().toString().equals(ownerBudgetHist));

    }

    @Test
    void getBudgetHistory() {
        HashMap<String, String> budgetHistory = new HashMap<>();
        budgetHistory.put(new Date().toString(), budget.toString());
        assertEquals(budgetHistory, owner.getBudgetHistory());
    }

    @Test
    void setBalance() {
        assertEquals(owner.getBalance(), 0);
        owner.setBalance(100);
        assertEquals(owner.getBalance(), 100);
    }

    @Test
    void getBalance() {
        assertEquals(owner.getBalance(), 0);
        owner.setBalance(100);
        assertEquals(owner.getBalance(), 100);
    }

    @Test
    void setBudget() {
        Budget budgetTest = new Budget(new Date());
        owner.setBudget(budgetTest);
        assertEquals(owner.getBudget(), budgetTest);
    }

    @Test
    void getBudget() {
        Budget budgetCheck = owner.getBudget();
        Budget budgetTest = new Budget(new Date());
        owner.setBudget(budgetTest);
        assertNotEquals(owner.getBudget(), budgetCheck);
        assertEquals(owner.getBudget(), budgetTest);
    }

    @Test
    void comparePassword() {
        assert(!owner.comparePassword("MonkeysAreBAnanamaias9diehbfuiweguifgwe9dfwef"));
        assert(owner.comparePassword("POGGERS"));
    }
}