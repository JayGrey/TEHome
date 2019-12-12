package te.homework.task8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static te.homework.task8.Book.Type.BESTSELLER;
import static te.homework.task8.Book.Type.CHILD;

class BookTest {

    @Test
    void equals() {
        Book book1 = new Book("Book 1 title", "Book 1 author", 100, BESTSELLER, "10.10");
        Book book2 = new Book("Book 1 title", "Book 1 author", 100, BESTSELLER, "10.10");
        Book book3 = new Book("Book 3 title", "Book 3 author", 100, CHILD, "10.10");

        assertEquals(book1, book2);
        assertNotEquals(book1, book3);

    }

    @Test
    void equalsDecimal() {
        Book book1 = new Book("Book 1 title", "Book 1 author", 100, BESTSELLER, "10");
        Book book2 = new Book("Book 1 title", "Book 1 author", 100, BESTSELLER, "10.10");

        assertEquals(book1, book2);
    }

    @Test
    void hashcode() {
        Book book1 = new Book("Book 1 title", "Book 1 author", 100, BESTSELLER, "10.10");
        Book book2 = new Book("Book 3 title", "Book 3 author", 100, CHILD, "10.10");

        assertNotEquals(book1.hashCode(), book2.hashCode());
    }
}