# Borrow Book System

Tutorial 5(a), Section B, Q7 (TK1143 GUI & Event Handling)

## Files

| File | Part | Purpose |
|------|------|---------|
| `MainMenu.java` | (a) | Main menu GUI. **Start here.** |
| `AddStudentInfo.java` | (b) | Add Student Info GUI (Add / List) |
| `AddBookInfo.java` | (c) | Add Book Info GUI (Add / List) |
| `BorrowBook.java` | (d) | Borrow Book GUI (combo boxes + Borrow button) |
| `Student.java` | (e) | Student class (`toString`, `getListInfo`) |
| `Book.java` | (e) | Book class (`borrowBy`, `toString`, `getListInfo`) |
| `LibraryData.java` | - | Shared lists of students and books (2 sample students, 2 sample books) |
| [`screenshots/`](screenshots/) | - | Screenshots of each GUI |

## Screenshots

### Main menu
![Main menu](screenshots/1_main_menu.png)

### Add student information
![Add student information](screenshots/2_add_student_info.png)

### Student list
![Student list](screenshots/3_list_students.png)

### Add book information
![Add book information](screenshots/4_add_book_info.png)

### Book list
![Book list](screenshots/5_list_books.png)

### Borrow book
![Borrow book](screenshots/6_borrow_book.png)

### After borrowing
![After borrowing a book](screenshots/7_after_borrow.png)

## How to run (JDK 8 or newer)

```
javac *.java
java MainMenu
```

## Rules used

- One student can borrow only **one** book.
- There is only **one** copy of each book title.
