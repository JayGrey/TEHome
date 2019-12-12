package te.homework.task8;

import java.math.BigDecimal;
import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int pages;
    private Type type;
    private BigDecimal price;

    public Book(String title, String author, int pages, Type type, BigDecimal price) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.type = type;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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
}
