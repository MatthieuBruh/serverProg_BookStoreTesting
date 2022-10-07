package fi.haagahelia.bookstore;


import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void findByISBNReturnBook() {
        Book book = repository.findBooksByIsbn("0-7475-3269-9");
        assertThat(book.getIsbn()).isEqualTo("0-7475-3269-9");
        assertThat(book.getTitle()).isEqualTo("Harry Potter and the Philosopher's Stone");
        assertThat(book.getAuthor()).isEqualTo("J.K. Rowling");
        assertThat(book.getReleaseYear()).isEqualTo(1997);
        assertThat(book.getPrice()).isEqualTo(8.99);
        assertThat(book.getCategory().getName()).isEqualTo("Fantasy");
    }

    @Test
    public void createNewBook() {
        Book book = new Book("The Giver", "Lois Lowry", 1993, "0-375-82793-5", 8.99, null);
        repository.save(book);
        assertThat(book.getIsbn()).isNotNull();
        assertThat(book.getTitle()).isEqualTo("The Giver");
        assertThat(book.getAuthor()).isEqualTo("Lois Lowry");
        assertThat(book.getReleaseYear()).isEqualTo(1993);
        assertThat(book.getPrice()).isEqualTo(8.99);
    }


    @Test
    public void deleteBook() {
        Book book = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, "0-395-19395-8", 8.99, null);
        repository.save(book);
        Book bookToDelete = repository.findBooksByIsbn("0-395-19395-8");
        repository.delete(bookToDelete);
        Book bookSearched = repository.findBooksByIsbn("0-395-19395-8");
        assertThat(bookSearched).isNull();
    }
}
