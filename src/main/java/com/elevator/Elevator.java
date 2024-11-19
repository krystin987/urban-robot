package com.elevator;

public class Elevator {
    private boolean isDoorOpen;
    private int currentFloor;
    private final int minFloor;
    private final int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.isDoorOpen = false;
        this.currentFloor = minFloor; // Start at the minimum floor
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public void openDoor() {
        if (!isDoorOpen) {
            isDoorOpen = true;
            System.out.println("Door is now open.");
        } else {
            System.out.println("Door is already open.");
        }
    }

    public void closeDoor() {
        if (isDoorOpen) {
            isDoorOpen = false;
            System.out.println("Door is now closed.");
        } else {
            System.out.println("Door is already closed.");
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public boolean isDoorOpen() {
        return isDoorOpen;
    }

    public void moveToFloor(int floor) {
        currentFloor = floor;
    }

    public int getMinFloor() {
        return minFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

}