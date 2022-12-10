package myproject.FV_webApp.repository;

import myproject.FV_webApp.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
}
