package com.example.elevator;

import static org.junit.jupiter.api.Assertions.*;

import com.elevator.Elevator;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Elevator class.
 */
public class ElevatorTest {

    @Test
    public void testDoorOpensSuccessfully() {
        Elevator elevator = new Elevator();
        elevator.openDoor();
        assertTrue(elevator.isDoorOpen(), "Door should be open after calling openDoor.");
    }

    @Test
    public void testDoorClosesSuccessfully() {
        Elevator elevator = new Elevator();
        elevator.openDoor(); // First open the door to ensure it can close
        elevator.closeDoor();
        assertFalse(elevator.isDoorOpen(), "Door should be closed after calling closeDoor.");
    }

    @Test
    public void testDoorRemainsClosedWhenCloseCalledTwice() {
        Elevator elevator = new Elevator();
        elevator.closeDoor(); // Close first time
        elevator.closeDoor(); // Attempt to close again
        assertFalse(elevator.isDoorOpen(), "Door should remain closed if closeDoor is called twice.");
    }

    @Test
    public void testDoorRemainsOpenWhenOpenCalledTwice() {
        Elevator elevator = new Elevator();
        elevator.openDoor(); // Open first time
        elevator.openDoor(); // Attempt to open again
        assertTrue(elevator.isDoorOpen(), "Door should remain open if openDoor is called twice.");
    }
}
