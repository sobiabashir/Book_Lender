package se.lexicon.model;
import java.util.UUID;

public class Book {
    private String id;
    private String title;
    private String author;
    private boolean available;
    private Person borrower;

    // Constructor with title, author, and borrower parameters
    public Book(String title, String author, Person borrower) {
        this(title, author);
       this.borrower = borrower;
    }
    public Book(String title, String author ) {
        this.id= assignedBookId();
        setTitle(title);
        setAuthor(author);
        setAvailable(true);
    }

    // getter setter for fields
    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getTitle() {
        return title;
    }

    public void setBorrower(Person borrower) {
          this.borrower = borrower;
    }

    public Person getBorrower() {
        return borrower;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
//////////////Other methods
    public String assignedBookId() {
    return UUID.randomUUID().toString().substring(0,8).toUpperCase();
    }
 /////////////Class methods





    public String getBookInformation() {

            String borrowerName = (borrower != null) ? borrower.getFirstName() + " " + borrower.getLastName() : "None";
            return "ID: " + getId() +
                    ", Title: " + getTitle() +
                    ", Author: " + getAuthor() +
                    ", Available: " + (isAvailable() ? "Yes" : "No") +
                    ", Borrower: " + borrowerName;
    }
}