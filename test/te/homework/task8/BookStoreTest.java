package te.homework.task8;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static te.homework.task8.Book.Type.*;


class BookStoreTest {

    @Test
    void getAll() {
        BookStore store = new BookStore();
        assertEquals(0, store.getAll().size());

        Book book1 = new Book("title", "author", 200, REGULAR, "100");
        Book book2 = new Book("title", "author", 200, REGULAR, "100");

        store.add(book1);
        store.add(book2);
        assertEquals(2, store.getAll().size());

        assertEquals(book1, store.getAll().get(0));
        assertEquals(book2, store.getAll().get(1));

        //
        List<Book> list = store.getAll();
        list.add(book1);

        assertEquals(3, list.size());
        assertEquals(2, store.getAll().size());

    }

    @Test
    void getByType() {
        BookStore store = new BookStore();
        assertEquals(0, store.getAll().size());

        store.add(new Book("title", "author", 200, REGULAR, "100"));
        store.add(new Book("title", "author", 200, REGULAR, "100"));
        store.add(new Book("title", "author", 200, CHILD, "100"));
        store.add(new Book("title", "author", 200, BESTSELLER, "100"));
        store.add(new Book("title", "author", 200, NEW, "100"));
        store.add(new Book("title", "author", 200, NEW, "100"));
        store.add(new Book("title", "author", 200, NEW, "100"));

        //
        assertEquals(2, store.getByType(REGULAR).size());
        assertEquals(1, store.getByType(CHILD).size());
        assertEquals(1, store.getByType(BESTSELLER).size());
        assertEquals(3, store.getByType(NEW).size());
        assertEquals(0, store.getByType(null).size());

        //
        List<Book> list = store.getByType(REGULAR);
        list.add(new Book("title", "author", 200, NEW, "100"));
        assertEquals(3, list.size());
        assertEquals(2, store.getByType(REGULAR).size());
    }

    @Test
    void add() {
        BookStore store = new BookStore();
        assertEquals(0, store.getAll().size());

        store.add(new Book("title", "author", 200, REGULAR, "100"));
        assertEquals(1, store.getAll().size());

        store.add(null);
        assertEquals(1, store.getAll().size());
    }

    @Test
    void update() {
        BookStore store = new BookStore();
        assertEquals(0, store.getAll().size());

        Book oldBook = new Book("title", "author", 200, REGULAR, "100");
        Book newBook = new Book("title", "author", 200, NEW, "100");

        store.add(oldBook);
        store.update(oldBook, newBook);
        assertEquals(1, store.getAll().size());
        assertEquals(0, store.getByType(REGULAR).size());
        assertEquals(newBook, store.getByType(NEW).get(0));

        //
        store.update(null, oldBook);
        assertEquals(1, store.getAll().size());
        assertEquals(newBook, store.getAll().get(0));

        store.update(null, null);
        assertEquals(1, store.getAll().size());
        assertEquals(newBook, store.getAll().get(0));

        store.update(oldBook, null);
        assertEquals(1, store.getAll().size());
        assertEquals(newBook, store.getAll().get(0));

    }

    @Test
    void massUpdate() {
        BookStore store = new BookStore();
        assertEquals(0, store.getAll().size());

        Book oldBook = new Book("title", "author", 200, REGULAR, "100");
        Book someBook = new Book("title", "author", 200, BESTSELLER, "100");
        Book newBook = new Book("title", "author", 200, NEW, "100");

        store.add(oldBook);
        store.add(someBook);
        store.add(oldBook);

        store.update(oldBook, newBook);
        assertEquals(3, store.getAll().size());
        assertEquals(0, store.getByType(REGULAR).size());
        assertEquals(2, store.getByType(NEW).size());
        assertEquals(newBook, store.getByType(NEW).get(0));
        assertEquals(newBook, store.getByType(NEW).get(1));
    }

    @Test
    void delete() {
        BookStore store = new BookStore();
        assertEquals(0, store.getAll().size());

        Book oldBook = new Book("title", "author", 200, REGULAR, "100");
        Book newBook = new Book("title", "author", 200, NEW, "100");

        store.add(newBook);
        store.add(oldBook);
        assertEquals(2, store.getAll().size());

        store.delete(oldBook);
        assertEquals(1, store.getAll().size());
        assertEquals(newBook, store.getAll().get(0));

        store.delete(oldBook);
        assertEquals(1, store.getAll().size());

        store.delete(newBook);
        assertEquals(0, store.getAll().size());

        //
        store.delete(null);
        assertEquals(0, store.getAll().size());

        store.add(oldBook);
        store.delete(null);
        assertEquals(1, store.getAll().size());
    }

    @Test
    void load(@TempDir Path tempDir) {
        Path booksFile = tempDir.resolve("books-test.txt");

        writeFile(booksFile.toString(),
                "title 1 | author 1 | 100 | regular | 100.00",
                "bad line",
                "      ",
                "title 2 | author 2 | 200 | regular | 100.20",
                ""
        );

        BookStore store = new BookStore();
        assertEquals(0, store.getAll().size());

        store.load(booksFile.toString());
        assertEquals(2, store.getAll().size());

        Book book1 = new Book("title 1", "author 1", 100, REGULAR, "100");
        assertEquals(book1, store.getAll().get(0));

        Book book2 = new Book("title 2", "author 2", 200, REGULAR, "100");
        assertEquals(book2, store.getAll().get(1));

    }

    @Test
    void save(@TempDir Path tempDir) {
        Path booksFile = tempDir.resolve("books-test.txt");

        BookStore store = new BookStore();

        Book book1 = new Book("title 1", "author 1", 100, REGULAR, "100");
        Book book2 = new Book("title 2", "author 2", 200, NEW, "100");

        store.add(book1);
        store.add(book2);
        store.save(booksFile.toString());

        List<String> list = readFile(booksFile.toString());
        assertEquals(2, list.size());
        assertEquals("title 1|author 1|100|REGULAR|100.00", list.get(0));
        assertEquals("title 2|author 2|200|NEW|100.00", list.get(1));

    }

    @Test
    void saveWithSeparator(@TempDir Path tempDir) {
        Path booksFile = tempDir.resolve("books-test.txt");

        BookStore store = new BookStore();

        Book book1 = new Book("title| 1", "author 1", 100, REGULAR, "100");

        store.add(book1);
        store.save(booksFile.toString());

        List<String> list = readFile(booksFile.toString());
        assertEquals(1, list.size());
        assertEquals("title 1|author 1|100|REGULAR|100.00", list.get(0));
    }

    private void writeFile(String filename, String... lines) {

        if (filename == null || lines == null) {
            throw new IllegalArgumentException();
        }

        try (PrintWriter writer = new PrintWriter(filename)) {
            for (String line : lines) {
                writer.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    private List<String> readFile(String filename) {
        if (filename == null) {
            throw new IllegalArgumentException();
        }
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
            return reader.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return Collections.emptyList();
        }
    }
}
