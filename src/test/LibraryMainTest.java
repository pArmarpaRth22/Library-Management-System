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



    @Test
    void testBorrowBookWhenBookIsAvailable() throws Exception{
        bookService.addBook("123-45-67890-12-3", "Test Book", "Test Author", 2023);

        bookService.borrowBook("123-45-67890-12-3", "user-001", Date.valueOf("2024-09-01"));

        Book book=dao.getBookByISBN("123-45-67890-12-3");
        assertNotNull(book);
        assertFalse(book.isAvailable());
    }

    @Test
    void testBorrowBookWhenBookIsNotAvailable() throws Exception {
        bookService.addBook("123-45-67890-12-3", "Test Book", "Test Author", 2023);

        bookService.borrowBook("123-45-67890-12-3", "user-001", Date.valueOf("2024-09-01"));

        assertThrows(BookNotAvailableException.class,()->{
            bookService.borrowBook("123-45-67890-12-3", "user-002", Date.valueOf("2024-09-02"));
        });
    }

    @Test
    void testBorrowBookWhenBookNotFound() {
        assertThrows(BookNotAvailableException.class,()->{
            bookService.borrowBook("123-45-69890-12-3", "user-001", Date.valueOf("2024-09-02"));
        });
    }

    @Test
    void testReturnBookWhenBookIsBorrowed() throws Exception{
        bookService.addBook("123-45-67890-12-3", "Test Book", "Test Author", 2023);


        bookService.borrowBook("123-45-67890-12-3", "user-001", Date.valueOf("2024-09-01"));


        bookService.returnBook("123-45-67890-12-3");

        Book book=dao.getBookByISBN("123-45-67890-12-3");
        assertNotNull(book);
        assertTrue(book.isAvailable());
    }

    @Test
    void testReturnBookWhenBookIsNotBorrowed() throws Exception{
        bookService.addBook("123-45-67890-12-3", "Test Book", "Test Author", 2023);

        bookService.returnBook("123-45-67890-12-3");

        Book book=dao.getBookByISBN("123-45-67890-12-3");
        assertNotNull(book);
        assertTrue(book.isAvailable());

    }

    @Test
    void testReturnBookWhenBookIsNotThere(){
        assertThrows(BookNotAvailableException.class, () -> {
            bookService.returnBook("111-11-11111-11-1");
        });
    }



    @Test
    void testListAvailableBooksSuccessfully() throws Exception{

        bookService.addBook("978-01-34685-99-1", "Test-book-1", "Test-Author-1", 2018);
        bookService.addBook("978-01-32350-88-4", "Test-book-2", "Test-Author-2", 2008);

        List<Book>  books=bookService.listAvailableBooks();

        assertEquals(2,books.size());
    }

    @Test
    void testListAvailableBooksNoBooksAvailable() throws Exception{
        List<Book> books=dao.getAllBooks().stream().filter(Book::isAvailable).toList();;

        Exception exception = assertThrows(Exception.class, () -> {
            bookService.listAvailableBooks();
        });

        assertEquals("No Book is available", exception.getMessage());


    }


}