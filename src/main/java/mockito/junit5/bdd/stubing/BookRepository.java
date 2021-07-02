package mockito.junit5.bdd.stubing;

import java.util.List;

public interface BookRepository {


    List<Book> findNewBooks(int days);
}
