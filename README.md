# Elevator Simulation

## Overview
This project simulates a simple elevator system with the ability to move between floors, open/close doors, and handle multiple user requests. The system consists of three main components:

## Project Structure
```
src
├── main
│   └── java
│       └── com
│           └── elevator
│               ├── Elevator.java
│               ├── ElevatorController.java
│               └── FloorRequest.java
└── test
    └── java
        └── com
            └── elevator
                ├── ElevatorTest.java
                ├── ElevatorControllerTest.java
                └── FloorRequestTest.java
```

## Description of the Program

### Elevator.java
- **Responsibilities**: Manages the core state of the elevator, including:
    - Current floor.
    - Door status (open or closed).
    - Floor boundaries (minimum and maximum floors).
- **Key Methods**:
    - `setDoorState(boolean open)`: Opens or closes the elevator door based on the input.
    - `moveToFloor(int floor)`: Updates the current floor of the elevator.
    - `getCurrentFloor()`: Returns the current floor of the elevator.
    - `getMinFloor()`, `getMaxFloor()`: Get the minimum and maximum floors that the elevator can reach.
- **Main Functionality**:
    - Includes a command-line interface that allows users to control the elevator with commands like `open`, `close`, `move <floor>`, and `exit`.

### ElevatorController.java
- **Responsibilities**: Manages the movement and request handling for the elevator.
    - Handles user requests to move the elevator to different floors.
    - Simulates the movement of the elevator between floors.
    - Ensures that door status is properly managed before allowing movement.
- **Key Methods**:
    - `requestFloor(int floor, String direction)`: Queues a floor request and processes it.
    - `moveToFloor(int floor)`: Moves the elevator to the specified floor, simulating the time taken per floor with a delay.
    - `validateFloor(int floor)`: Validates whether the requested floor is within the acceptable range.
    - `getDirection()`: Returns the current direction of the elevator (`"UP"`, `"DOWN"`, or `"IDLE"`).
    - `determineDirection(int floor)`: Determines the direction of travel based on the target floor.
    - `simulateMovement(int targetFloor)`: Simulates the elevator's movement between floors.
- **Movement Simulation**:
    - Uses `Thread.sleep()` to simulate a delay for each floor movement and provides a textual animation to indicate the elevator's progress.

### FloorRequest.java
- **Responsibilities**: Represents requests for the elevator to move to a specific floor in a given direction.
- **Key Methods**:
    - `getRequestedFloor()`: Returns the floor number of the request.
    - `getDirection()`: Returns the direction of the request.
    - `markAsServed()`: Marks the request as served.
    - `isServed()`: Checks if the request has already been served.

### Test Classes
- **ElevatorTest.java**, **ElevatorControllerTest.java**, and **FloorRequestTest.java**:
    - Unit tests for validating the functionality of `Elevator`, `ElevatorController`, and `FloorRequest`.
    - **Test Coverage**:
        - Testing door operations, valid and invalid floor movements.
        - Ensuring proper request processing and direction handling.
        - Testing scenarios like multiple requests, door status, and movement validity.
      
## How to Run the Program

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/krystin987/urban-robot.git
   ```
2. **Compile and Run:** Use an IDE like IntelliJ or Eclipse, or compile using the command line:
    ```bash
    mvn clean compile
   ```

3. Run Tests: 
    ```bash
    mvn test
   ```

## Key Features
* **Core Elevator Functionality**: Move between floors, open and close doors, and handle valid and invalid floor requests. 
* **Movement Simulation**: Uses Thread.sleep() to simulate the time taken to move between floors, with a dot animation to represent waiting. 
* **Direction Indicators**: Displays arrow symbols ("↑" for up and "↓" for down) to indicate the direction of travel.

## Potential Improvements
1. **Multiple Elevators**: Extend the system to handle multiple elevators, with an optimal allocation of requests. 
2. **Priority Requests**: Implement priority requests for emergency cases. 
3. **Request Scheduling**: Implement an advanced scheduling algorithm to minimize the wait time for each request.: Implement an advanced scheduling algorithm to minimize the wait time for each request. 
4. **Graphical Interface**: Add a GUI to visualize the elevator operations in real-time. 
5. **Weight Sensor**: Implement a weight sensor to avoid moving if the weight exceeds a certain limit.

## Future Features
1. **Optimized Request Management**: Improve the request handling logic to minimize wait times and energy usage. 
2. **Voice Commands**: Introduce voice commands to control the elevator.
3. **Safety Features**: Include safety features such as emergency brakes and safety notifications.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.