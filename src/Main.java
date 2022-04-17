import books.Book;
import users.Admin;
import users.Reader;
import users.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static User currentUser;
    private static final Scanner scanner = new Scanner(System.in);
    private static Map<Book, Boolean> library = new HashMap<>();// book and availability true means book is present in library, not in hands of a reader
    private static final List<Reader> readers = new ArrayList<>();
    private static final List<Admin> admins = new ArrayList<>();
    private static String choice;

    public static void main(String[] args) {
        addBooks();
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

    private static void addBooks() {
        library.put(
                new Book(
                        "Sapiens. A Brief History of Humankind",
                        "Yuval Noah Harari",
                        2011,
                        "A book by Professor Yuval Noah Harari, first published in Hebrew in Israel in 2011 and in English in 2014. Harari cites Jared Diamond's Guns, Germs and Steel as one of his main inspirations, showing that you can \"ask very big questions and answer them scientifically.\"",
                        new File("library/Sapiens__A_Brief_History_of_Humankind.txt")
                ),
                true);
        library.put(
                new Book(
                        "A Cross of Centuries",
                        "Henry Kuttner",
                        1960,
                        "They called him Christ. But he was not the Man who had toiled up the long road to Golgotha five thousand years before. They called him Buddha and Mohammed; they called him the Lamb, and the Blessed of God. The called him the Prince of Peace and the Immortal One.\n" +
                                "" +
                                "His name was Tyrell.\n",
                        new File("library/A_Cross_of_Centuries.txt")
                ),
                true);
        library.put(
                new Book(
                        "Harry Potter and the Prisoner of Azkaban",
                        "Joanne Kathleen",
                        1999,
                        "Harry Potter and the Prisoner of Azkaban is a fantasy novel written by British author J. K. Rowling and is the third in the Harry Potter series. The book follows Harry Potter, a young wizard, in his third year at Hogwarts School of Witchcraft and Wizardry. Along with friends Ronald Weasley and Hermione Granger, Harry investigates Sirius Black, an escaped prisoner from Azkaban, the wizard prison, believed to be one of Lord Voldemort's old allies.\n",
                        new File("library/Harry_Potter_and_the_Prisoner_of_Azkaban.txt")
                ),
                true);
        library.put(
                new Book(
                        "Natalie Page",
                        "Katharine Haviland-Taylor",
                        1921,
                        "I think it is strange how the scenes surrounding big events stay in your\n" +
                                "memory. And sometimes with years they become more clear than the\n" +
                                "happening which impressed them. I know this, because I remember a big\n" +
                                "four-posted bed, and a lot of people around it--crying.\n",
                        new File("library/Natalie-Page-Katharine-Havil.txt")
                        ), true);
        library.put(
                new Book(
                        "Nightshade and Damnations",
                        "Gerald Kersh",
                        2013,
                        "Nightmares, phantasmagoria, horrors that lurk in the streets of today, the corrupting weaknesses of men; these are the bones and gristle of what this book contains.\n",
                        new File("library/Nightshade_and_Damnations.txt")
                ), true
        );
        library.put(
                new Book(
                        "The Hustler",
                        "Tevis Wolter",
                        2011,
                        "The Hustler is about the victories and losses of one \"Fast\" Eddie Felson, a poolroom hustler who travels from town to town conning strangers into thinking they could beat him at the game when in fact, he is a skillful player who has never lost a game. Until he meets his match in Minnesota Fats, the true king of the poolroom, causing his life to change drastically.\n" +
                                "\n" +
                                "This is a classic tale of a man's struggle with his soul and his self-esteem.\n",
                        new File("library/The_Hustler.txt")
                ), true
        );
        library.put(
                new Book(
                        "The Man Who Fell to Earth",
                        "Tevis Wolter",
                        2014,
                        "T. J. Newton is an extraterrestrial who goes to Earth on a desperate mission of mercy. But instead of aid, Newton discovers loneliness and despair that ultimately ends in tragedy.\n",
                        new File("library/The_Man_Who_Fell_to_Earth.txt")
                ), true
        );
        library.put(
                new Book(
                        "The Queen's Gambit",
                        "Tevis Wolter",
                        2014,
                        "Beth Harmon becomes an orphan when her parents are killed in an automobile accident. At eight years old, she is placed in an orphanage in Mount Sterling, Kentucky, where the children are given a tranquilliser twice a day. Plain and shy, she learns to play chess from the janitor in the basement and discovers that she is a chess genius. She is adopted by Alma and Allston Wheatley and goes to a local school, but remains an outsider. Desperate to study chess and having no money, she steals a chess magazine from a newspaper store and then some money from Alma Wheatley and a girl at school, so that she can enter a tournament. She also steals some of the tranquillisers to which she is becoming addicted. At thirteen she wins the tournament, and by sixteen she is competing in the US Open Championship. Like Fast Eddie (in The Hustler), she hates to lose.\n",
                        new File("library/The_Queen_s_Gambit.txt")
                ), true
        );
        library.put(
                new Book(
                        "The Steps of the Sun",
                        "Tevis Wolter",
                        1990,
                        "It is the year 2063. China's world dominance is growing, and America is slipping into impotence. All new sources of energy have been depleted or declared unsafe, and a new Ice Age has begun. Ben Belson searches for a new energy resource.\n" +
                                "\n",
                        new File("library/The_Steps_of_the_Sun.txt")
                        ), true
        );
        library.put(
                new Book(
                        "Orphans of the Helix",
                        "Dan Simmons",
                        1980,
                        "The great spinship translated down from Hawking space into the red-and-white double light of a close binary. While the 684,300 people of the Amoiete Spectrum Helix dreamt on in deep cryogenic sleep, the five AIs in charge of the ship conferred. They had encountered an unusual phenomenon and while four of the five had agreed it important enough to bring the huge spinship out of C-plus Hawking space, there was a lively debate—continuing for several microseconds—about what to do next.\n",
                        new File("library/Orphans_of_the_Helix.txt")
                ), true
        );
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
                    7 | Quit.""");
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

            }
        } while (true);
    }

    private static void addBook() {
        String name, author, summary;
        int publishingYear;
        System.out.println("Enter the name for the new book");
        name = scanner.nextLine();
        System.out.println("Enter the author of the new book");
        author = scanner.nextLine();
        System.out.println("Enter the summary of the new book");
        summary = scanner.nextLine();
        System.out.println("Enter the year of publishing of the new book");
        publishingYear = Integer.parseInt(scanner.nextLine());
        Book b = new Book(name, author, publishingYear, summary);
        library.put(b, true);
    }

    private static void showBook() {
        int i = 1;
        ArrayList<Book> books = new ArrayList<>();
        for (Map.Entry<Book, Boolean> shows : library.entrySet()) {
            System.out.println();
            System.out.print((i++) + " | ");
            shows.getKey().shortShow();
            books.add(shows.getKey());
        }
        System.out.println("Choose book to show the full information of. Type Position of desired book");
        int position = Integer.parseInt(scanner.nextLine());
        if (position > books.size() || position - 1 < 0) {
            System.out.println("Invalid index");
            return;
        }
        books.get(position - 1).show();
    }

    private static void editBook() {
        int i = 1;
        ArrayList<Book> books = new ArrayList<>();
        for (Map.Entry<Book, Boolean> shows : library.entrySet()) {
            System.out.println();
            System.out.print((i++) + " | ");
            shows.getKey().shortShow();
            books.add(shows.getKey());
        }
        System.out.println("Choose book to edit. Type Position of desired book");
        int position = Integer.parseInt(scanner.nextLine());
        if (position > books.size() || position - 1 < 0) {
            System.out.println("Invalid index");
            return;
        }
        System.out.println("Are you sure? [y/n]");
        if (scanner.nextLine().equals("y")) {
            library.remove(books.get(position - 1));
            System.out.println("Enter the name: ");
            String name = scanner.nextLine();
            System.out.println("Enter the author: ");
            String author = scanner.nextLine();
            System.out.println("Enter the publishing year: ");
            int year = Integer.parseInt(scanner.nextLine());
            library.put(new Book(name, author, year), true);
            return;
        }
        System.out.println("Editing was not done.");
    }

    private static void deleteBook() {
        int i = 1;
        ArrayList<Book> books = new ArrayList<>();
        for (Map.Entry<Book, Boolean> shows : library.entrySet()) {
            books.add(shows.getKey());
        }
        for (Book b : books) {
            System.out.println();
            System.out.print((i++) + " | ");
            b.shortShow();
        }
        System.out.println("Choose book to delete. Type Position of desired book");
        int position = Integer.parseInt(scanner.nextLine());
        if (position > books.size() || position - 1 < 0) {
            System.out.println("Invalid index");
            return;
        }
        System.out.println("Are you sure? [y/n]");
        if (scanner.nextLine().equals("y")) {
            library.remove(books.get(position - 1));
            System.out.println("Deletion successful");
            return;
        }
        System.out.println("Deletion was not done.");
    }

    private static void showAllBooks() {
        int i = 1;
        System.out.println("______Available books______");
        for (Map.Entry<Book, Boolean> shows : library.entrySet()) {
            if (shows.getValue()) {
                System.out.println();
                System.out.print((i++) + " | ");
                shows.getKey().shortShow();
            }
        }
        System.out.println("______Not Available books______");
        for (Map.Entry<Book, Boolean> shows : library.entrySet()) {
            if (!shows.getValue()) {
                System.out.println();
                System.out.print((i++) + " | ");
                shows.getKey().shortShow();
            }
        }
    }

    private static void deleteAllBooks() {
        System.out.println("Are you sure? [y/n]");
        if (scanner.nextLine().equals("y")) {
            library = new HashMap<>();
            System.out.println("Deletion successful");
            return;
        }
        System.out.println("Deletion was not done.");
    }

    private static Reader toggleReader() {
        String login, password, name, number;
        System.out.println("Enter your login");
        login = scanner.nextLine();
        System.out.println("Enter your password?");
        password = scanner.nextLine();
        for (Reader r : readers) {
            if (r.check(login, password)) {
                currentUser = r;
                System.out.printf("Welcome to our Library, %s.\n", ((Reader) currentUser).getName());
                return r;
            }
        }
        System.out.println("How we can call you?");
        name = scanner.nextLine();
        System.out.println("How we can contact you? (phone number)");
        number = scanner.nextLine();
        readers.add(new Reader(login, password, name, number));
        return readers.get(readers.size() - 1);
    }

    private static void readerPanel(Reader reader) {
        currentUser = reader;
        do {
            System.out.println("""
                    Welcome,\040""" + reader.getName() + """
                    , What do you want to do?
                    1 | Take book.
                    2 | Read book.
                    3 | Show books on my hands.
                    4 | Return book.
                    5 | Show all books.
                    6 | Quit.""");
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

    private static void takeBook() {
        int i = 1;
        ArrayList<Book> availableBooks = new ArrayList<>();
        System.out.println("______Available books______");
        for (Map.Entry<Book, Boolean> shows : library.entrySet()) {
            if (shows.getValue()) {
                availableBooks.add(shows.getKey());
            }
        }

        for (Book b : availableBooks) {
            System.out.println();
            System.out.print((i++) + " | ");
            b.shortShow();
        }
        System.out.println("Choose book to take. Type Position of desired book");
        int position = Integer.parseInt(scanner.nextLine());
        if (position > availableBooks.size() || position - 1 < 0) {
            System.out.println("Invalid index");
            return;
        }

        ((Reader) currentUser).rentBook(availableBooks.get(position - 1));
        library.put(availableBooks.get(position - 1), false);
    }

    private static void readBook() {
        showBooksOnHand();
        ArrayList<Book> books = ((Reader) currentUser).getBooksOnHand();
        System.out.println("Choose book to read. Type Position of desired book");
        int position = Integer.parseInt(scanner.nextLine());
        if (position > books.size() || position - 1 < 0) {
            System.out.println("Invalid index");
            return;
        }
        try {
            books.get(position - 1).read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void showBooksOnHand() {
        System.out.println("Books that you have are:");
        int i = 1;
        for (Book b : ((Reader) currentUser).getBooksOnHand()) {
            System.out.println(i++ + ".");
            b.shortShow();
        }
    }

    private static void returnBook() {
        showBooksOnHand();
        ArrayList<Book> books = ((Reader) currentUser).getBooksOnHand();
        System.out.println("Choose book to return. Type Position of desired book");
        int position = Integer.parseInt(scanner.nextLine());
        if (position > books.size() || position - 1 < 0) {
            System.out.println("Invalid index");
            return;
        }
        library.put(books.get(position - 1), true);
        ((Reader) currentUser).returnBook(books.get(position - 1));
    }
}
