# Library Management System

## Overview
The **Library Management System** is a Java-based application designed to manage book inventory, borrowing, and returning operations in a library. The system allows users to add books, borrow books, return books, and view available books. It handles various exceptions, such as borrowing unavailable books or returning non-existent books.

This project follows the **Test-Driven Development (TDD)** approach, ensuring that each feature is tested before implementation. This helps maintain high code quality and ensures that the application behaves as expected.

## Features
- **Add Book**: Allows adding a new book to the library's inventory.
- **Borrow Book**: Allows borrowing a book if it is available.
- **Return Book**: Allows returning a borrowed book to the library.
- **View Available Books**: Lists all the books that are currently available in the library.
- **ISBN Validation**: Ensures that only valid ISBNs are accepted.

## Technologies Used
- **Java**: Core programming language.
- **JUnit**: For unit testing and TDD.
- **IntelliJ IDEA**: Integrated Development Environment (IDE).
- **DAO Pattern**: Used to separate data access logic from the business logic.

## Test-Driven Development (TDD)
This project follows the TDD methodology, which involves writing tests before implementing the actual functionality. The development process includes the following steps:
1. **Write a test**: Define a test for a new function or feature.
2. **Run the test**: Ensure that the test fails (since the functionality is not yet implemented).
3. **Write the code**: Implement the minimal amount of code required to pass the test.
4. **Run the test again**: Ensure that the test passes.
5. **Refactor**: Clean up the code while ensuring that all tests still pass.

### Key Benefits of TDD:
- Ensures that all features are thoroughly tested.
- Helps catch bugs early in the development process.
- Improves code design and maintainability.

## Project Structure

```bash

src/
│
├── main/
│   ├── java/
│   │   └── com/
│   │       └── app/
│   │           ├── DAO/
│   │           │   ├── BookDAO.java
│   │           │   └── BookDAOImp.java
│   │           ├── Service/
│   │           │   └── BookService.java
│   │           ├── model/
│   │           │   └── Book.java
│   │           └── LibraryMain.java
│
└── test/
    ├── java/
    │   └── com/
    │       └── app/
    │           └── Service/
    │               └── BookServiceTest.java
```


## Getting Started

### Prerequisites
- **Java Development Kit (JDK)**: Ensure you have JDK installed (Java 8 or higher).
- **IntelliJ IDEA**: Recommended IDE for easier development and testing.

### Installation
1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/yourusername/library-management-system.git
2. Open the project in IntelliJ IDEA.
3. Ensure your JDK is set up in the project settings.

## Running the Application

In IntelliJ IDEA:
1. Locate the `LibraryMain` class.
2. Right-click on the class and select `Run 'LibraryMain.main()'` to start the application.

## Running Tests

In IntelliJ IDEA:
1. Locate the `BookServiceTest` class in the `test` directory.
2. Right-click on the class and select `Run 'BookServiceTest'` to execute the test cases.
3. View the test results in the `Run` window.

## Test Coverage and Reports

- **Test Coverage**: Use IntelliJ IDEA’s built-in test coverage tools to check how much of your code is covered by your tests.
- **Test Reports**: Test results and coverage reports can be viewed directly in IntelliJ IDEA.

## Exception Handling

- **Invalid ISBN Input**: If the user does not provide a valid ISBN, the application will prompt for correct input.
- **Book Not Available**: If a user tries to borrow a book that is not available, an appropriate exception is thrown.
- **No Books Available**: If there are no books available in the library, the application will display an error message.

