package users;

import books.Book;
import books.LibraryCard;

import java.util.ArrayList;

public class Reader extends User{

    private String number;
    private String name;
    private LibraryCard card = new LibraryCard(this);
    private ArrayList<Book> booksOnHand;

    public Reader(String login, String password) {
        super(login, password);
    }

    public Reader(String login, String password, String name, String number) {
        super(login, password);
        this.number = number;
        this.name = name;
        booksOnHand = new ArrayList<>();
    }

    public void rentBook(Book book) {
        book.addReader(this);
        card.addBook(book);
        booksOnHand.add(book);
    }

     public void returnBook(Book book) {
        book.endPeriod(this);
        card.removeBook(book);
        booksOnHand.remove(book);
    }

    public boolean check(String login, String password) {
        return this.login.equals(login) && this.password.equals(this.password);

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LibraryCard getCard() {
        return card;
    }

    public void setCard(LibraryCard card) {
        this.card = card;
    }

    public ArrayList<Book> getBooksOnHand() {
        return booksOnHand;
    }

    public void setBooksOnHand(ArrayList<Book> booksOnHand) {
        this.booksOnHand = booksOnHand;
    }
}
