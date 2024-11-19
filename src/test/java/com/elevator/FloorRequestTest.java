package com.elevator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FloorRequestTest {

    @Test
    public void testFloorRequestHandling() {
        Elevator elevator = new Elevator(1, 5);
        ElevatorController controller = new ElevatorController(elevator);
        elevator.closeDoor();
        controller.requestFloor(4, "UP");
        assertEquals(4, elevator.getCurrentFloor(), "Elevator should handle floor requests and move to floor 4.");
    }

    @Test
    public void testInvalidFloorRequest() {
        Elevator elevator = new Elevator(1, 5);
        ElevatorController controller = new ElevatorController(elevator);
        elevator.closeDoor();
        controller.requestFloor(6, "UP"); // Invalid floor
        assertEquals(1, elevator.getCurrentFloor(), "Elevator should remain on the current floor when an invalid floor is requested.");
    }

}
