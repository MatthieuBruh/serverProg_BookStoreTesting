package fi.haagahelia.bookstore;


import fi.haagahelia.bookstore.web.CategoryController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CategoryControllerTest {

    @Autowired
    private CategoryController categoryController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(categoryController).isNotNull();
    }
}
