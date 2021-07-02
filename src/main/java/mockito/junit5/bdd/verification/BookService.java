package mockito.junit5.bdd.verification;


import mockito.junit5.behavior.verification.BookRequest;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public void updatePrice(String bookId, int updatePrice) {
        Book book = bookRepository.findBookById(bookId);
        book.setPrice(updatePrice);
        bookRepository.save(book);

    }

}

