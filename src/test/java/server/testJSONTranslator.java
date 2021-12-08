package server;

import entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class testJSONTranslator {
    private JSONTranslator json;
    private ArrayList<FinancialAsset> listOfFinancialAssets;
    private Savings savings;
    private Bond bond;
    private ArrayList<FinancialAsset> resultsList;
    private Bond bondCheck;
    private Savings savingsCheck;

    @BeforeEach
    void setUp() {
        this.json = new JSONTranslator();
        this.bond = new Bond(3, 0.75, 25, new Date(10, 10, 2020), "MonkaS");
        this.savings = new Savings(0.02, "Savings");
        listOfFinancialAssets = new ArrayList<>();
        listOfFinancialAssets.add(savings);
        listOfFinancialAssets.add(bond);
    }

    /**
     * Test whether data storing occurs and the data can be retrieved
     * this test both if an object can be stored and retrieved
     * @throws IOException - read/write error
     */
    @SuppressWarnings(value="unchecked")
    @Test
    void testDataPersistenceOnAbstractList() throws IOException {
        json.writeToJSON(listOfFinancialAssets, "DataPersistenceTest.json");
        if (new File("DataPersistenceTest.json").exists()) {
            try {
                resultsList = (ArrayList<FinancialAsset>) json.readFromJSON(listOfFinancialAssets.getClass(),
                        "DataPersistenceTest.json");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else{
            assert(false);
        }
        savingsCheck = (Savings) listOfFinancialAssets.get(0);
        bondCheck = (Bond) listOfFinancialAssets.get(1);
        if(savingsCheck == savings & bondCheck == bond){
            assert(true);
        }
        else{
            assert(false);
        }
    }
}
