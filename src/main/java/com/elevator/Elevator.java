package com.elevator;

public class Elevator {

    private boolean doorOpen;
    private int currentFloor;

    public Elevator() {
        this.doorOpen = false;
        this.currentFloor = 1; // Starting at the only floor (floor 1)
    }

    public void openDoor() {
        if (!doorOpen) {
            doorOpen = true;
            System.out.println("Door is now open.");
        } else {
            System.out.println("Door is already open.");
        }
    }

    public void closeDoor() {
        if (doorOpen) {
            doorOpen = false;
            System.out.println("Door is now closed.");
        } else {
            System.out.println("Door is already closed.");
        }
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void callElevator() {
        System.out.println("Elevator is called to floor " + currentFloor + ".");
        if (!doorOpen) {
            openDoor();
        }
    }

}