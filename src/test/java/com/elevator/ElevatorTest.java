package com.elevator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Elevator class.
 */
public class ElevatorTest {

    @Test
    public void testDoorOpensSuccessfully() {
        Elevator elevator = new Elevator(1, 5);
        elevator.setDoorState(true);
        assertTrue(elevator.isDoorOpen(), "Door should be open after calling openDoor.");
    }

    @Test
    public void testDoorClosesSuccessfully() {
        Elevator elevator = new Elevator(1, 5);
        elevator.setDoorState(true); // First open the door to ensure it can close
        elevator.setDoorState(false);
        assertFalse(elevator.isDoorOpen(), "Door should be closed after calling closeDoor.");
    }

    @Test
    public void testDoorRemainsClosedWhenCloseCalledTwice() {
        Elevator elevator = new Elevator(1, 5);
        elevator.setDoorState(false); // Close first time
        elevator.setDoorState(false); // Attempt to close again
        assertFalse(elevator.isDoorOpen(), "Door should remain closed if closeDoor is called twice.");
    }

    @Test
    public void testDoorRemainsOpenWhenOpenCalledTwice() {
        Elevator elevator = new Elevator(1, 5);
        elevator.setDoorState(true); // Open first time
        elevator.setDoorState(true); // Attempt to open again
        assertTrue(elevator.isDoorOpen(), "Door should remain open if openDoor is called twice.");
    }

}
