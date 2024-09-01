package main.java.com.app.Service;

import main.java.com.app.DAO.BookDAO;
import main.java.com.app.exception.BookNotAvailableException;
import main.java.com.app.model.Book;

import java.util.Date;
import java.util.List;

public class BookService {
    private final BookDAO bookDAO;


    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public void addBook(String ISBN,String title,String author,int publicationYear){

        Book book=new Book(ISBN,title,author,publicationYear);
        bookDAO.addBook(book);
    }


}