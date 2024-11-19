package com.example.elevator;

import static org.junit.jupiter.api.Assertions.*;

import com.elevator.Elevator;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Elevator class.
 */
public class ElevatorTest {

    @Test
    public void testOpenDoor() {
        Elevator elevator = new Elevator();
        elevator.openDoor();
        assertTrue(elevator.isDoorOpen(), "The door should be open.");
    }

    @Test
    public void testCloseDoor() {
        Elevator elevator = new Elevator();
        elevator.openDoor();
        elevator.closeDoor();
        assertFalse(elevator.isDoorOpen(), "The door should be closed.");
    }

    @Test
    public void testCallElevator() {
        Elevator elevator = new Elevator();
        elevator.callElevator();
        assertTrue(elevator.isDoorOpen(), "The door should be open after calling the elevator.");
        assertEquals(1, elevator.getCurrentFloor(), "The elevator should be on the only floor.");
    }
}
