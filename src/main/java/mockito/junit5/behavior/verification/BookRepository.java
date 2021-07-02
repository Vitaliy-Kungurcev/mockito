package mockito.junit5.behavior.verification;

public interface BookRepository {

    void save(Book book);

    Book findBookById(String bookId);
}
