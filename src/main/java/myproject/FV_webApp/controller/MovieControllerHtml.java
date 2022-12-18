package myproject.FV_webApp.controller;

import myproject.FV_webApp.model.Movie;
import myproject.FV_webApp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/movie/templates")
public class MovieControllerHtml {

    @Autowired
    private MovieService movieService;

    //    http://localhost:8080/movie/templates/test
    @GetMapping(path = "/test")
    public String getTestText() {
        return "html_test";
    }

    //    http://localhost:8080/movie/templates/3
    @GetMapping(path = "/{id}")
    public String getMovie(@PathVariable int id, Model model) {
        Optional<Movie> movie = movieService.getMovieByID(id);
        movie.isPresent();
        model.addAttribute("key_movie", movie.get());
        return "movieDetails";
    }

    //    http://localhost:8080/movie/templates/all
    @GetMapping(path = "/all")
    public String getAllMovies(Model model) {
        List<Movie> movies = (List<Movie>) movieService.getAllMovies();
        model.addAttribute("list", movies);
        return "movieTitleList";
    }

    //    http://localhost:8080/movie/templates/homepage
    @GetMapping(path = "/homepage")
    public String showHomePage(Model model) {
        return "homepage";
    }
}
