package myproject.FV_webApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "movie")
@SecondaryTables({
        @SecondaryTable(name = "genre", pkJoinColumns = {
                @PrimaryKeyJoinColumn(name = "genreID")
        }),
        @SecondaryTable(name = "poster", pkJoinColumns = {
                @PrimaryKeyJoinColumn(name = "posterID")
        }),
        @SecondaryTable(name = "studio", pkJoinColumns = {
                @PrimaryKeyJoinColumn(name = "studioID")
        }),
        @SecondaryTable(name = "trailer", pkJoinColumns = {
                @PrimaryKeyJoinColumn(name = "trailerID")
        })
})
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
    @Column(name = "genretype", table = "genre")
    private String genreType;
    @Column(name = "posterlink", table = "poster")
    private String posterLink;
    @Column(name = "studioname", table = "studio")
    private String studioName;
    @Column(name = "trailerurl", table = "trailer")
    private String trailerURL;

    @Override
    public String toString() {
        return
//                "movieID" + movieID +
                "Movie Title - '" + movieTitle + '\'' +
                ", Plot Summary - '" + moviePlot + '\'' +
                ", Release Date - '" + movieReleaseDate + '\'' +
                ", Runtime - '" + movieRuntime + '\'' +
                ", Certificate - '" + movieCertificate + '\'' +
                ", Rating - '" + movieRating + '\'' +
                ", Genre '" + genreType +
                "'";
    }
}
