package library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        // Check if book with same title already exists
        Book existingBook = searchBookByTitle(book.getTitle());
        if (existingBook != null) {
            // Increment counter for existing book
            existingBook.incrementCount();
        } else {
            // Add new book
            books.add(book);
        }
    }

    public boolean removeBook(String isbn) {
        return books.removeIf(b -> b.getIsbn().equals(isbn));
    }

    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> listBooks() {
        return books;
    }
}
