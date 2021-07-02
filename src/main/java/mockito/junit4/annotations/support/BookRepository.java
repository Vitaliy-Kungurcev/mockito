package mockito.junit4.annotations.support;

import java.util.List;

public interface BookRepository {


    List<Book> findNewBooks(int days);
}
