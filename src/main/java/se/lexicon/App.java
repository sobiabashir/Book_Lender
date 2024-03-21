package se.lexicon;


import se.lexicon.model.Book;
import se.lexicon.model.Person;

public class App {
    public static void main(String[] args) {
        // todo: needs completion


        // Create a book instance
        // Display book information
        Book bookObj1=new Book("Programming","Bool");
        Book bookObj2=new Book("C++","William");
        Book bookObj3=new Book("OOP","Robert");
        System.out.println(bookObj1.getBookInformation());
        System.out.println(bookObj2.getBookInformation());
        System.out.println(bookObj3.getBookInformation());
        // Create a person instance
        // Display person informationbj

        Person personObj=new Person("sobia","bashir");
        Person personObj2=new Person("Sadia","Rasheed");

        System.out.println(personObj.getPersonalInformation());
        System.out.println(personObj2.getPersonalInformation());
        // Loan a book to the person
        personObj.loanBook(bookObj1);
        System.out.println();
        personObj2.loanBook(bookObj1);
        System.out.println();

        personObj.loanBook(bookObj2);
        personObj.loanBook(bookObj3);

        // Display person information after borrowing a book
        System.out.println(personObj.getPersonalInformation());

        // Display book information after borrowing a book
        System.out.println(bookObj1.getBookInformation());
        System.out.println(bookObj2.getBookInformation());
        System.out.println(bookObj3.getBookInformation());


        // Return the borrowed book
        personObj.returnBook(bookObj1);
        personObj.returnBook(bookObj3);

        // Display person information after returning the book
        System.out.println(personObj.getPersonalInformation());
        // Display book information after borrowing a book
        System.out.println(bookObj1.getBookInformation());
        System.out.println(bookObj2.getBookInformation());
        System.out.println(bookObj3.getBookInformation());

    }

}
