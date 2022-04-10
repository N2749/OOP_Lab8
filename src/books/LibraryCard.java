package books;

import users.Reader;

import java.util.HashMap;

public class LibraryCard {
    private Reader owner;
    private HashMap<Book, Duration> history;

    public LibraryCard(Reader owner) {
        this.owner = owner;
        this.history = new HashMap<>();
    }

    public LibraryCard(Reader owner, HashMap<Book, Duration> history) {
        this.owner = owner;
        this.history = history;
    }

    public void addBook(Book book) {
        history.put(book, new Duration());
    }

//    TODO +removeBook(Book): void
    public void removeBook(Book book) {
        Duration end = history.get(book);
        end.end();
        history.put(book, end);
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
