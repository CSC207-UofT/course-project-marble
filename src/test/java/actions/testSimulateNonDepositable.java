//package actions;
//
//import action_request_response.SimulateNonDepositableRequest;
//import action_request_response.SimulateResponse;
//import entity.*;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class testSimulateNonDepositable {
//    private NonDepositable assetBond;
//
//    @Test
//    public void testSimulationMature(){
//        Date endDateMature = new Date(11, 1, 2021);
//        assetBond = new Bond(2, 7.0, 1000, endDateMature, "Bond1");
//        SimulateNonDepositableRequest request = new SimulateNonDepositableRequest("jd_123", assetBond);
//        SimulateNonDepositable simulation = new SimulateNonDepositable(request, endDate);
//        SimulateResponse response = (SimulateResponse) simulation.process();
//        assertEquals(2000.03, response.getResult(), 0.05);
//    }
//
//    @Test
//    public void testSimulationImmature(){
//        Date endDateImmature = new Date(7, 16, 2022);
//        assetBond = new Bond(2, 7, 1000, endDateImmature, "Bond1");
//        SimulateNonDepositableRequest request = new SimulateNonDepositableRequest("jd_123", assetBond);
//        SimulateNonDepositable simulation = new SimulateNonDepositable(request, endDate);
//        SimulateResponse response = (SimulateResponse) simulation.process();
//        assertEquals(0.0, response.getResult(), 0.05);
//    }
//}

