package se.lexicon.model;
import java.util.Arrays;
public class Person {
        private static int sequencer = 0;
        private final int id;
        private String firstName;
        private String lastName;

        private Book[] bookBorrowd;

        public Person(String firstName, String lastName) {
            this.id = getNextId();
            setFirstName(firstName);
            setLastName(lastName);
            this.bookBorrowd=new Book[0];
        }

    public Book[] getBookBorrowd() {
        return bookBorrowd;
    }

    public int getId() {
            return id;
        }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("FirstName cannot be null");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) throw new IllegalArgumentException("LastName cannot be null");
        this.lastName = lastName;
    }

    private static int getNextId() {
        return ++sequencer;
    }


    public void loanBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book cannot be null");

        if (book.isAvailable()) {
            Book[] latestBookBorrowdArray =Arrays.copyOf(bookBorrowd,bookBorrowd.length +1);
            latestBookBorrowdArray[latestBookBorrowdArray.length-1]=book;
            book.setAvailable(false); // Book is now not available
            book.setBorrower(this);
            System.out.println("Book successfully loaned to " + this.getFirstName() + " " + this.getLastName());
            bookBorrowd=latestBookBorrowdArray;
        } else {
            System.out.println("Book is already borrowed");
        }
    }

    public void returnBook(Book book) {
       if(book==null) throw new IllegalArgumentException("Book cannot be empty");

        Book[] latestBookBorrowdArray =Arrays.copyOf(bookBorrowd,bookBorrowd.length +1);
        for (int i = 0; i < bookBorrowd.length; i++) {
            if (bookBorrowd[i].getId() == book.getId()) {
                book.setAvailable(true); // Mark the book as available
                book.setBorrower(null); // Remove borrower from the book
                removeBookFromBorrowedBooks(i); // Remove the book from the borrower's list of borrowed books
                System.out.println("Book successfully returned");
                return;
            }
        }
        bookBorrowd=latestBookBorrowdArray;
        System.out.println("Book not found in borrower's list of borrowed books");
    }

    private void removeBookFromBorrowedBooks(int index) {
        System.arraycopy(bookBorrowd, index + 1, bookBorrowd, index, bookBorrowd.length - 1 - index);
        bookBorrowd = Arrays.copyOf(bookBorrowd, bookBorrowd.length - 1);
    }


   public String getPersonalInformation() {
        return "ID: " + id + ", Name: " + firstName + " " + lastName + " Number of books issued: "+ bookBorrowd.length + "\n";
    }



}