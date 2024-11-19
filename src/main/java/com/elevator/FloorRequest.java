package com.elevator;

public class FloorRequest {
    private final int requestedFloor;
    private final String direction; // "UP" or "DOWN"
    private boolean isServed;

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