package books;

import users.Reader;

import java.util.HashMap;

public class LibraryCard {
    private Reader owner;
    private HashMap<Book, Duration> history;

//    TODO +removeBook(Book): void


    public LibraryCard(Reader owner) {
        this.owner = owner;
        this.history = new HashMap<>();
    }

    public LibraryCard(Reader owner, HashMap<Book, Duration> history) {
        this.owner = owner;
        this.history = history;
    }

    //    TODO +addBook(Book): void
    public void addBook(Book book) {
        history.put(book, new Duration());
    }

    public Reader getOwner() {
        return owner;
    }

    public void setOwner(Reader owner) {
        this.owner = owner;
    }

    public HashMap<Book, Duration> getHistory() {
        return history;
    }

    public void setHistory(HashMap<Book, Duration> history) {
        this.history = history;
    }
}
