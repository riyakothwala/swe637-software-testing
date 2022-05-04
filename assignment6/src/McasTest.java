import jdk.swing.interop.SwingInterOpUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class McasTest {

    Mcas mcasTest;
    Mcas.Command cmd = Mcas.Command.NONE;
    boolean autopilotOnTest;
    boolean flapsDownTest;
    double angleOfAttackTest;

    @BeforeEach
    void setup() {
        mcasTest = new Mcas();
        double angleOfAttackTest = 0.0;
        boolean autopilotOnTest = true;
        boolean flapsDownTest = true;
        System.out.println("Setting up test...");
    }

    @AfterEach
    void tearDown() {
        double angleOfAttackTest = 0.0;
        boolean autopilotOnTest = true;
        boolean flapsDownTest = true;
        System.out.println("Tearing down test...");

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
        System.out.println("Starting Test for d3_TR1 for ");
        System.out.println(mcasTest.getState());
        mcasTest.trim(autopilotOnTest = false,flapsDownTest = false,angleOfAttackTest);
        System.out.println(mcasTest.getState());
        cmd = mcasTest.trim(autopilotOnTest = false,flapsDownTest = false,angleOfAttackTest = 13.0);
        System.out.println(mcasTest.getState());

        assertEquals(Mcas.State.ACTIVE, mcasTest.getState());
        assertEquals(Mcas.Command.DOWN, cmd);
        System.out.println(cmd);
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









}
