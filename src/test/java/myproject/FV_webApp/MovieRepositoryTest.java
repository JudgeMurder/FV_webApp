package myproject.FV_webApp;


import myproject.FV_webApp.model.Movie;
import myproject.FV_webApp.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class MovieRepositoryTest {

    @Autowired private MovieRepository repo;

    @Test
    public void testAddNew() {
        Movie review = new Movie();
        review.setUserReview("Wow nice");
        review.setUserRating(5);

        Movie savedReview = repo.save(review);

    }
}
