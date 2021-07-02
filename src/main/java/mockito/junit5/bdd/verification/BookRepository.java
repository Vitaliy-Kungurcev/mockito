package mockito.junit5.bdd.verification;

public interface BookRepository {

    void save(Book book);

    Book findBookById(String bookId);
}
