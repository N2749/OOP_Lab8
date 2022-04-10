package books;

import users.Reader;

import java.util.HashMap;

public class Book implements Showable{
    private String name;
    private String author;
    private int publishingYear;
    private HashMap<Reader, Duration> history;

    //TODO addReader
    public void addReader(Reader reader) {
    }
    //TODO show
    @Override
    public void show() {

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
