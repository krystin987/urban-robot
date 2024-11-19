package com.elevator;

import static org.junit.jupiter.api.Assertions.*;

import com.elevator.Elevator;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Elevator class.
 */
public class ElevatorTest {

    @Test
    public void testDoorOpensSuccessfully() {
        Elevator elevator = new Elevator(1, 5);
        elevator.openDoor();
        assertTrue(elevator.isDoorOpen(), "Door should be open after calling openDoor.");
    }

    @Test
    public void testDoorClosesSuccessfully() {
        Elevator elevator = new Elevator(1, 5);
        elevator.openDoor(); // First open the door to ensure it can close
        elevator.closeDoor();
        assertFalse(elevator.isDoorOpen(), "Door should be closed after calling closeDoor.");
    }

    @Test
    public void testDoorRemainsClosedWhenCloseCalledTwice() {
        Elevator elevator = new Elevator(1, 5);
        elevator.closeDoor(); // Close first time
        elevator.closeDoor(); // Attempt to close again
        assertFalse(elevator.isDoorOpen(), "Door should remain closed if closeDoor is called twice.");
    }

    @Test
    public void testDoorRemainsOpenWhenOpenCalledTwice() {
        Elevator elevator = new Elevator(1, 5);
        elevator.openDoor(); // Open first time
        elevator.openDoor(); // Attempt to open again
        assertTrue(elevator.isDoorOpen(), "Door should remain open if openDoor is called twice.");
    }

    @Test
    public void testMoveToValidFloor() {
        Elevator elevator = new Elevator(1, 5);
        elevator.closeDoor();
        elevator.moveToFloor(3);
        assertEquals(3, elevator.getCurrentFloor(), "Elevator should be on floor 3 after moving.");
    }

    @Test
    public void testCannotMoveWithDoorOpen() {
        Elevator elevator = new Elevator(1, 5);
        elevator.openDoor();
        elevator.moveToFloor(3);
        assertEquals(1, elevator.getCurrentFloor(), "Elevator should not move when the door is open.");
    }

    @Test
    public void testInvalidFloor() {
        Elevator elevator = new Elevator(1, 5);
        elevator.closeDoor();
        elevator.moveToFloor(6); // Invalid floor
        assertEquals(1, elevator.getCurrentFloor(), "Elevator should remain on the current floor when an invalid floor is requested.");
    }

    @Test
    public void testMoveToSameFloor() {
        Elevator elevator = new Elevator(1, 5);
        elevator.closeDoor();
        elevator.moveToFloor(1);
        assertEquals(1, elevator.getCurrentFloor(), "Elevator should remain on the same floor if already on the requested floor.");
    }
}
