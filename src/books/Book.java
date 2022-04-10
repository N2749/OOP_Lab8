package books;

import users.Reader;

import java.util.HashMap;
import java.util.Map;

public class Book implements Showable {
    private String name;
    private String author;
    private int publishingYear;
    private HashMap<Reader, Duration> history;

    public Book(String name, String author, int publishingYear) {
        this.name = name;
        this.author = author;
        this.publishingYear = publishingYear;
        history = new HashMap<>();
    }

    //TODO addReader
    public void addReader(Reader reader) {
    }

    //TODO show
    @Override
    public void show() {
        System.out.printf("""
                Name: %s.
                Author: %s.
                Published year: %d.
                                
                History:
                 POSITION | READER | DURATION
                """, name, author, publishingYear);
        int i = 1;

        for (Map.Entry<Reader, Duration> readerDurationEntry : history.entrySet()) {
            System.out.printf(" %8d | %16S | %d\n", i++, readerDurationEntry.getKey(),
                    readerDurationEntry.getValue().calculateDuration());
        }
    }

    public void shortShow() {
        System.out.printf("""
                Name: %s.
                Author: %s.
                Published year: %d.
                                
                History:
                 POSITION | READER | DURATION
                """, name, author, publishingYear);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public HashMap<Reader, Duration> getHistory() {
        return history;
    }

    public void setHistory(HashMap<Reader, Duration> history) {
        this.history = history;
    }
}
