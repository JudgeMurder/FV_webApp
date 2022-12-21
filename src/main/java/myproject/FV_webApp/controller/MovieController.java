package myproject.FV_webApp.controller;

import myproject.FV_webApp.model.Movie;
import myproject.FV_webApp.service.MovieNotFoundException;
import myproject.FV_webApp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/movie/templates")
public class MovieController {

    @Autowired
    private MovieService movieService;

    //    http://localhost:8080/movie/templates/1
    @GetMapping(path = "/{id}")
    public String getMovieId(@PathVariable int id, Model model) {
        Optional<Movie> movie = movieService.getMovieByID(id);
        movie.isPresent();
        model.addAttribute("movie_key", movie.get());
        return "movie_details";
    }

    //    http://localhost:8080/movie/templates/all
    @GetMapping(path = "/all")
    public String getAllMovies(Model model) {
        List<Movie> movies = (List<Movie>) movieService.getAllMovies();
        model.addAttribute("list", movies);
        return "movie_title_list";
    }

    //    http://localhost:8080/movie/templates/homepage
    @GetMapping(path = "/homepage")
    public String showHomePage(Model model) {
        return "homepage";
    }



    //    http://localhost:8080/movie/templates/search
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getMoviesByTitleLike(Model model) {
        model.addAttribute("movies_list", Collections.emptyList());
        model.addAttribute("movie_key", new Movie());
        return "/movie_search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String showMovieByTitleLike(@ModelAttribute("movie_key") Movie movie, Model model) {
        List<Movie> movies = (List<Movie>) movieService.getMovieByTitleLike(movie.getMovieTitle());
        model.addAttribute("movies_list", movies);
        return "/movie_search";
    }

    @GetMapping("/addtitle")
    public String addMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("pageTitle", "Add New Movie");
        return "add_movie_form";
    }

    @PostMapping("/save")
    public String savedMovie(Movie movie, RedirectAttributes movieAddedMessage) {
        movieService.saveMovie(movie);
        movieAddedMessage.addFlashAttribute("message", "Updated");
        return "redirect:/movie/templates/search";
    }

//    http://localhost:8080/movie/templates/search
    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model,
                               RedirectAttributes movieAddedMessage) {
        try {
            Movie movie = movieService.getMovie(id);
            model.addAttribute("movie", movie);
            model.addAttribute("pageTitle", "Edit Movie Details");
            return "add_movie_form";
        } catch (MovieNotFoundException e) {
            movieAddedMessage.addFlashAttribute("message", e.getMessage());
            return "redirect:/movie/templates/search";
        }
    }

    @GetMapping("delete/{id}")
    public String deleteMovie(@PathVariable("id") Integer id, RedirectAttributes movieAddedMessage) {
        try {
            movieService.delete(id);
            movieAddedMessage.addFlashAttribute("message", "Updated");
        } catch (MovieNotFoundException e) {
            movieAddedMessage.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/movie/templates/search";
    }

    //    http://localhost:8080/movie/templates/homepage
}
