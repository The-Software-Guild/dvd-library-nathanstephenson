package dto;

public class UserRating {

    private int rating;
    private String note = null;

    public UserRating() {

    }

    public UserRating(String note) {
        this.note = note;
    }

    public UserRating(int rating) {
        this.rating = rating;
    }

    public UserRating(int rating, String note) {
        this.rating = rating;
        this.note = note;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String toString() {
        if (rating != 0 && note != null) {
            return rating + "/5 : " + note;
        } else if (rating == 0 && note != null) {
            return note;
        } else if (rating != 0) {
            return rating + "/5";
        } else return "No rating given.";
    }
}
