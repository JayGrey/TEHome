package te.homework.task8;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int pages;
    private Type type;
    private BigDecimal price;

    Book(String title, String author, int pages, Type type, String price) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.type = type;
        this.price = new BigDecimal(price, new MathContext(2));
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getAuthor() {
        return author;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    int getPages() {
        return pages;
    }

    void setPages(int pages) {
        this.pages = pages;
    }

    Type getType() {
        return type;
    }

    void setType(Type type) {
        this.type = type;
    }

    BigDecimal getPrice() {
        return price;
    }

    void setPrice(BigDecimal price) {
        this.price = price;
    }

    public enum Type {
        NEW, CHILD, BESTSELLER, REGULAR
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages &&
                title.equals(book.title) &&
                author.equals(book.author) &&
                type == book.type &&
                price.equals(book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, pages, type, price);
    }

    @Override
    public String toString() {
        return "Book {" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", type=" + type +
                ", price=" + price +
                '}';
    }
}
