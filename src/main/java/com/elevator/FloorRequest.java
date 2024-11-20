package com.elevator;

/**
 * Represents a request for a specific floor in a given direction.
 */
public class FloorRequest {
    private final int requestedFloor; // The floor being requested
    private final String direction;  // The direction of the request ("UP" or "DOWN")
    private boolean isServed;        // Indicates if the request has been completed

    /**
     * Creates a new floor request.
     *
     * @param requestedFloor the floor being requested
     * @param direction      the direction of the request
     */
    public FloorRequest(int requestedFloor, String direction) {
        this.requestedFloor = requestedFloor;
        this.direction = direction;
        this.isServed = false;
    }

    public int getRequestedFloor() {
        return requestedFloor;
    }

    public String getDirection() {
        return direction;
    }

    public boolean isServed() {
        return isServed;
    }

    public void markAsServed() {
        this.isServed = true;
    }

}