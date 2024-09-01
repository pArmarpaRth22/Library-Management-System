package main.java.com.app.model;
import java.util.UUID;

public class Book {
    private String bookId;// Generate a unique UUID for each book
    private String ISBN;
    private String title;
    private String author;
    private int publicationYear;
    private boolean isAvailable; // By default, the book is available when added

    public Book(String ISBN, String title, String author, int publicationYear) {
        this.bookId =UUID.randomUUID().toString();
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = true;
    }

    public String getBookId() {
        return bookId;
    }

    // No setter for UUID since it's meant to be immutable once generated

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    // Overriding toString method for easy display
    @Override
    public String toString() {
        return "UUID: " + bookId + ", ISBN: " + ISBN + ", Title: " + title + ", Author: " + author + ", Year: " + publicationYear + ", Available: " + (isAvailable ? "Yes" : "No");
    }
}
