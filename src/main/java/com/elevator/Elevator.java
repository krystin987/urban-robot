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

    public void moveToFloor(int floor) {
        if (floor < minFloor || floor > maxFloor) {
            System.out.println("Invalid floor: " + floor + ". The floor must be between " + minFloor + " and " + maxFloor + ".");
            return;
        }

        if (floor == currentFloor) {
            System.out.println("Elevator is already on floor " + floor + ".");
            return;
        }

        if (isDoorOpen) {
            System.out.println("Cannot move while the door is open. Please close the door first.");
            return;
        }

        System.out.println("Moving from floor " + currentFloor + " to floor " + floor + "...");
        currentFloor = floor;
        System.out.println("Elevator has arrived at floor " + currentFloor + ".");
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public boolean isDoorOpen() {
        return isDoorOpen;
    }

    public static void main(String[] args) {
        Elevator elevator = new Elevator(1, 5);
        System.out.println("Elevator initialized with floors 1 to 5. Ready for testing.");
    }

}