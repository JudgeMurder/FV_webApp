package myproject.FV_webApp.service;

import myproject.FV_webApp.model.Movie;
import myproject.FV_webApp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovie(int movieId) {
        return movieRepository.findById(movieId);
    }
}
