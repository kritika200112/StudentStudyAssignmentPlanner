# Student Study & Assignment Planner

## Project Overview

This Java application helps college students organize their assignments, courses, due dates, priorities, and completion status.

## Project Purpose

The goal is to make it easier for students to manage schoolwork in one place. Students can organize assignments, find specific tasks, update assignment details, remove assignments, and view task summaries.

## Main Classes

- **Student:** Stores the student's ID and name and provides access to the student's planner.
- **StudyPlanner:** Manages assignments using an ArrayList and supports adding, retrieving, updating, removing, and summarizing tasks.
- **ProjectTask:** Represents an assignment with an ID, title, course, due date, priority, and completion status.

## Current Features

- Store assignment information.
- Search for assignments by assignment ID using sequential search.
- Add new assignments and reject duplicate IDs.
- Retrieve, update, and remove assignments.
- Track completed and incomplete assignments.
- Display all assignments in insertion order.
- Validate required information and handle invalid input.

## Baseline Algorithm

The baseline algorithm searches for an assignment by its ID using sequential search. It checks tasks one at a time until it finds a match or reaches the end of the list.

- Best-case time complexity: O(1)
- Average-case time complexity: O(n)
- Worst-case time complexity: O(n)
- Auxiliary space complexity: O(1)

Here, n is the number of assignments in the list.

## Testing

JUnit 5 is used for automated testing. The project currently reports 24 passing tests. Tests cover sequential search, assignment management, invalid input, duplicate IDs, updates, removals, and task summaries.

## Technology

- Java
- IntelliJ IDEA
- JUnit 5
- Git

## Documentation

- `class-diagram.md` describes the main classes and their relationships.
- `complexity-analysis.md` explains the time and space complexity of the main operations.

## Future Development

Possible improvements include sorting assignments, using a HashMap for faster ID lookups, and adding more study-planning features.

## AI Use Disclosure

AI tools were used to help understand project requirements and discuss implementation and documentation. The project author is responsible for reviewing the code, understanding the design, testing the application, and ensuring that the final submission follows course policies.
