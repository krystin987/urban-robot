package com.elevator;

import java.util.LinkedList;
import java.util.Queue;

public class ElevatorController {
    private final Elevator elevator;
    private final Queue<FloorRequest> requestQueue;
    private String direction; // "UP", "DOWN", or "IDLE"

    public ElevatorController(Elevator elevator) {
        this.elevator = elevator;
        this.requestQueue = new LinkedList<>();
        this.direction = "IDLE";
    }

    public void requestFloor(int floor, String direction) {
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

    public void moveToFloor(int floor) {
        if (floor < elevator.getMinFloor() || floor > elevator.getMaxFloor()) {
            System.out.println("Invalid floor: " + floor + ". The floor must be between " + elevator.getMinFloor() + " and " + elevator.getMaxFloor() + ".");
            return;
        }

        if (floor == elevator.getCurrentFloor()) {
            System.out.println("Elevator is already on floor " + floor + ".");
            return;
        }

        if (elevator.isDoorOpen()) {
            System.out.println("Cannot move while the door is open. Please close the door first.");
            return;
        }

        // Determine the direction
        direction = floor > elevator.getCurrentFloor() ? "UP" : "DOWN";
        String arrow = direction.equals("UP") ? "↑" : "↓";
        System.out.println("Elevator is moving " + direction + " " + arrow +  " from floor " + elevator.getCurrentFloor() + " to floor " + floor + "...");

        // Simulate the movement with an animated delay
        try {
            int floorsToMove = Math.abs(floor - elevator.getCurrentFloor());
            for (int i = 0; i < floorsToMove; i++) {
                Thread.sleep(1000); // Simulate 1 second delay per floor

                // Print a dot every half second to indicate waiting
                System.out.print(".");
                Thread.sleep(500);
            }
            System.out.println(); // Move to a new line after the animation
        } catch (InterruptedException e) {
            System.out.println("Elevator movement interrupted.");
        }

        elevator.moveToFloor(floor);
        direction = "IDLE";
        System.out.println("Elevator has arrived at floor " + floor + ".");
    }

    public String getDirection() {
        return direction;
    }
}
