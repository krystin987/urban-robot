package com.elevator;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Manages elevator operations such as handling floor requests,
 * controlling movement, and simulating behavior.
 */
public class ElevatorController {
    private final Elevator elevator; // The elevator being controlled
    private final Queue<FloorRequest> requestQueue; // Queue of floor requests
    private String direction; // Current direction: "UP", "DOWN", or "IDLE"

    /**
     * Initializes the controller for a given elevator.
     *
     * @param elevator the elevator to control
     */
    public ElevatorController(Elevator elevator) {
        this.elevator = elevator;
        this.requestQueue = new LinkedList<>();
        this.direction = "IDLE";
    }

    /**
     * Adds a floor request to the queue and processes it.
     *
     * @param floor     the requested floor
     * @param direction the direction of the request ("UP" or "DOWN")
     */
    public void requestFloor(int floor, String direction) {
        if (!validateFloor(floor)) {
            return;
        }
        requestQueue.add(new FloorRequest(floor, direction));
        processNextRequest();
    }

    private void processNextRequest() {
        if (requestQueue.isEmpty()) {
            return;
        }

        FloorRequest request = requestQueue.poll();
        if (request != null) {
            moveToFloor(request.getRequestedFloor());
            request.markAsServed();
        }
    }

    /**
     * Moves the elevator to a specified floor.
     *
     * @param floor the target floor
     */
    public void moveToFloor(int floor) {
        if (!validateFloor(floor)) {
            return;
        }

        if (elevator.isDoorOpen()) {
            System.out.println("Cannot move while the door is open. Please close the door first.");
            return;
        }

        direction = determineDirection(floor);
        System.out.println("Elevator is moving " + direction + " " + getArrow(direction) + " from floor " + elevator.getCurrentFloor() + " to floor " + floor + "...");
        simulateMovement(floor);
        elevator.moveToFloor(floor);
        direction = "IDLE";
        System.out.println("Elevator has arrived at floor " + floor + ".");
    }

    private boolean validateFloor(int floor) {
        if (floor < elevator.getMinFloor() || floor > elevator.getMaxFloor()) {
            System.out.println("Invalid floor: " + floor + ". The floor must be between " + elevator.getMinFloor() + " and " + elevator.getMaxFloor() + ".");
            return false;
        }
        return true;
    }

    private String determineDirection(int floor) {
        return floor > elevator.getCurrentFloor() ? "UP" : "DOWN";
    }


    private String getArrow(String direction) {
        return direction.equals("UP") ? "↑" : "↓";
    }

    private void simulateMovement(int targetFloor) {
        int floorsToMove = Math.abs(targetFloor - elevator.getCurrentFloor());
        try {
            for (int i = 0; i < floorsToMove; i++) {
                Thread.sleep(1000); // Simulate 1 second per floor
                int current = elevator.getCurrentFloor() + (direction.equals("UP") ? 1 : -1);
                elevator.moveToFloor(current);
                System.out.println("Passing floor " + current + "...");
            }
        } catch (InterruptedException e) {
            System.out.println("Elevator movement interrupted.");
        }
    }

    public String getDirection() {
        return direction;
    }
}
