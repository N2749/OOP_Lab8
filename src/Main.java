import books.Book;
import users.Admin;
import users.Reader;
import users.User;

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
                        "A book by Professor Yuval Noah Harari, first published in Hebrew in Israel in 2011 and in English in 2014. Harari cites Jared Diamond's Guns, Germs and Steel as one of his main inspirations, showing that you can \"ask very big questions and answer them scientifically.\""
                ),
                true);
        library.put(
                new Book(
                        "The God Delusion",
                        "Richard Dawkins",
                        2006,
                        "In The God Delusion, Dawkins contends that a supernatural creator, God, almost certainly does not exist, and that belief in a personal god qualifies as a delusion, which he defines as a persistent false belief held in the face of strong contradictory evidence. He is sympathetic to Robert Pirsig's statement in Lila (1991) that \"when one person suffers from a delusion it is called insanity. When many people suffer from a delusion it is called religion.\"[3] With many examples, he explains that one does not need religion to be moral and that the roots of religion and of morality can be explained in non-religious terms.\n"

                ),
                true);
        library.put(
                new Book(
                        "The Selfish Gene",
                        "Richard Dawkins",
                        1976,
                        "The Selfish Gene is a 1976 book on evolution by the ethologist Richard Dawkins, in which the author builds upon the principal theory of George C. Williams's Adaptation and Natural Selection (1966). Dawkins uses the term \"selfish gene\" as a way of expressing the gene-centred view of evolution (as opposed to the views focused on the organism and the group), popularising ideas developed during the 1960s by W. D. Hamilton and others. From the gene-centred view, it follows that the more two individuals are genetically related, the more sense (at the level of the genes) it makes for them to behave cooperatively with each other." +
                                "\n"
                ),
                true);
        library.put(
                new Book(
                        "To Kill a Mockingbird",
                        "Harper Lee",
                        1960,
                        "To Kill a Mockingbird takes place in the fictional town of Maycomb, Alabama, during the Great Depression. The protagonist is Jean Louise (“Scout”) Finch, an intelligent though unconventional girl who ages from six to nine years old during the course of the novel. She is raised with her brother, Jeremy Atticus (“Jem”), by their widowed father, Atticus Finch. He is a prominent lawyer who encourages his children to be empathetic and just. He notably tells them that it is “a sin to kill a mockingbird,” alluding to the fact that the birds are innocent and harmless.\n"
                ), true);
        library.put(
                new Book(
                        "The Great Gatsby",
                        "F. Scott Fitzgerald",
                        1925,
                        "The book is narrated by Nick Carraway, a Yale University graduate from the Midwest who moves to New York after World War I to pursue a career in bonds. He recounts the events of the summer he spent in the East two years later, reconstructing his story through a series of flashbacks not always told in chronological order. In the spring of 1922, Nick takes a house in the fictional village of West Egg on Long Island, where he finds himself living among the colossal mansions of the newly rich. Across the water in the more refined village of East Egg live his cousin Daisy and her brutish, absurdly wealthy husband Tom Buchanan.\n"
                ), true
        );
        library.put(
                new Book(
                        "One Hundred Years of Solitude",
                        "Gabriel García Márquez",
                        1967,
                        "This is the author's epic tale of seven generations of the Buendía family that also spans a hundred years of turbulent Latin American history, from the postcolonial 1820s to the 1920s. Patriarch José Arcadio Buendía builds the utopian city of Macondo in the middle of a swamp.\n"
                ), true
        );
        library.put(
                new Book(
                        "A Passage to India",
                        "E.M. Forster.",
                        1924,
                        "The book was published in 1924 and follows a Muslim Indian doctor named Aziz and his relationships with an English professor, Cyril Fielding, and a visiting English schoolteacher named Adela Quested. When Adela believes that Aziz has assaulted her while on a trip to the Marabar caves near the fictional city of Chandrapore, where the story is set, tensions between the Indian community and the colonial British community rise. The possibility of friendship and connection between English and Indian people, despite their cultural differences and imperial tensions, is explored in the conflict. The novel’s colorful descriptions of nature, the landscape of India, and the figurative power that they are given within the text solidifies it as a great work of fiction.\n"
                ), true
        );
        library.put(
                new Book(
                        "Invisible Man",
                        "Ralph Ellison",
                        1952,
                        "Often confused with H.G. Wells’s science-fiction novella of nearly the same name (just subtract a “The”), Ralph Ellison’s Invisible Man is a groundbreaking novel in the expression of identity for the African American male. The narrator of the novel, a man who is never named but believes he is “invisible” to others socially, tells the story of his move from the South to college and then to New York City. In each location he faces extreme adversity and discrimination, falling into and out of work, relationships, and questionable social movements in a wayward and ethereal mindset. The novel is renowned for its surreal and experimental style of writing that explores the symbolism surrounding African American identity and culture. Invisible Man won the U.S. National Book Award for Fiction in 1953.\n"
                ), true
        );
        library.put(
                new Book(
                        "Don Quixote",
                        "Miguel de Cervantes",
                        1615,
                        "Miguel de Cervantes’s Don Quixote, perhaps the most influential and well-known work of Spanish literature, was first published in full in 1615. The novel, which is very regularly regarded as one of the best literary works of all time, tells the story of a man who takes the name “Don Quixote de la Mancha” and sets off in a fit of obsession over romantic novels about chivalry to revive the custom and become a hero himself. The character of Don Quixote has become an idol and somewhat of an archetypal character, influencing many major works of art, music, and literature since the novel’s publication. The text has been so influential that a word, quixotic, based on the Don Quixote character, was created to describe someone who is, “foolishly impractical especially in the pursuit of ideals;\n"
                ), true
        );
        library.put(
                new Book(
                        "Beloved",
                        "Toni Morrison",
                        1980,
                        "Toni Morrison’s 1987 spiritual and haunting novel Beloved tells the story of an escaped slave named Sethe who has fled to Cincinnati, Ohio, in the year 1873. The novel investigates the trauma of slavery even after freedom has been gained, depicting Sethe’s guilt and emotional pain after having killed her own child, whom she named Beloved, to keep her from living life as a slave. A spectral figure appears in the lives of the characters and goes by the same name as the child, embodying the family’s anguish and hardship and making their feelings and past unavoidable.\n"
                ), true
        );
        library.put(
                new Book(
                        "Mrs. Dalloway",
                        "Virginia Woolf",
                        1925,
                        "Possibly the most idiosyncratic novel of this list, Virginia Woolf’s Mrs. Dalloway describes exactly one day in the life of a British socialite named Clarissa Dalloway. Using a combination of a third-person narration and the thoughts of various characters, the novel uses a stream-of-consciousness style all the way through. The result of this style is a deeply personal and revealing look into the characters’ minds, with the novel relying heavily on character rather than plot to tell its story.\n"
                ), true
        );
        library.put(
                new Book(
                        "Things Fall Apart",
                        "Chinua Achebe",
                        1958,
                        "The Western canon of “great literature” often focuses on writers who come from North America or Europe and often ignores accomplished writers and amazing works of literature from other parts of the world. Chinua Achebe’s Things Fall Apart, published in 1958, is one such work of African literature that had to overcome the bias of some literary circles and one that has been able to gain recognition worldwide despite it. The novel follows an Igbo man named Okonkwo, describing his family, the village in Nigeria where he lives, and the effects of British colonialism on his native country.\n"
                ), true
        );
        library.put(
                new Book(
                        "Jane Eyre",
                        "Charlotte Brontë",
                        1847,
                        "Charlotte Brontë’s Jane Eyre, another novel often assigned for reading in school, was initially published in 1847 under the pseudonym Currer Bell to disguise the fact that the writer was a woman. Fortunately, a lot has changed with regard to women in literature since 1847, and Brontë now receives the credit she deserves for one of the most-groundbreaking novels about women in history. At a time when the author felt compelled to hide her true identity, Jane Eyre provided a story of individualism for women. \n"
                ), true
        );
        library.put(
                new Book(
                        "The Color Purple",
                        "Alice Walker",
                        1982,
                        "Though the epistolary novel (a novel in the form of letters written by one or more characters) was most popular before the 19th century, Alice Walker became a champion of the style with her 1982 Pulitzer Prize- and National Book Award-winning novel The Color Purple. Set in the post-Civil War American South, the novel follows a young African American girl named Celie into adulthood in letters she writes to God and to her sister Nettie. Celie faces sexual abuse by her father and eventually her husband, chronicling her own suffering and growth as well as that of her friends and family."
                ), true
        );
        library.put(
                new Book(
                        "Anna Karenina",
                        " Leo Tolstoy",
                        1878,
                        "Any fan of stories that involve juicy subjects like adultery, gambling, marriage plots, and, well, Russian feudalism, would instantly place Anna Karenina at the peak of their “greatest novels” list. And that’s exactly the ranking that publications like Time magazine have given the novel since it was published in its entirety in 1878. Written by Russian novelist Leo Tolstoy, the eight-part towering work of fiction tells the story of two major characters: a tragic, disenchanted housewife, the titular Anna, who runs off with her young lover, and a lovestruck landowner named Konstantin Levin, who struggles in faith and philosophy."
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
        books.get(position - 1).read();
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
