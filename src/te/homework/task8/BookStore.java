package te.homework.task8;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookStore {
    private List<Book> books;

    public void load(String filename) {
        try {
            books = Files.lines(Paths.get(filename))
                    .map(this::stringToBook)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            books = Collections.emptyList();
        }
    }

    public BookStore() {
        books = new ArrayList<>();
    }

    private Optional<Book> stringToBook(String line) {
        try {

            String[] tokens = line.split("|");

            return Optional.of(new Book(
                    tokens[0].trim(),
                    tokens[1].trim(),
                    Integer.parseInt(tokens[2].trim()),
                    Book.Type.valueOf(tokens[3].trim().toUpperCase()),
                    new BigDecimal(tokens[4].trim())
            ));
        } catch (RuntimeException e) {
            e.printStackTrace(System.err);
            return Optional.empty();
        }
    }

    private String bookToString(Book book) {
        if (book == null) {
            return "";
        }

        return book.getTitle() + "|"
                + book.getAuthor() + "|"
                + book.getPages() + "|"
                + book.getType().name() + "|"
                + book.getPrice();
    }

    public List<Book> getAll() {
        return new ArrayList<>(books);
    }

    public List<Book> getByType(Book.Type type) {
        return books.stream()
                .filter(b -> b.getType() == type)
                .collect(Collectors.toList());
    }

    public void add(Book book) {
        if (book != null) {
            books.add(book);
        }
    }

    public void update(Book oldBook, Book newBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).equals(oldBook)) {
                books.set(i, newBook);
            }
        }
    }

    public void delete(Book book) {
        books.removeIf(b -> b.equals(book));
    }

    public void save(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            books.stream()
                    .map(this::bookToString)
                    .forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}
