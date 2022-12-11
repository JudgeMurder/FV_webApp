package myproject.FV_webApp.printOut;

import myproject.FV_webApp.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PrintOut implements CommandLineRunner {

    private MovieRepository movieRepository;

    public PrintOut(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        movieRepository.findAll().forEach(System.out::println);
    }
}
