# LibraryAssignment

SOLID Principles
1. S — Single Responsibility Principle (SRP)

Each class has one clear responsibility:

Book → holds book details.

EBook → extends Book with file size.

Library → manages collection of books (add, remove, search, list).

LibraryManager → handles user interaction/menu system.

BookFactory → responsible only for creating Book or EBook.
This separation makes the code easier to maintain and modify.

2. O — Open/Closed Principle (OCP)

The system is open for extension but closed for modification.

Example: We didn’t modify Book to add file size, instead we extended it via EBook.

If tomorrow we want AudioBook, we can add a new subclass without touching existing Book logic.

3. L — Liskov Substitution Principle (LSP)

EBook can be used wherever Book is expected.

For example, Library.addBook(Book book) accepts both Book and EBook objects without any issue.
This means EBook fully respects the contract of Book.

4. I — Interface Segregation Principle (ISP) (Not strongly applied but conceptually covered)

Instead of one giant interface, we have small, focused classes.

Example: Library only exposes methods related to books (addBook, removeBook, etc.) rather than forcing unrelated functionality.

5. D — Dependency Inversion Principle (DIP)

LibraryManager doesn’t depend on concrete Book or EBook classes directly — it depends on the abstraction (Book).

The creation of objects is handled by BookFactory.
This decouples LibraryManager from specific implementations.

✅ Design Patterns
1. Singleton Pattern (LibraryManager)

Ensures only one instance of LibraryManager exists.

Achieved by:

private static LibraryManager instance;
private LibraryManager() { ... }
public static LibraryManager getInstance() { ... }


This prevents multiple conflicting managers controlling the library.

2. Factory Pattern (BookFactory)

Centralized object creation.

Instead of writing new Book() or new EBook() everywhere, we use:

Book b = BookFactory.createBook("ebook", title, author, isbn, true, fileSize);


Benefits:

Encapsulates creation logic.

Makes it easier to add new book types (e.g., AudioBook) later.

Promotes loose coupling between LibraryManager and Book subclasses.
