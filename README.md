# CS-116 Project: Java Course Registration System

[cite_start]This project is a simplified course-registration program implemented in Java[cite: 6]. [cite_start]It simulates a scenario where a student accesses a school's database to register for Computer Science (CS) courses for the upcoming semester[cite: 7, 11]. [cite_start]The system reads input files containing course and student data, allows users to interact via the console, and updates the database files upon exiting[cite: 9, 12, 22].

## Table of Contents
* [Installation](#installation)
* [Usage](#usage)
* [Features](#features)
* [Project Structure](#project-structure)
* [Contributing](#contributing)
* [License](#license)
* [Optional Goals](#optional-goals)

## Installation

* [cite_start]The program must be implemented as a new Java project[cite: 26].
* [cite_start]Ensure that the input data files, referred to as `file1` (e.g., "CS-26F.txt") and `file2` (e.g., "A20123456.txt"), are placed within the same Java project directory[cite: 10, 11, 13, 14, 48, 59].

## Usage

* [cite_start]Run the client class to start the application[cite: 30].
* [cite_start]Follow the console prompts, which provide clear and accurate guides to input files and choose functions[cite: 46].
* [cite_start]The program will continue to run and will only terminate if you explicitly choose the exit function[cite: 47].
* [cite_start]After a course is registered or rejected, the program will give clear responses in the console[cite: 86].
* [cite_start]Upon exiting, the program updates the data files, allowing you to use the updated `file1` and `file2` to run the program again in subsequent sessions[cite: 24].

## Features

* [cite_start]**View Available Courses:** Print in the console all the courses provided in the following semester, sorted by course ID[cite: 16].
* [cite_start]**View Course History:** Print all the courses that the user has taken before[cite: 17].
* [cite_start]**Search:** Search for specific courses by their course ID[cite: 18].
* [cite_start]**Register for Courses:** Register for a next-semester course, subject to the following rules[cite: 19]:
    * [cite_start]The student must have taken all prerequisites[cite: 76].
    * [cite_start]The course must still have open seats[cite: 78].
    * [cite_start]A student can register for a maximum of 5 courses per semester[cite: 80].
    * [cite_start]A student cannot register for a course they have already taken[cite: 82].
    * [cite_start]A student cannot register for the same course multiple times[cite: 84].
* [cite_start]**Cancel Registration:** Cancel a course that was successfully registered for the coming semester, including courses registered in previous runs of the program[cite: 87, 91, 92].
* [cite_start]**Data Persistence:** Exit the program and write the updated registration information directly back into `file1` (updating the Status columns) and `file2` (appending newly registered courses)[cite: 93, 95, 97, 99].

## Project Structure

* [cite_start]**`Course` Class**: Stores course information including a String ID, a String name, the number of total seats, the number of registered seats, and course prerequisites[cite: 28, 33, 34, 35].
* [cite_start]**`Student` Class**: Stores student information including a String ID (A-number), a String name, previously taken courses, and courses the student is about to take next semester[cite: 29, 38, 39, 41].
* [cite_start]**Client Class**: Acts as the main entry point and driver for the program[cite: 30].

## Contributing

* [cite_start]This is a team project; each team can be formed by at most three students[cite: 1, 3].
* [cite_start]Only one team member needs to fill out the "CS-116 Project Teams" form and make the final submission on Canvas[cite: 4, 121].
* [cite_start]The final submission must include three items: a class diagram showing the program's design, a zipped file of the entire Java project, and a short README file explaining which optional goals were realized and how[cite: 121, 122, 123, 124].

## License

All Rights Reserved.

## Optional Goals

* [cite_start]Use at least one user-defined interface or abstract class[cite: 108].
* [cite_start]Implement a custom data structure (e.g., an ArrayList-like structure) to handle data[cite: 109].
* [cite_start]Demonstrate polymorphism in the code[cite: 111].
* [cite_start]Use the Merge Sort algorithm for sorting operations[cite: 112].
* [cite_start]Use the Binary Search algorithm for searching operations[cite: 114].
* [cite_start]Successfully realize the "canceling a registered course" function[cite: 116].
* [cite_start]Add two additional reasonable and useful functions[cite: 118].
* [cite_start]Handle exceptions and invalid inputs gracefully without breaking the program's flow[cite: 119].