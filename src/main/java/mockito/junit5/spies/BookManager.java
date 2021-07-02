package mockito.junit5.spies;

public class BookManager {

    private BookService bookService;

    public BookManager(BookService bookService) {
        this.bookService = bookService;
    }

    public int applyDiscountOnBook(String bookId, int discountRate){
        Book book=bookService.findBook(bookId);
        int discounedPrice=bookService.getAppliedDiscount(book,discountRate);
        return discounedPrice;
    }
}
