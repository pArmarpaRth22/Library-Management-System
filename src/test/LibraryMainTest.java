package test;

import main.java.com.app.DAO.BookDAO;
import main.java.com.app.DAO.BookDAOImp;
import main.java.com.app.Service.BookService;
import main.java.com.app.exception.BookNotAvailableException;
import main.java.com.app.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryMainTest {
    private BookService bookService;
    private BookDAO dao;

    @BeforeEach
    void setup(){
        dao=new BookDAOImp();
        bookService=new BookService(dao);
    }

    @Test
    void testAddBook(){
        String ISBN="123-45-67890-12-3";
        String bookName="Test Book";
        String author="Author Name";
        int pubYear=2023;

        bookService.addBook(ISBN,bookName,author,pubYear);

        Book book=dao.getBookByISBN(ISBN);
        assertNotNull(book);
        assertEquals(ISBN,book.getISBN());
        assertEquals(bookName,book.getTitle());
        assertEquals(author,book.getAuthor());
        assertEquals(pubYear,book.getPublicationYear());

    }
}