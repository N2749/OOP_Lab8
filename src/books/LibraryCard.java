package books;

import users.Reader;

import java.util.HashMap;

public class LibraryCard {
    private Reader owner;
    private HashMap<Book, Duration> history;

//    TODO +removeBook(Book): void
//    TODO +addBook(Book): void

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
