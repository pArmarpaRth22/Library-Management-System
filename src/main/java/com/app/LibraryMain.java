package main.java.com.app;


import main.java.com.app.DAO.BookDAO;
import main.java.com.app.DAO.BookDAOImp;
import main.java.com.app.Service.BookService;
import main.java.com.app.exception.EmptyFieldException;
import main.java.com.app.model.Book;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LibraryMain {
    public static void main(String[] args) {
        BookDAO dao=new BookDAOImp();
        BookService serve=new BookService(dao);


        Scanner sc=new Scanner(System.in);

        while(true){
            try{


            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. View Available Books");
            System.out.println("0. Exit");


            System.out.println("Enter Your Choice");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Enter ISBN(xxx-xx-xxxxx-xx-x):");
                    String bookIsbn = sc.nextLine();
                    System.out.println("Enter Title:");
                    String title=sc.nextLine();
                    System.out.println("Enter Author:");
                    String author=sc.nextLine();
                    System.out.println("Enter Publication Year:");
                    int publicationYear = sc.nextInt();
                    serve.addBook(bookIsbn,title,author,publicationYear);
                    System.out.println("Book Added");
                    break;
                case 2:
                    System.out.println("Enter ISBN(xxx-xx-xxxxx-xx-x):");
                    bookIsbn=sc.nextLine();
                    System.out.print("Enter User ID: ");
                    String userId = sc.nextLine();
                    System.out.print("Enter Due Date (YYYY-MM-DD): ");
                    Date dueDate = Date.valueOf(sc.nextLine());
                    try {
                        serve.borrowBook(bookIsbn, userId, dueDate);
                        System.out.println("Book borrowed.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Enter ISBN: ");
                    bookIsbn = sc.nextLine();
                    try {
                        serve.returnBook(bookIsbn);
                        System.out.println("Book returned.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        List<Book> availableBooks = serve.listAvailableBooks();
                        availableBooks.forEach(book -> System.out.println(book.getTitle() + " by " + book.getAuthor() +"("+book.getISBN()+")"));
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 0:
                    sc.close();
                    System.out.println("Exiting.");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                sc.nextLine();  // Consume the invalid input to avoid an infinite loop
            }
        }
    }
}
