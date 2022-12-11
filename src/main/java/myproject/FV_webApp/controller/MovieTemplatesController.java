package myproject.FV_webApp.controller;

import myproject.FV_webApp.model.Movie;
import myproject.FV_webApp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping(path = "/movie/templates")
public class MovieTemplatesController {

    @Autowired
    private MovieService movieService;

    //    http://localhost:8080/movie/templates/test
    @GetMapping(path = "/test")
    public String getTestText() {
        return "html_test";
    }

    //    http://localhost:8080/movie/templates/firstpage/3
    @GetMapping(path = "/firstpage/{id}")
    public String getMovieDetails(@PathVariable int id, Model model) {
        Optional<Movie> movie = movieService.getMovieByID(id);
        model.addAttribute("movie_title", movie.get().getMovieTitle());
        model.addAttribute("movie_release_date", movie.get().getMovieReleaseDate());
        model.addAttribute("movie_runtime", movie.get().getMovieRuntime()+" minutes");
        model.addAttribute("movie_rating", movie.get().getMovieRating());
        return "firstpage";
    }

    //    http://localhost:8080/movie/templates/3
    @GetMapping(path = "/{id}")
    public String getMovie(@PathVariable int id, Model model) {
        Optional<Movie> movie = movieService.getMovieByID(id);
        movie.isPresent();
        model.addAttribute("key_movie", movie.get());
        return "movie_th";
    }


}