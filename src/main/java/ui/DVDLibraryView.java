package ui;

import dto.DVD;

import java.util.List;
import java.util.Map;

public class DVDLibraryView {
    private UserIO io;

    public DVDLibraryView(UserIO userIO) {
        this.io = userIO;
    }

    public int menu() {
        io.print("---Main Menu---");
        io.print("1 - add DVD");
        io.print("2 - remove DVD");
        io.print("3 - edit DVD");
        io.print("4 - show DVDs");
        io.print("5 - search DVDs");
        io.print("6 - load DVDs from file");
        io.print("7 - save DVDs to file");
        return io.readInt("Please enter the number of the option you select: ", 1, 7);
    }

    public DVD addDVD() {
        String title = io.readString("Please enter the title: ");
        String director = io.readString("Please enter the director's name: ");
        String studio = io.readString("Please enter the studio's name: ");
        String mpaa = io.readString("Please enter the mpaa rating: ");
        int releaseDay = io.readInt("Please enter the release date's Day: ");
        int releaseMonth = io.readInt("Please enter the release date's Month: ");
        int releaseYear = io.readInt("Please enter the release date's Year: ");
        int userRating = io.readInt("Please enter your own rating for this film (1-10): ", 1, 10);
        String userNote = io.readString("Please enter any extra notes: ");
        return new DVD(title, director, studio, mpaa, releaseDay, releaseMonth, releaseYear, userRating, userNote);
    }

    public String removeDVD() {
        return io.readString("Please enter the name of the DVD you wish to remove: ");
    }

    public String editDVDGetTitle() {
        return io.readString("Please enter the title of the DVD you wish to edit: ");
    }

    public DVD editDVD(String title, Map<String, DVD> library) {
        DVD dvd = library.get(title);
        io.print("Please choose which property to edit: ");
        io.print("1 - Title");
        io.print("2 - Director");
        io.print("3 - Studio");
        io.print("4 - MPAA Rating");
        io.print("5 - Release Date");
        io.print("6 - Rating");
        switch (io.readInt("Selection: ", 1, 6)) {
            case 1:
                dvd.setTitle(io.readString("Please enter the title: "));
                break;
            case 2:
                dvd.setDirector(io.readString("Please enter the director's name: "));
                break;
            case 3:
                dvd.setStudio(io.readString("Please enter the studio's name: "));
                break;
            case 4:
                dvd.setMpaaRating(io.readString("Please enter the mpaa rating: "));
                break;
            case 5:
                dvd.setReleaseDate(io.readInt("Please enter the day of the month this film was released: ", 1, 31),
                        io.readInt("Please enter the month of the year this film was released: ", 1, 12),
                        io.readInt("Please enter the year this film was released: "));
                break;
            case 6:
                dvd.setUserRating(io.readInt("Please enter a rating for this film (1-10): ", 1, 10));
                dvd.setUserRatingNote(io.readString("Please enter any extra notes: "));
                break;
        }
        return dvd;
    }

    public void showLibrary(List<DVD> library) {
        for (DVD dvd : library) {
            io.print(dvd.getTitle() + " (" + dvd.getReleaseDate().getYear() + ") - " + dvd.getUserRating().getRating() + "/10");
        }
    }

    public void showDVD(Map<String, DVD> library) {
        DVD dvd = library.get(io.readString("Please enter the title of the DVD you wish to view the details of: "));
        io.print(dvd.getTitle() + " (" + dvd.getReleaseDate().getYear() + ") - " + dvd.getMpaaRating() +
                "\n" + dvd.getDirector() + ", " + dvd.getStudio() + ", " +
                "\n" + dvd.getUserRating().getRating() + "/10 - " + dvd.getUserRating().getNote());
    }

    public String getFilename() {
        return io.readString("Please enter the name of the file: ");
    }
}
