# Library Management System 

A web-based Library Management System developed using **Java**, **Spring Boot**, and **H2 Database**, providing functionality to manage books, users, and borrowing records through a RESTful API.

> **Note:** This project has no role-based restrictions. All users can perform all operations like adding, deleting, or updating books and users.

---

## Features

- Add, update, delete, and list books
- Register and manage users
- Borrow and return books with borrowing history
- Overdue fine calculation
- In-memory H2 database for easy setup
- Exception handling and validations (ISBN uniqueness, email format)

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- REST Client (VS Code)

---

## Sample API Test Setup (in VS Code)

You can test all API endpoints directly within **VS Code** using the **REST Client** extension.

### Steps to Test APIs:

1. **Install REST Client Extension**

   - Open VS Code
   - Go to Extensions (`Ctrl + Shift + X`)
   - Search for `REST Client` and install it  
     
2. **Open the `library-api.http` File**

   - Located in the root folder of your project
   - Contains all the API test requests

3. **Send Requests**

   - Each request in the file has a `###` separator
   - Hover over any request and click `Send Request`
   - You'll see the JSON response right inside VS Code


## API Endpoints

The following RESTful APIs are available for managing books, users, and borrowing records:

| Action              | Method | Endpoint                                               |
|---------------------|--------|--------------------------------------------------------|
| Get all books       | GET    | `/api/books`                                           |
| Add a book          | POST   | `/api/books`                                           |
| Update a book       | PUT    | `/api/books/{id}`                                      |
| Delete a book       | DELETE | `/api/books/{id}`                                      |
| Register a user     | POST   | `/api/users`                                           |
| Borrow a book       | POST   | `/api/borrow?userId={userId}&bookId={bookId}`          |
| Return a book       | POST   | `/api/return/{borrowId}?userId={userId}`               |
| View borrow history | GET    | `/api/users/{userId}/borrowing`                        |

---

### 🧪 API Testing with REST Client in VS Code

You can test all APIs using the `library-api.http` file in the root of this repository.

**Steps to test:**

1. Open the `library-api.http` file in VS Code.
2. Hover over any API request.
3. Click `Send Request`.
4. View the response directly in the editor.
