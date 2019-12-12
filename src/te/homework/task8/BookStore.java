package te.homework.task8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class BookStore {
    private List<Book> books;
    private boolean persist;

    BookStore() {
        books = new ArrayList<>();
        persist = true;
    }

    void load(String filename) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {

            books = reader.lines()
                    .map(this::stringToBook)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
            persist = true;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            books = Collections.emptyList();
        }
    }

    private Optional<Book> stringToBook(String line) {
        try {

            String[] tokens = line.split("\\|");

            return Optional.of(new Book(
                    tokens[0].trim(),
                    tokens[1].trim(),
                    Integer.parseInt(tokens[2].trim()),
                    Book.Type.valueOf(tokens[3].trim().toUpperCase()),
                    tokens[4].trim()
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
        return String.format(Locale.ENGLISH, "%s|%s|%d|%s|%.02f",
                book.getTitle().replace("|", ""),
                book.getAuthor().replace("|", ""),
                book.getPages(),
                book.getType().name(),
                book.getPrice()
        );
    }

    List<Book> getAll() {
        return new ArrayList<>(books);
    }

    List<Book> getByType(Book.Type type) {
        return books.stream()
                .filter(b -> b.getType() == type)
                .collect(Collectors.toList());
    }

    void add(Book book) {
        if (book != null) {
            books.add(book);
            persist = false;
        }
    }

    void update(Book oldBook, Book newBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).equals(oldBook)) {
                books.set(i, newBook);
                persist = false;
            }
        }
    }

    void delete(Book book) {
        boolean removed = books.removeIf(b -> b.equals(book));
        if (removed) {
            persist = false;
        }
    }

    public void save(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            books.stream()
                    .map(this::bookToString)
                    .forEach(writer::println);

            persist = true;
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    public boolean isPersist() {
        return persist;
    }
}
