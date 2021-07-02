package mockito.junit5.behavior.verification;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testAddBook() {
        Book book = new Book(null, "Mockito In Action", 600, LocalDate.now());
        bookService.addBook(book);
        verify(bookRepository).save(book); //вызывался ли метод
    }

    @Test
    public void testupdatePrice() {
        bookService.updatePrice(null, 600);
        verifyNoInteractions(bookRepository); //  не происходило взаимодействия

    }

    @Test
    public void testupdatePrice2() {
        Book book = new Book("1234", "Mockito In Action", 500, LocalDate.now());
        when(bookRepository.findBookById("1234")).thenReturn(book); // если вызывается метод с этим параметром то вернуть book
        bookService.updatePrice("1234", 500);
        verify(bookRepository).findBookById("1234");
        verifyNoMoreInteractions(bookRepository); //больше не происходило взаимодействий
    }

    @Test
    public void testupdatePrice3() {
        Book book = new Book("1234", "Mockito In Action", 500, LocalDate.now());
        when(bookRepository.findBookById("1234")).thenReturn(book); // если вызывается метод с этим параметром то вернуть book
        bookService.updatePrice("1234", 600);

        InOrder inOrder = Mockito.inOrder(bookRepository);

        inOrder.verify(bookRepository).findBookById("1234"); // проверка что порядок выполнения методов сохранен.
        inOrder.verify(bookRepository).save(book);
    }

    @Test
    public void testSaveBookWithGreatherPrice() {
        BookRequest bookRequest = new BookRequest("Mockito In Action", 600, LocalDate.now());
        Book book = new Book(null, "Mockito In Action", 600, LocalDate.now());
        bookService.addBook(bookRequest);
        bookService.addBook(bookRequest);
//        verify(bookRepository,times(2)).save(book);
//        verify(bookRepository,atLeast(1)).save(book);//проверка,что метод вызывался не менее одного раза
        verify(bookRepository,atMost(2)).save(book);//проверка,что метод вызывался не более 2 раз

    }
}
