package myproject.FV_webApp;


import myproject.FV_webApp.model.Movie;
import myproject.FV_webApp.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = true)
public class MovieRepositoryTest {

    @Autowired private MovieRepository repo;

    @Test
    public void testAddNewUserData() {
        Movie review = new Movie();
        review.setUserID(15);
        review.setUserReview("HERE IS A REVIEW");
        review.setUserRating(5);

        Movie savedReview = repo.save(review);
    }

    @Test
    public void testAddNewMovie() {
        Movie movie = new Movie();
        movie.setMovieTitle("The Rock");

        Movie savedMovie = repo.save(movie);
    }

    @Test
    public void testListAll() {
        Iterable<Movie> movies = repo.findAll();

        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    @Test
    public void testUpdate() {
        Integer userID = 1;
        Optional<Movie> optionalMovie = repo.findById(userID);
        Movie movie = optionalMovie.get();
        movie.setUserReview("NEW REVIEW");
        repo.save(movie);
    }

    @Test
    public void testGet() {
        Integer movieID = 3;
        Optional<Movie> optionalMovie = repo.findByMovieID(movieID);
        Movie movie = optionalMovie.get();
        System.out.println(optionalMovie.get());
    }

    @Test
    public void testDelete() {
        Integer userID = 1;
        repo.deleteById(userID);
    }
}
