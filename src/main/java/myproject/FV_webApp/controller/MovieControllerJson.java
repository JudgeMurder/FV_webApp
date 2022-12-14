package myproject.FV_webApp.controller;

import myproject.FV_webApp.model.Movie;
import myproject.FV_webApp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping(path = "/homepage")
public class MovieControllerJson {

    @Autowired
    private MovieService movieService;

    //    http://localhost:8080/homepage/all
    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    //    http://localhost:8080/homepage/movie/4
    @GetMapping(path = "/movie/{id}")
    public @ResponseBody
    Optional<Movie> getMovie(@PathVariable int id) {
        return movieService.getMovie(id);
    }

    //    http://localhost:8080/homepage/movie/id/4
    @GetMapping(path = "/movie/id/{id}")
    public @ResponseBody
    Optional<Movie> getMovieByID(@PathVariable int id) {
        return movieService.getMovieByID(id);
    }

    //    http://localhost:8080/homepage/movie/title/Interstellar
    @GetMapping(path = "/movie/title/{title}")
    public @ResponseBody
    Optional<Movie> getMovieByTitle(@PathVariable String title) {
        return movieService.getMovieByTitle(title);
    }

    //    http://localhost:8080/homepage/movie/titleLike/d
    @GetMapping(path = "/movie/titleLike/{titleLike}")
    public @ResponseBody
    Iterable<Movie> getMovieByTitleLike(@PathVariable String titleLike) {
        return movieService.getMovieByTitleLike("%".concat(titleLike.concat("%")));
    }


}
