import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class McasTest {

	Mcas mcasTest;
    Mcas.Command cmd = Mcas.Command.NONE;
    boolean autopilotOnTest;
    boolean flapsDownTest;
    double angleOfAttackTest;
    
    McasTimerSingleton mcasTimerSingleton;
    
    @BeforeEach
    void setup() {
    	System.out.println("Setting up test...");
        mcasTest = new Mcas();
        double angleOfAttackTest = 0.0;
        boolean autopilotOnTest = true;
        boolean flapsDownTest = true;
        
        mcasTimerSingleton = McasTimerSingleton.getInstance();
        mcasTimerSingleton.resetTimerSet();
        mcasTimerSingleton.resetIsExpired();
    }

    @AfterEach
    void tearDown() {
    	System.out.println("Tearing down test...");
        double angleOfAttackTest = 0.0;
        boolean autopilotOnTest = true;
        boolean flapsDownTest = true;
        
        mcasTimerSingleton.resetTimerSet();
        mcasTimerSingleton.resetIsExpired();
    }

    boolean autopilotOn;
    boolean flapsDown;
    Mcas.State state;
    Mcas.Command com;

    @Test
    void testd1_TR1(){
        System.out.println("Starting Test for d1_TR1 for ");
        mcasTest.trim(autopilotOnTest = false,flapsDownTest = false,angleOfAttackTest);
        //System.out.println(mcasTest.getState());
        assertEquals(Mcas.State.ARMED, mcasTest.getState());
    }

    @Test
    void testd1_TR2(){
        System.out.println("Starting Test for d1_TR2 for ");
        mcasTest.trim(autopilotOnTest,flapsDownTest,angleOfAttackTest);
        //System.out.println(mcasTest.getState());
        assertEquals(Mcas.State.ARMED, mcasTest.getState());
    }

    @Test
    void testd1_TR3(){
        System.out.println("Starting Test for d1_TR3 for ");
        mcasTest.trim(autopilotOnTest,flapsDownTest = false,angleOfAttackTest);
        //System.out.println(mcasTest.getState());
        assertEquals(Mcas.State.ARMED, mcasTest.getState());
    }

    @Test
    void testd2_TR1(){
        System.out.println(mcasTest.getState());
        System.out.println("Starting Test for d2_TR1 for");
        mcasTest.trim(autopilotOnTest, flapsDownTest,angleOfAttackTest);
        assertEquals(Mcas.State.ARMED, mcasTest.getState());
    }

    @Test
    void testd2_TR2() {
        //Mcas.state =
        System.out.println(mcasTest.getState());
        System.out.println("Starting Test for d2_TR1 for");
        mcasTest.trim(autopilotOnTest = false, flapsDownTest, angleOfAttackTest);
        assertEquals(Mcas.State.ARMED, mcasTest.getState());
    }

    @Test
    void testd2_TR3() {
        //Mcas.state =
        System.out.println(mcasTest.getState());
        System.out.println("Starting Test for d2_TR3 for");
        mcasTest.trim(autopilotOnTest, flapsDownTest, angleOfAttackTest);
        assertEquals(Mcas.State.ARMED, mcasTest.getState());
    }

    @Test
    void testd2_TR4() {
        //Mcas.state =
        System.out.println(mcasTest.getState());
        System.out.println("Starting Test for d2_TR4 for");
        mcasTest.trim(autopilotOnTest = false, flapsDownTest, angleOfAttackTest);
        assertEquals(Mcas.State.ARMED, mcasTest.getState());
    }

    @Test
    void testd2_TR5() {
        //Mcas.state =
        System.out.println(mcasTest.getState());
        System.out.println("Starting Test for d2_TR5 for");
        mcasTest.trim(autopilotOnTest, flapsDownTest=false, angleOfAttackTest);
        assertEquals(Mcas.State.ARMED, mcasTest.getState());
    }

    @Test
    void testd2_TR6() {
        //Mcas.state =
        System.out.println(mcasTest.getState());
        System.out.println("Starting Test for d2_TR6 for");
        mcasTest.trim(autopilotOnTest=false, flapsDownTest=false, angleOfAttackTest);
        assertEquals(Mcas.State.ARMED, mcasTest.getState());
    }

    @Test
    void testd2_TR7() {
        //Mcas.state =
        System.out.println(mcasTest.getState());
        System.out.println("Starting Test for d2_TR7 for");
        mcasTest.trim(autopilotOnTest, flapsDownTest=false, angleOfAttackTest);
        assertEquals(Mcas.State.ARMED, mcasTest.getState());
    }

    @Test
    void testd2_TR8() {
        //Mcas.state =
        System.out.println(mcasTest.getState());
        System.out.println("Starting Test for d2_TR8 for");
        mcasTest.trim(autopilotOnTest, flapsDownTest=false, angleOfAttackTest);
        assertEquals(Mcas.State.ARMED, mcasTest.getState());
    }

    @Test
    void testd3_TR1(){
        System.out.println("Starting Test for d3_TR1");
        angleOfAttackTest = 13.0;
        cmd = mcasTest.trim(autopilotOnTest, flapsDownTest, angleOfAttackTest);

        assertEquals(true,mcasTimerSingleton.timerSet);
        assertEquals(Mcas.Command.DOWN,cmd);
        assertEquals(Mcas.State.ACTIVE,mcasTest.getState());
    }

    @Test
    void testd3_TR2(){
        System.out.println("Starting Test for d3_TR2 for ");
        System.out.println(mcasTest.getState());
        mcasTest.trim(autopilotOnTest = false,flapsDownTest = false,angleOfAttackTest);
        System.out.println(mcasTest.getState());
        cmd = mcasTest.trim(autopilotOnTest = false,flapsDownTest = false,angleOfAttackTest = 10.0);
        System.out.println(cmd);
        System.out.println(mcasTest.getState());
        assertEquals(Mcas.State.ARMED, mcasTest.getState());
        assertEquals(Mcas.Command.NONE, cmd);
        System.out.println(cmd);
    }

//    @Test                  //INFEASIBLE TEST
//    void testd3_TR3(){
//        System.out.println("Starting Test for d3_TR3 for ");
//        System.out.println(mcasTest.getState());
//        mcasTest.trim(autopilotOnTest = false,flapsDownTest = false,angleOfAttackTest);
//        System.out.println(mcasTest.getState());
//        mcasTest.trim(autopilotOnTest = false,flapsDownTest = false,angleOfAttackTest = 13.0);
//        System.out.println(mcasTest.getState());
//
//        cmd = mcasTest.trim(autopilotOnTest = false,flapsDownTest = false,angleOfAttackTest = 13.0);
//        System.out.println(cmd);
//        System.out.println(mcasTest.getState());
//        assertEquals(Mcas.State.ARMED, mcasTest.getState());
//        assertEquals(Mcas.Command.NONE, cmd);
//        System.out.println(cmd);
//
//    }


//    @Test
//    void testd4_TR1() {    //Seems to ve Infeasible
//        System.out.println("Starting Test for d4_TR1 for");
//        mcasTest.trim(autopilotOnTest = false,flapsDownTest = false,angleOfAttackTest);
//        System.out.println(mcasTest.getState());
//        mcasTest.trim(autopilotOnTest = false,flapsDownTest = false,angleOfAttackTest = 13.0);
//        System.out.println(mcasTest.getState());
//        System.out.println(angleOfAttackTest);
//        mcasTest.trim(autopilotOnTest, flapsDownTest, angleOfAttackTest = 10.0);
//        System.out.println(mcasTest.getState());
//        mcasTest.trim(autopilotOnTest, flapsDownTest, angleOfAttackTest);
//        assertEquals(Mcas.State.INACTIVE, mcasTest.getState());
//    }

    @Test
    void testd4_TR2(){
        System.out.println("Starting Test for d4_TR2 for ");
        System.out.println(mcasTest.getState());
        mcasTest.trim(autopilotOnTest = false,flapsDownTest = false,angleOfAttackTest = 10.0);
        System.out.println(mcasTest.getState());
        mcasTest.trim(autopilotOnTest = false,flapsDownTest ,angleOfAttackTest = 0.0);
        System.out.println(mcasTest.getState());
        Assertions.assertEquals(Mcas.State.ARMED, mcasTest.getState());   //False of active, we consider half steps only as this pattern is visible, so Armed
        //assertEquals(Mcas.Command.DOWN, mcasTest.getcommand());
    }

    @Test
    void testd4_TR3(){
        System.out.println("Starting Test for d4_TR3 for ");
        System.out.println(mcasTest.getState());
        mcasTest.trim(autopilotOnTest = false,flapsDownTest = false,angleOfAttackTest = 13.0);
        System.out.println(mcasTest.getState());
        mcasTest.trim(autopilotOnTest,flapsDownTest = false,angleOfAttackTest = 13.0);
        assertEquals(Mcas.State.ACTIVE, mcasTest.getState());
    }

    @Test
    void testd4_TR4(){
        System.out.println("Starting Test for d4_TR4 for ");
        System.out.println(mcasTest.getState());
        mcasTest.trim(autopilotOnTest,flapsDownTest = false,angleOfAttackTest);
        //System.out.println(angleOfAttackTest);
        assertEquals(Mcas.State.ARMED, mcasTest.getState());
    }

    @Test
    void testd4_TR5(){
        System.out.println("Starting Test for d4_TR5 for ");
        System.out.println(mcasTest.getState());
        mcasTest.trim(autopilotOnTest = false,flapsDownTest = false,angleOfAttackTest = 13.0);  //Since OR for autopilot and flapsDown, any one can be false.
        System.out.println(mcasTest.getState());
        mcasTest.trim(autopilotOnTest = false,flapsDownTest,angleOfAttackTest);
        assertEquals(Mcas.State.ACTIVE, mcasTest.getState());
    }

    @Test
    void testd4_TR6(){
        System.out.println("Starting Test for d4_TR6 for ");
        System.out.println(mcasTest.getState());
        mcasTest.trim(autopilotOnTest = false,flapsDownTest = false,angleOfAttackTest = 13.0);
        System.out.println(mcasTest.getState());
        mcasTest.trim(autopilotOnTest = false,flapsDownTest = false,angleOfAttackTest = 10.0);
        assertEquals(Mcas.State.ARMED, mcasTest.getState()); //Armed, which is technically not active as half steps discussed above
    }

    @Test
    void testd5_TR1() {
        System.out.println("Starting Test for d5_TR1 for ");
        System.out.println(mcasTest.getState());
        mcasTest.trim(autopilotOnTest = false,flapsDownTest = false,angleOfAttackTest = 13.0);
        System.out.println(mcasTest.getState());
        mcasTest.trim(autopilotOnTest,flapsDownTest = false,angleOfAttackTest = 13.0);
        assertEquals(Mcas.State.ACTIVE, mcasTest.getState());
        mcasTest.trim(autopilotOnTest,flapsDownTest =false,angleOfAttackTest = 10.0);
        assertEquals(Mcas.State.ARMED, mcasTest.getState());
        System.out.println(mcasTest.getState());

    }

    @Test
    void testd5_TR2() {
        System.out.println("Starting Test for d5_TR2 for ");
        System.out.println(mcasTest.getState());
        mcasTest.trim(autopilotOnTest = false, flapsDownTest = false, angleOfAttackTest = 13.0);
        System.out.println(mcasTest.getState());
        mcasTest.trim(autopilotOnTest, flapsDownTest = false, angleOfAttackTest = 13.0);
        assertEquals(Mcas.State.ACTIVE, mcasTest.getState());
        mcasTest.trim(autopilotOnTest, flapsDownTest = false, angleOfAttackTest = 13.0);
        assertEquals(Mcas.State.ACTIVE, mcasTest.getState());
        System.out.println(mcasTest.getState());
    }

    @Test
    void testd5_TR3() {
        System.out.println("Starting Test for d5_TR3 for ");
        System.out.println(mcasTest.getState());
        mcasTest.trim(autopilotOnTest, flapsDownTest, angleOfAttackTest = 10.0);
        System.out.println(mcasTest.getState());
        mcasTest.trim(autopilotOnTest, flapsDownTest=false, angleOfAttackTest = 13.0);
        System.out.println(mcasTest.getState());
        mcasTest.trim(autopilotOnTest, flapsDownTest=false, angleOfAttackTest = 13.0);
        assertEquals(Mcas.State.ACTIVE,mcasTest.getState());
    }
    
    @Test
    void testd6_TR1() {
    	System.out.println("Starting Test for d6_TR1 for ");
    	angleOfAttackTest = 13.0;
    	
    	//call trim one time to prime internal state element to State.ACTIVE state
    	mcasTest.trim(autopilotOnTest, flapsDownTest, angleOfAttackTest);
    	
    	//verify state has been primed through an assertion call
    	assertEquals(Mcas.State.ACTIVE,mcasTest.getState());
    	
    	//set the following booleans false to prevent entering D4 if statement
    	autopilotOnTest = false;
    	flapsDownTest = false;
    	
    	//prime timer.isExpired() to return true
    	mcasTimerSingleton.setIsExpired();
    	
    	//verify priming has occurred through an assertion check
    	assertEquals(true,mcasTimerSingleton.isExpired);
    	
    	//check if singleton timerSet boolean is already true as it may have been set
    	//from previous trim call, if true reset it
    	if(mcasTimerSingleton.timerSet == true) {
    		mcasTimerSingleton.resetTimerSet();
    	}
    	
    	cmd = mcasTest.trim(autopilotOnTest, flapsDownTest, angleOfAttackTest);
    	
    	//verify cmd is set to DOWN
    	assertEquals(Mcas.Command.DOWN,cmd);
    	//verify that singleton timerSet has been set again to TRUE
    	assertEquals(true,mcasTimerSingleton.timerSet);
 
    }
}
