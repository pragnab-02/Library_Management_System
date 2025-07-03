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

### API Testing with REST Client in VS Code

You can test all APIs using the `library-api.http` file in the root of this repository.

**Steps to test:**

1. Open the `library-api.http` file in VS Code.
2. Hover over any API request.
3. Click `Send Request`.
4. View the response directly in the editor.

---

## Output for All API Endpoints
   Below are screenshots of responses for all tested API endpoints using the REST Client extension in Visual Studio Code.
   
### 1. Adding a New Book

![SS_1](https://github.com/user-attachments/assets/aac1e81f-88b6-4d0c-88fc-15ef061afa7c)

### 2. Register a New User 

![SS_2](https://github.com/user-attachments/assets/f5026578-e9ba-4c0d-ba9a-1543224ed142)

### 3. Borrow a Book

![SS_3](https://github.com/user-attachments/assets/be23ff21-c441-43b4-9096-82c17ddf1efc)

### 4.Get All Books

![Screenshot 2025-07-03 165945](https://github.com/user-attachments/assets/e604f1a2-b44f-4307-bfc2-f3ad24b8ade7)

### 5.Return a Book

![SS_4](https://github.com/user-attachments/assets/9d44b768-be8e-4d9a-b432-17c7fe033aa0)

### 6.View Borrowing History

![Screenshot 2025-07-03 170941](https://github.com/user-attachments/assets/952e5fd7-b09b-482a-9c8f-3a92ea1f25d3)

### 7.Update a Book 

![Screenshot 2025-07-03 174930](https://github.com/user-attachments/assets/2d5bd63b-d00e-4863-bb34-2d6387c5bc6c)

### 8.Delete a Book

![Screenshot 2025-07-03 172038](https://github.com/user-attachments/assets/48f88f87-39dc-44fa-b06c-a07fb03c2e88)





