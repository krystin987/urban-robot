package com.elevator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testMarkFloorRequestAsServed() {
        FloorRequest request = new FloorRequest(4, "UP");
        assertFalse(request.isServed(), "New floor request should not be marked as served initially.");

        request.markAsServed();
        assertTrue(request.isServed(), "Floor request should be marked as served after being handled.");
    }

    @Test
    public void testMultipleRequests() throws InterruptedException {
        Elevator elevator = new Elevator(1, 5);
        ElevatorController controller = new ElevatorController(elevator);
        elevator.closeDoor();

        controller.requestFloor(3, "UP");
        controller.requestFloor(5, "UP");

        Thread.sleep(3000); // Simulate time for elevator to process both requests
        assertEquals(5, elevator.getCurrentFloor(), "Elevator should end up on the last requested floor.");
    }

    @Test
    public void testMultipleRequestsReverseOrder() throws InterruptedException {
        Elevator elevator = new Elevator(1, 5);
        ElevatorController controller = new ElevatorController(elevator);
        elevator.closeDoor();

        controller.requestFloor(5, "UP");
        controller.requestFloor(2, "DOWN");

        Thread.sleep(5000); // Simulate time for elevator to process all requests
        assertEquals(2, elevator.getCurrentFloor(), "Elevator should end up at the last requested floor after processing all requests.");
    }

    @Test
    public void testRepeatedFloorRequests() throws InterruptedException {
        Elevator elevator = new Elevator(1, 5);
        ElevatorController controller = new ElevatorController(elevator);
        elevator.closeDoor();

        controller.requestFloor(4, "UP");
        controller.requestFloor(4, "UP");

        Thread.sleep(2000); // Simulate time for elevator to process the request
        assertEquals(4, elevator.getCurrentFloor(), "Elevator should move to the requested floor only once.");
    }
    @Test
    public void testConcurrentRequests() throws InterruptedException {
        Elevator elevator = new Elevator(1, 5);
        ElevatorController controller = new ElevatorController(elevator);
        elevator.closeDoor();

        Thread thread1 = new Thread(() -> controller.requestFloor(3, "UP"));
        Thread thread2 = new Thread(() -> controller.requestFloor(5, "UP"));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        Thread.sleep(5000); // Simulate time for elevator to process all requests
        assertEquals(5, elevator.getCurrentFloor(), "Elevator should process all concurrent requests and end on the last requested floor.");
    }
    @Test
    public void testInvalidDirectionRequest() {
        FloorRequest request = new FloorRequest(3, "LEFT");
        assertEquals("LEFT", request.getDirection(), "Floor request should store the invalid direction as is.");
    }
    @Test
    public void testMixedRequests() throws InterruptedException {
        Elevator elevator = new Elevator(1, 5);
        ElevatorController controller = new ElevatorController(elevator);
        elevator.closeDoor();

        controller.requestFloor(4, "UP");
        controller.requestFloor(6, "UP"); // Invalid floor
        controller.requestFloor(2, "DOWN");

        Thread.sleep(5000); // Simulate time for elevator to process valid requests
        assertEquals(2, elevator.getCurrentFloor(), "Elevator should process only valid requests and end on the last valid floor.");
    }


}
