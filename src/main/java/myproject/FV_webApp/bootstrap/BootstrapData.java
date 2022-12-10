package myproject.FV_webApp.bootstrap;

import myproject.FV_webApp.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private MovieRepository movieRepository;

    public BootstrapData(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        movieRepository.findAll().forEach(System.out::println);
    }
}
