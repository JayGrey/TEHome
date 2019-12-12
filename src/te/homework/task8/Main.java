package te.homework.task8;

/*
Существует текстовый файлы, содержащий информацию про книги: автор, название, количество страниц,
тип ( новая, детская...), цена книги

программа должна
    считывать информацию из файла в коллекцию,
    показывать пользователю список книг,
    предлагать добавить новую книгу,
    давать возможность просмотреть список книг по типам,
    сохранить изменения в файл
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    private static final String BOOKS_FILE = "books.text";

    private BufferedReader reader;

    private BookStore store;

    public Main() {
        store = new BookStore();
        store.load(BOOKS_FILE);
        reader = new BufferedReader(new InputStreamReader(System.in));

    }

    public static void main(String[] args) {
        new Main().mainCycle();
    }

    private String bookView(Book book) {
        return String.format(Locale.ENGLISH,
                "title: %s, author: %s, pages: %d, type: %s, price: %.02f",
                book.getTitle(), book.getAuthor(), book.getPages(),
                book.getType().name().toLowerCase(), book.getPrice()
        );
    }

    private void mainCycle() {
        BooksActions answer;

        do {
            answer = askAction();
            switch (answer) {
                case SHOW_ALL_BOOKS: {
                    store.getAll().stream()
                            .map(this::bookView)
                            .forEach(System.out::println);
                    break;
                }

                case SHOW_BOOKS_BY_TYPE: {
                    askBookType().ifPresent(type -> store.getByType(type).stream()
                            .map(this::bookView)
                            .forEach(System.out::println));
                    break;
                }

                case ADD_NEW_BOOK: {
                    System.out.println(BooksActions.ADD_NEW_BOOK);
                    askNewBook().ifPresent(b -> store.add(b));
                    break;
                }

                case EXIT: {
                    if (!store.isPersist()) {
                        if (askSaveData()) {
                            store.save(BOOKS_FILE);
                        }
                    }
                }
            }
        } while (answer != BooksActions.EXIT);
    }

    private boolean askSaveData() {
        System.out.print("save data before exit ? (YES/no): ");
        try {
            String s = reader.readLine().trim().toLowerCase();
            return s.equalsIgnoreCase("yes") || s.equalsIgnoreCase("y");

        } catch (IOException e) {
            return false;
        }
    }

    private BooksActions askAction() {
        String message = String.format(
                "======================%n" +
                        "1 - Show all books%n" +
                        "2 - Show books by type%n" +
                        "3 - Add new book%n" +
                        "0 - exit%n"
        );

        BooksActions answer;
        while (true) {
            try {
                System.out.println(message);
                System.out.print("make your choice: ");

                String line = reader.readLine();
                answer = BooksActions.getAction(Integer.parseInt(line));
                return answer;
            } catch (IllegalArgumentException e) {
                System.out.format("input is incorrect !!!%n%n");
            } catch (IOException e) {
                return BooksActions.EXIT;
            }
        }
    }

    private Optional<Book.Type> askBookType() {
        String types = Arrays.stream(Book.Type.values())
                .map(Enum::name)
                .collect(Collectors.joining(", "));

        while (true) {
            try {
                System.out.format("choose book type [%s]: ", types);
                String line = reader.readLine();
                return Optional.of(Book.Type.valueOf(line.trim().toUpperCase()));
            } catch (IllegalArgumentException e) {
                System.out.println("input is incorrect !!!");
            } catch (IOException e) {
                return Optional.empty();
            }
        }
    }

    private Optional<Book> askNewBook() {
        try {
            System.out.print("book title: ");
            String title = reader.readLine().trim();

            System.out.print("book author: ");
            String author = reader.readLine().trim();

            System.out.print("num of pages (default 100): ");
            String pagesString = reader.readLine().trim();
            int pages = pagesString.length() > 0 ? Integer.parseInt(pagesString) : 100;

            System.out.print("book type (default regular): ");
            String typeString = reader.readLine().toUpperCase();
            Book.Type type = typeString.length() > 0 ? Book.Type.valueOf(typeString) : Book.Type.REGULAR;

            System.out.print("book price: ");
            String price = reader.readLine().trim();

            return Optional.of(new Book(title, author, pages, type, price));
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return Optional.empty();
        }
    }
}
