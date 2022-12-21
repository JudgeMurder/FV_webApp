package myproject.FV_webApp.repository;

import myproject.FV_webApp.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

    Optional<Movie> findByMovieID(int id);
    Optional<Movie> findByMovieTitle(String title);
    Iterable<Movie> findByMovieTitleLike(String titleLike);

    Long countByMovieID(Integer id);
}
