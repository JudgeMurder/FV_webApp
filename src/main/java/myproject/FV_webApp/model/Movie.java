package myproject.FV_webApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "movie")
@SecondaryTables({
        @SecondaryTable(name = "genre", pkJoinColumns = {
                @PrimaryKeyJoinColumn(name = "genreID")
        }),
        @SecondaryTable(name = "media", pkJoinColumns = {
                @PrimaryKeyJoinColumn(name = "mediaID")
        }),
        @SecondaryTable(name = "user_data", pkJoinColumns = {
                @PrimaryKeyJoinColumn(name = "userID")
        }),

})
@Getter @Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieID;

    @Column(name = "movietitle")
    private String movieTitle;
    @Column(name = "moviereleasedate")
    private Integer movieReleaseDate;
    @Column(name = "movieruntime")
    private Integer movieRuntime;
    @Column(name = "movieplot")
    private String moviePlot;
    @Column(name = "genretype",table = "genre")
    private String genreType;
    @Column(name = "trailerlink", table = "media")
    private String trailerLink;
    @Column(name = "posterlink", table = "media")
    private String posterLink;
    @Column(name = "userrating", table = "user_data")
    private Integer userRating;
    @Column(name = "userreview", table = "user_data")
    private String userReview;
}
