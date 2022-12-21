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
    public Optional<Movie> getMovieByID (int id) {
        return movieRepository.findByMovieID(id);
    }
    public Optional<Movie> getMovieByTitle (String title) { return movieRepository.findByMovieTitle(title);}
    public Iterable<Movie> getMovieByTitleLike (String movieTitle) {
        return movieRepository.findByMovieTitleLike(
                String.format("%%%s%%", movieTitle)
        );
    }

    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public Movie getMovie(Integer id) throws MovieNotFoundException {
        Optional<Movie> movieFound = movieRepository.findByMovieID(id);
        if (movieFound.isPresent()) {
            return movieFound.get();
        }
        throw new MovieNotFoundException("Movie not found");
    }

    public void delete(Integer id) throws MovieNotFoundException {
        Long count = movieRepository.countByMovieID(id);
        if (count == null || count == 0) {
            throw new MovieNotFoundException("Movie not found");
        }
        movieRepository.deleteById(id);
    }
}
