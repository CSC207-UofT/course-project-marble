package server;

import entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class testJSONTranslator {
    private JSONTranslator json;
    private Savings savings;
    private Savings savingsCheck;

    @BeforeEach
    void setUp() {
        this.json = new JSONTranslator();
        this.savings = new Savings(0.02, "Savings");
        if(! new File("DataPersistenceTest.json").exists()){
            new File("DataPersistenceest.json");
        }
    }

    /**
     * Test whether data storing occurs and the data can be retrieved
     * this test both if an object can be stored and retrieved
     * @throws IOException - read/write error
     */
    @Test
    void testDataPersistence() throws IOException {
        json.writeToJSON(savings, "DataPersistenceTest.json");
        if (new File("DataPersistenceTest.json").exists()) {
            try {
                savingsCheck = (Savings) json.readFromJSON(Savings.class, "DataPersistenceTest.json");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else{
            assert(false);
        }
        if(savingsCheck.toString().equals(savings.toString())){
            assert(true);
        }
        else{
            assert(false);
        }
    }
}
