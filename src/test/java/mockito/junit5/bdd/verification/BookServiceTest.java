package mockito.junit5.bdd.verification;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;


    @Test
    public void testupdatePrice2() {
        Book book = new Book("1234", "Mockito In Action", 500, LocalDate.now());
        when(bookRepository.findBookById("1234")).thenReturn(book); // если вызывается метод с этим параметром то вернуть book
        bookService.updatePrice("1234", 500);
        verify(bookRepository).findBookById("1234");
        verify(bookRepository).save(book);
    }

    @Test
    public void test_Given_Abook_When_UpdatePriceIsCalledWithNepPrice_Then_BookPriceIsUpdated() {
        // Given
        Book book = new Book("1234", "Mockito In Action", 500, LocalDate.now());
        given(bookRepository.findBookById("1234")).willReturn(book);

        //When
        bookService.updatePrice("1234", 500);

        //Then
        then(bookRepository).should().save(book);
    }
}
