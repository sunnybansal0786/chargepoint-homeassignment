# Truck Charging Scheduler

This Java project provides an implementation to schedule the charging of a fleet of electric mail trucks overnight, ensuring as many trucks as possible are fully charged using the available chargers within a given time frame.

## Overview

The project is designed to:
- Schedule the charging of trucks with varying battery levels using chargers with different power ratings.
- Optimize the assignment of trucks to chargers based on their energy requirements and the available charging time.
- Utilize a **GreedySchedulerSingle** algorithm to allocate trucks to chargers in a way that maximizes the number of trucks fully charged by the end of the charging window.

### Key Features
- **Scheduler Interface:** Defines the structure for different scheduling algorithms.
- **GreedySchedulerSingle Class:** Implements a greedy scheduling strategy that sorts trucks by the amount of energy required and assigns them to chargers in descending order of power.
- **Test Suite:** Includes unit tests to validate the correctness of the scheduling algorithm.

## Project Structure

The project is structured as follows:

```
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com.homeassignment.model
│   │   │   │   ├── Truck.java
│   │   │   │   ├── Charger.java
│   │   │   ├── com.homeassignment.scheduler
│   │   │   │   ├── Scheduler.java
│   │   │   │   ├── GreedySchedulerSingle.java
│   ├── test
│   │   ├── java
│   │   │   ├── com.homeassignment.scheduler
│   │   │   │   ├── GreedySchedulerSingleTest.java
```

## How it Works

1. **Truck Class:**
   - Represents a truck with attributes like `id`, `batteryCapacity`, and `currentCharge`.
   - Tracks how much energy is needed to fully charge the truck.

2. **Charger Class:**
   - Represents a charger with attributes like `id` and `rate` (in kilowatts).

3. **Scheduler Interface:**
   - Provides a method `schedule(Truck[] trucks, Charger[] chargers, int availableHours)` that returns a map of assigned trucks for each charger.

4. **GreedySchedulerSingle:**
   - Implements the scheduling logic using a greedy approach to assign trucks to chargers based on energy needs and charger capacity.

### Sample Input and Output

Input:
- Trucks with varying battery levels.
- Chargers with different power ratings.
- Available charging time (e.g., 5 hours).

Output:
- A schedule of which trucks should be charged by which charger.

```
Truck 5 cannot be fully charged within 5 hours.
Charging Schedule:
Charger 2: Truck 4, Truck 1, Truck 3
Charger 1: Truck 2
```

## How to Run

1. Clone the repository:
   ```
   git clone https://github.com/your-repo/chargepoint-homeassignment.git
   ```

2. Compile and run the project:
   ```
   javac -d bin src/main/java/com/homeassignment/scheduler/GreedySchedulerSingle.java
   java -cp bin com.homeassignment.scheduler.GreedySchedulerSingle
   ```

3. Run tests:
   ```
   javac -d bin src/test/java/com/homeassignment/scheduler/SchedulerTest.java
   java -cp bin com.homeassignment.scheduler.SchedulerTest
   ```

## Future Improvements

- **Additional Scheduling Algorithms:** More sophisticated scheduling techniques such as dynamic programming or priority-based algorithms can be implemented.
- **Charger and Truck Balancing:** Optimizing the assignment of chargers to trucks based on the charging requirements and power ratings.

## Contributing

Feel free to fork the project, create new branches, and submit pull requests. Contributions are welcome!

## License

This project is licensed under the MIT License.

---

This structure should help users understand the project’s purpose, how to use it, and potential areas for improvement. Let me know if you need more details on any section!