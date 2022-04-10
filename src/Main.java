import books.Book;
import users.Admin;
import users.Reader;
import users.User;

import java.util.*;

public class Main {
    private static User currentUser;
    private static Scanner scanner = new Scanner(System.in);
    private static Map<Book, Boolean> library = new HashMap<>();// book and availability true means book is present in library, not in hands of a reader
    private static List<Reader> readers = new ArrayList<>();
    private static List<Admin> admins = new ArrayList<>();
    private static String choice;

    public static void main(String[] args) {
        do {
            System.out.println("Hello, have you been here before? [y/n]");
            System.out.println("If you want to leave type \"q\"");
            choice = scanner.nextLine();
            switch (choice.toLowerCase()) {
                case "y", "n" -> readerPanel(toggleReader());
                case "q" -> {
                    return;
                }
                case "admin" -> adminPanel();
                default -> System.out.println("Invalid input");
            }
        } while (!choice.equalsIgnoreCase("q"));
    }

    private static void adminPanel() {
        do {
            System.out.println("""
                    Welcome, Master. What do you want to do?
                    1 | Add book.
                    2 | Show book.
                    3 | Edit book.
                    4 | Delete book.
                    5 | Show all books.
                    6 | Delete all books.
                    7 | Quit.
                    """);
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> addBook();
                case "2" -> showBook();
                case "3" -> editBook();
                case "4" -> deleteBook();
                case "5" -> showAllBooks();
                case "6" -> deleteAllBooks();
                case "7" -> {
                    return;
                }
                default -> System.out.println("Invalid input");
            }
        } while (true);
    }

    //    TODO: -addBook(Book): void (for admin)
    private static void addBook() {
        String name, author;
        int publishingYear;
        System.out.println("Enter the name for the new book");
        name = scanner.nextLine();
        System.out.println("Enter the author of the new book");
        author = scanner.nextLine();
        System.out.println("Enter the year of publishing of the new book");
        publishingYear = Integer.parseInt(scanner.nextLine());
        Book b = new Book(name, author, publishingYear);
        library.put(b, true);
    }

    //    TODO: -showBook(): void (for admin)
    private static void showBook() {

    }

    //    TODO: -editBook()
    private static void editBook() {

    }

    //    TODO: -deleteBook(): void (for admin)
    private static void deleteBook() {

    }

    //    TODO: -showAllBooks
    private static void showAllBooks() {

    }

    //    TODO: -deleteAllBooks
    private static void deleteAllBooks() {

    }

    private static Reader toggleReader() {
        String login, password;
        System.out.println("Enter your login");
        login = scanner.nextLine();
        System.out.println("Enter your password?");
        password = scanner.nextLine();
        for (Reader r : readers) {
            if (r.check(login, password)) {
                currentUser = r;
                System.out.printf("Welcome to our Library, %s %s.\n", login, password);
                return r;
            }
        }
        System.out.println("How we can call you?");
        String name, number;
        name = scanner.nextLine();
        System.out.println("How we can contact you? (phone number)");
        number = scanner.nextLine();
        readers.add(new Reader(login, password, name, number));
        return readers.get(readers.size() - 1);
    }

    //    TODO: -readerPanel(): void
    private static void readerPanel() {
        readerPanel(toggleReader());
    }

    private static void readerPanel(Reader reader) {
        do {
            System.out.println("""
                    Welcome,""" + reader.getName() + """
                    , What do you want to do?
                    1 | Take book.
                    2 | Read book.
                    3 | Show books on my hands.
                    4 | Return book.
                    5 | Show all books.
                    6 | Quit.
                    """);
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> takeBook();
                case "2" -> readBook();
                case "3" -> showBooksOnHand();
                case "4" -> returnBook();
                case "5" -> showAllBooks();
                case "6" -> {
                    return;
                }
                default -> System.out.println("Invalid input");
            }
        } while (true);
    }

    //    TODO: -takeBook(Book): void (for reader)
    private static void takeBook() {

    }

//    TODO: readBook
    private static void readBook() {

    }

//    TODO: showBooksOnHand
    private static void showBooksOnHand() {
        System.out.println("Books that you have are:");
        int i = 1;
        for (Book b : currentUser.get)
    }

//    TODO: returnBook()
    private static void returnBook() {

    }
}
