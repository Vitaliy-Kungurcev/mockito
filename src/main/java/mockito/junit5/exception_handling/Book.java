package mockito.junit5.exception_handling;

import java.time.LocalDate;

public class Book {

    private String bookId;
    private String title;
    private int price;
    private LocalDate publishedDate;

    public Book() {
    }

    public Book(String bookId, String title, int price, LocalDate publishedDate) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
        this.publishedDate = publishedDate;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (price != book.price) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        return publishedDate != null ? publishedDate.equals(book.publishedDate) : book.publishedDate == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + price;
        result = 31 * result + (publishedDate != null ? publishedDate.hashCode() : 0);
        return result;
    }
}
