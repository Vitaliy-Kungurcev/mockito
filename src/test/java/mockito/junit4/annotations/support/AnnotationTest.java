package mockito.junit4.annotations.support;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AnnotationTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Test
    public void demoCreateMocksUsingAnnotations() {

        Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "jUnit In Action", 400, LocalDate.now());

        List<Book> newBooks = new ArrayList<>();
        newBooks.add(book1);
        newBooks.add(book2);

        when(bookRepository.findNewBooks(7)).thenReturn(newBooks);

        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());

    }
}
