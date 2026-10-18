Milestone 4: Task Processing Queue
Overview
For this milestone, I added a task processing queue to the Student Study & Assignment Planner. The queue holds incomplete assignments and processes them in the order they are added.
Data Structure
I used a FIFO (First-In, First-Out) queue implemented with Java’s ArrayDeque. This structure is suitable because the oldest waiting assignment should be processed first.
Main Features
* Add incomplete assignments to the queue.
* View the next assignment without removing it.
* Process the next assignment and mark it as completed.
* Check the queue size and whether it is empty.
* View waiting assignments in their processing order.
* Clear the queue without marking waiting assignments as completed.
* Reject null tasks, completed tasks, and duplicate assignment IDs in the queue.
  Testing
  I added unit tests for queue behavior, including FIFO ordering, empty queues, adding and processing tasks, task completion, duplicate rejection, and clearing the queue. The test run reported 39 tests passed with exit code 0.
  AI Assistance
  I used ChatGPT to help me understand the concept, organize ideas, and clarify the project requirements.