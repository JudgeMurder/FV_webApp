package myproject.FV_webApp.service;

public class MovieNotFoundException extends Throwable {

    public MovieNotFoundException(String message) {
        super(message);
    }
}
