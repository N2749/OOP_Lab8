package books;

import users.Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Book implements Showable {
    private String name;
    private String author;
    private int publishingYear;
    private HashMap<Reader, Duration> history;
    private String summary;
    private File bookAsFile;
    private List<String> bookAsArray = new ArrayList<>();
    private int currentPage = 1;

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

    public Book(String name, String author, int publishingYear, String summary, File bookAsFile) {
        this.name = name;
        this.author = author;
        this.publishingYear = publishingYear;
        this.history = new HashMap<>();
        this.summary = summary;
        this.bookAsFile = bookAsFile;
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
                 POSITION |      READER      | DURATION (in minutes)
                """, name, author, publishingYear, summary);
        int i = 1;

        for (Map.Entry<Reader, Duration> readerDurationEntry : history.entrySet()) {
            System.out.printf(" %8d | %16s | %f\n", i++, readerDurationEntry.getKey().getName(),
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

    public void read() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(bookAsFile));
        Scanner sScanner = new Scanner(System.in);
        String choice, temp, page = "";
        do {
            if(currentPage < 1) {
                currentPage = 1;
            }
            for (int i = 0; i < 5; i++) {
                page += scanner.nextLine() + "\n";
                temp = scanner.nextLine();
                if(temp.equals("")){
                    scanner.nextLine();
                    page += "\t";
                } else {
                    page += temp;
                }
            }
            bookAsArray.add(page);
            page = "";
            System.out.println(bookAsArray.get(currentPage - 1));
            System.out.println("Page: " + currentPage);
            System.out.println("""
                ========================
                p | go to previous page.
                n | go to next page.
                q | quit.""");
            choice = sScanner.nextLine();
            if (choice.equals("p")) {
                if (bookAsArray.get(--currentPage)=="") {
                    System.out.println(bookAsArray.get(--currentPage));
                }
            } else {
                currentPage++;
            }
        } while (!choice.equals("q"));
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
