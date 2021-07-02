package mockito.junit5.spies;

import mockito.junit5.stubbing.BookRepository;
import mockito.junit5.stubbing.BookRequest;

import java.util.List;

public class BookService {


    public Book findBook(String bookId) {
        return null;
    }

    public int getAppliedDiscount(Book book, int discountRate) {
        int price = book.getPrice();
        int newPrice = price - (price * discountRate / 100);
        return newPrice;
    }
}
