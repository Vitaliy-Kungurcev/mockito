package mockito.junit5.spies;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class BookManagerTest {

    @InjectMocks
    private BookManager bookManager;

    @Spy
    private BookService bookService;

    @Test
    public void testMockitoSpy() {
        Book book = new Book("1234", "Mockito In Action", 500, LocalDate.now());
        doReturn(book).when(bookService).findBook("1234"); //фиктивная реализация метода findBook. Spy
        int actualDiscount = bookManager.applyDiscountOnBook("1234", 10);
        assertEquals(450, actualDiscount);
    }
}
