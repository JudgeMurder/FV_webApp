package myproject.FV_webApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "movie")
@Getter @Setter
public class Movie {

    @Id
    @Column(name = "movieid")
    private Integer movieID;
    @Column(name = "movietitle")
    private String movieTitle;
    @Column(name = "movieplot")
    private String moviePlot;
    @Column(name = "moviereleasedate")
    private Date movieReleaseDate;
    @Column(name = "movieruntime")
    private Integer movieRuntime;
    @Column(name = "moviecertificate")
    private String movieCertificate;
    @Column(name = "movierating")
    private String movieRating;

    @Override
    public String toString() {
        return
//                "movieID" + movieID +
                "Movie Title - '" + movieTitle + '\'' +
                ", Plot Summary - '" + moviePlot + '\'' +
                ", Release Date - '" + movieReleaseDate + '\'' +
                ", Runtime - '" + movieRuntime + '\'' +
                ", Certificate - '" + movieCertificate + '\'' +
                ", Rating - '" + movieRating +
                "'";
    }
}
