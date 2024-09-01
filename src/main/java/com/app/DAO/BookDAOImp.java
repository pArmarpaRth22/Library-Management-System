package main.java.com.app.DAO;

import main.java.com.app.model.Book ;

import java.util.ArrayList;
import java.util.List;

public class BookDAOImp  implements BookDAO{

    private List<Book> books=new ArrayList<>();
    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Book getBookByISBN(String ISBN) {
        return books.stream()
                .filter(book->book.getISBN().equals(ISBN))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public void updateBook(Book book) {
        Book existingBook=getBookByISBN(book.getISBN());
        if(existingBook!=null){
            existingBook.setAuthor(book.getAuthor());
            existingBook.setTitle(book.getTitle());
            existingBook.setPublicationYear(book.getPublicationYear());
            existingBook.setAvailable(book.isAvailable());

        }

    }

    @Override
    public void deleteBook(String ISBN) {
        books.removeIf(book->book.getISBN().equals(ISBN));
    }
}
