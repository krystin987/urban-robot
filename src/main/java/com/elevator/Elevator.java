package com.elevator;

import java.util.Scanner;

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

    public static void main(String[] args) {
        Elevator elevator = new Elevator(1, 5);
        ElevatorController controller = new ElevatorController(elevator);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the elevator system!");
        System.out.println("Elevator is ready at floor " + elevator.getCurrentFloor() + ".");
        System.out.println("Commands: open, close, move <floor>, exit");

        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0];
            int floor;

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting elevator system. Goodbye!");
                break;
            } else if (command.equalsIgnoreCase("open")) {
                elevator.openDoor();
            } else if (command.equalsIgnoreCase("close")) {
                elevator.closeDoor();
            } else if (command.equalsIgnoreCase("move")) {
                if (parts.length < 2) {
                    System.out.println("Please specify a floor to move to.");
                    continue;
                }
                try {
                    floor = Integer.parseInt(parts[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid floor number.");
                    continue;
                }
                controller.requestFloor(floor, floor > elevator.getCurrentFloor() ? "UP" : "DOWN");
            } else {
                System.out.println("Unknown command. Please try again.");
            }
        }

        scanner.close();
    }

}