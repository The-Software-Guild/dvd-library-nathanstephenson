package dto;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DVD {
    private String title;
    private LocalDate releaseDate;
    private String mpaaRating;
    private String director;
    private String studio;
    private UserRating userRating = new UserRating();

    public DVD() {

    }

    public DVD(String title, String director, String studio, String mpaaRating, int releaseDateDay, int releaseDateMonth, int releaseDateYear, int userRating, String ratingNote) {
        this.title = title;
        this.releaseDate = LocalDate.of(releaseDateYear, releaseDateMonth, releaseDateDay);
        this.mpaaRating = mpaaRating;
        this.director = director;
        this.studio = studio;
        this.userRating = new UserRating(userRating, ratingNote);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int day, int month, int year) {
        this.releaseDate = LocalDate.of(year, month, day);
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public UserRating getUserRating() {
        return userRating;
    }

    public void setUserRating(int rating) { this.userRating.setRating(rating); }

    public void setUserRatingNote(String note){ this.userRating.setNote(note); }
}
