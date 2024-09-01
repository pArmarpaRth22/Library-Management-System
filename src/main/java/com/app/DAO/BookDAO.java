package main.java.com.app.DAO;

import main.java.com.app.model.Book;

import java.util.List;

public interface BookDAO {
    void addBook(Book book);
    Book getBookByISBN(String ISBN);
    List<Book> getAllBooks();
    void updateBook(Book book);
    void deleteBook(String ISBN);
}
