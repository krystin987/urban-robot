package com.elevator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElevatorControllerTest {

    @Test
    public void testMoveToValidFloor() {
        Elevator elevator = new Elevator(1, 5);
        ElevatorController controller = new ElevatorController(elevator);
        elevator.setDoorState(false);
        controller.moveToFloor(3);
        assertEquals(3, elevator.getCurrentFloor(), "Elevator should be on floor 3 after moving.");
    }

    @Test
    public void testCannotMoveWithDoorOpen() {
        Elevator elevator = new Elevator(1, 5);
        ElevatorController controller = new ElevatorController(elevator);
        elevator.setDoorState(true);
        controller.moveToFloor(3);
        assertEquals(1, elevator.getCurrentFloor(), "Elevator should not move when the door is open.");
    }

    @Test
    public void testInvalidFloor() {
        Elevator elevator = new Elevator(1, 5);
        ElevatorController controller = new ElevatorController(elevator);
        elevator.setDoorState(false);
        controller.moveToFloor(6); // Invalid floor
        assertEquals(1, elevator.getCurrentFloor(), "Elevator should remain on the current floor when an invalid floor is requested.");
    }

    @Test
    public void testMoveToSameFloor() {
        Elevator elevator = new Elevator(1, 5);
        ElevatorController controller = new ElevatorController(elevator);
        elevator.setDoorState(false);
        controller.moveToFloor(1);
        assertEquals(1, elevator.getCurrentFloor(), "Elevator should remain on the same floor if already on the requested floor.");
    }

    @Test
    public void testElevatorDirectionIndicatorUp() {
        Elevator elevator = new Elevator(1, 5);
        ElevatorController controller = new ElevatorController(elevator);
        elevator.setDoorState(false);
        controller.moveToFloor(5);
        assertEquals("IDLE", controller.getDirection(), "Elevator direction should be IDLE after arriving at the destination.");
    }

    @Test
    public void testElevatorDirectionIndicatorDown() {
        Elevator elevator = new Elevator(1, 5);
        ElevatorController controller = new ElevatorController(elevator);
        elevator.setDoorState(false);
        controller.moveToFloor(5); // Move up first
        controller.moveToFloor(2); // Move down
    }

}
