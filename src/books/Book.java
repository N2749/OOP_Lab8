package books;

import users.Reader;

import java.util.HashMap;
import java.util.Map;

public class Book implements Showable {
    private String name;
    private String author;
    private int publishingYear;
    private HashMap<Reader, Duration> history;
    private String summary;

    public Book(String name, String author, int publishingYear) {
        this.name = name;
        this.author = author;
        this.publishingYear = publishingYear;
        history = new HashMap<>();
    }

    public Book(String name, String author, int publishingYear, String summary) {
        this.name = name;
        this.author = author;
        this.publishingYear = publishingYear;
        this.history = new HashMap<>();
        this.summary = summary;
    }

    public void addReader(Reader reader) {
        addReader(reader, new Duration());
    }

    public void addReader(Reader reader, Duration duration) {
        history.put(reader, duration);
    }

    public void endPeriod(Reader reader) {
        Duration duration = history.get(reader);
        duration.end();
        history.put(reader, duration);
    }

    @Override
    public void show() {
        System.out.printf("""
                Name: %s.
                Author: %s.
                Published year: %d.
                Summary: %s
                History:
                 POSITION | READER | DURATION
                """, name, author, publishingYear, summary);
        int i = 1;

        for (Map.Entry<Reader, Duration> readerDurationEntry : history.entrySet()) {
            System.out.printf(" %8d | %16S | %f\n", i++, readerDurationEntry.getKey(),
                    readerDurationEntry.getValue().calculateDuration());
        }
    }

    public void shortShow() {
        System.out.printf("""
                Name: %s.
                Author: %s.
                Published year: %d.
                """, name, author, publishingYear);
    }

    public void read() {
        System.out.printf("""
                Name: %s.
                Author: %s.
                Published year: %d.
                Summary: %s
                """, name, author, publishingYear, summary);
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
