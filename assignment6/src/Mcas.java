// This module has been identified as SAFETY-CRITICAL SOFTWARE (Level A) under
// standard DO-178C "Software Considerations in Airborne Systems and Equipment Certification".
// Modification of this software for testing purposes is NOT AUTHORIZED by the
// approval authority.

//package mcas;

public class Mcas
{
    // Define enumerations for return values (commands)
    public enum Command
    {
        NONE, DOWN
    };

    // Declare enumerations for internal state
    public enum State
    {
        INACTIVE, ARMED, ACTIVE
    };

    // Define the threshold AOA for activating, in degrees nose-up
    public static final double AOA_THRESHOLD          = 12.0;

    // Define the minimum time delay between activations, in milliseconds
    public static final long   ACTIVATION_INTERVAL_MS = 10000;

    // Declare member variables
    private State        state;
    private McasTimer    timer;

    // Constructor
    public Mcas()
    {
        state = State.INACTIVE; // safest starting state
        timer = new McasTimer(ACTIVATION_INTERVAL_MS);
    }

    // Method to control trim
    public Command trim(boolean autopilotOn, boolean flapsDown,
                        double angleOfAttack)
    {
        // Initialize command to NONE
        Command command = Command.NONE;

        // Are we currently INACTIVE and conditions are such (autopilot off and
        // flaps up) that we should become ARMED?
        // decision D1
        if ((state == State.INACTIVE) && !autopilotOn && !flapsDown)
        {
            state = State.ARMED;
        }

        // Are we currently ARMED and conditions are such (autopilot on or flaps
        // down) that we should become INACTIVE?
        // decision D2
        if ((state == State.ARMED) && (autopilotOn || flapsDown))
        {
            state = State.INACTIVE;
        }

        // Are we currently ARMED and conditions are such (angle of attack is
        // too high) that we should be ACTIVE and generate a trim DOWN command?
        // decision D3
        if ((state == State.ARMED) && (angleOfAttack > AOA_THRESHOLD))
        {
            state = State.ACTIVE;
            command = Command.DOWN;
            timer.set();
        }

        // Are we currently ACTIVE and conditions are such (autopilot on or
        // flaps down) that we should become INACTIVE?
        // decision D4
        if ((state == State.ACTIVE) && (autopilotOn || flapsDown))
        {
            state = State.INACTIVE;
        }

        // Are we currently ACTIVE and conditions are such (angle of attack is
        // no longer too high) that we should become ARMED?
        // decision D5
        if ((state == State.ACTIVE) && (angleOfAttack <= AOA_THRESHOLD))
        {
            state = State.ARMED;
        }

        // Are we currently ACTIVE and conditions are such (angle of attack is
        // still too high and the necessary time has elapsed since our last trim
        // DOWN command) that we should send a trim DOWN command?
        // decision D6
        if ((state == State.ACTIVE) && (angleOfAttack > AOA_THRESHOLD)
                && timer.isExpired())
        {
            command = Command.DOWN;
            timer.set();
        }

        // Return the desired trim command
        return command;
    }

    // FOR TESTING: TEST METHOD ADDED FOR OBSERVABILITY
    // This method must not change any internal state.
    // While "test-only" code is generally discouraged
    // in safety-critical software, the safety approval
    // authority has reviewed this addition and approved
    // its inclusion into the deliverable software.
    public final State getState()
    {
        return state;
    }

}