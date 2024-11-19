package com.elevator;

public class Elevator {

    private boolean isDoorOpen;

    public Elevator() {
        this.isDoorOpen = false;
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

    public boolean isDoorOpen() {
        return isDoorOpen;
    }

    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        elevator.openDoor();
        elevator.closeDoor();
    }

}