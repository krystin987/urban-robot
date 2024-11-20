# Elevator Simulation

This is a simple Java-based simulation of an elevator system, designed to mimic the basic behavior of an elevator moving between floors. The program models the core functionalities of an elevator, including moving between floors, handling floor requests, opening and closing doors, and displaying direction indicators using arrow symbols.

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
- **Responsibilities**: Manages the core state of the elevator, including the current floor, door status (open or closed), and floor boundaries (minimum and maximum floors).
- **Key Methods**:
    - `openDoor()`: Opens the elevator door if it's not already open.
    - `closeDoor()`: Closes the elevator door if it's not already closed.
    - `moveToFloor(int floor)`: Moves the elevator to the specified floor.

### ElevatorController.java
- **Responsibilities**: Handles the movement logic of the elevator and manages floor requests. This includes determining the direction of travel and simulating movement between floors with delays and animations.
- **Key Methods**:
    - `moveToFloor(int floor)`: Moves the elevator to the desired floor, using a delay to simulate time passing.
    - `requestFloor(int floor, String direction)`: Queues a floor request and processes it.
    - `getDirection()`: Returns the current direction of the elevator ("UP", "DOWN", or "IDLE").

### FloorRequest.java
- **Responsibilities**: Represents a request for the elevator to move to a specific floor, including the desired direction ("UP" or "DOWN").
- **Key Methods**:
    - `getRequestedFloor()`: Returns the floor number of the request.
    - `getDirection()`: Returns the direction of the request.
    - `markAsServed()`: Marks the request as served.

### ElevatorTest.java & FloorRequestTest.java
- **Responsibilities**: Unit tests to ensure the functionality of the `Elevator`, `ElevatorController`, and `FloorRequest` classes.
- **Test Coverage**: Includes tests for door operations, valid and invalid floor movements, floor requests, and direction indicators.

## How to Run the Program

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/elevator-simulation.git
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
* Core Elevator Functionality: Move between floors, open and close doors, and handle valid and invalid floor requests. 
* Movement Simulation: Uses Thread.sleep() to simulate the time taken to move between floors, with a dot animation to represent waiting. 
* Direction Indicators: Displays arrow symbols ("↑" for up and "↓" for down) to indicate the direction of travel.

## Potential Improvements
1. Enhanced Request Management: Implement a more sophisticated algorithm to handle multiple simultaneous floor requests efficiently, such as an "elevator bank" algorithm that serves requests in the optimal order. 
2. Concurrency and Multi-Threading: Use Java's concurrency features to allow the elevator to handle multiple requests and simulate real-time behavior. 
3. GUI Interface: Develop a graphical user interface using JavaFX or Swing to make the simulation more interactive and visually appealing. 
4. Persistent Logging: Add a logging system to keep a record of all elevator movements and events for analysis. 
5. Error Handling: Improve error handling and exception management, especially for unexpected interruptions during elevator movement.

## Future Features
1. Multiple Elevators: Expand the system to manage multiple elevators, coordinating their movements to optimize service time. 
2. Smart Scheduling: Implement advanced scheduling algorithms, such as those that prioritize requests based on proximity or urgency. 
3. Accessibility Features: Add features for accessibility, such as voice commands, floor announcements, and braille interface simulation. 
4. Energy Efficiency Mode: Introduce an energy-saving mode where the elevator operates at reduced speed during off-peak hours. 
5. Emergency Handling: Simulate emergency features, such as an emergency stop button, fire alarm response, and automatic return to the ground floor.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.
