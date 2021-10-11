package dao;

import dto.DVD;

import java.io.*;
import java.util.*;

public class DVDLibraryDaoImpl implements DVDLibraryDao {
    private Map<String, DVD> dvdLibrary = new HashMap<>();

    public DVDLibraryDaoImpl() {

    }

    public Map<String, DVD> loadDVDLibrary(String file) throws DVDLibraryDaoException, FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new FileReader(file)));
        Map<String, DVD> dvds = new HashMap<>();
        while(in.hasNextLine()){
            DVD newDVD = new DVD();
            int linePos = 0;
            String currentData = "";
            char[] currentLine = in.nextLine().toCharArray();
            for (int i = 0; i < currentLine.length; i++) {
                if (currentLine[i] == ':' && currentLine[i - 1] == ':') {
                    linePos++;
                    switch (linePos) {
                        case 0:
                            newDVD.setTitle(currentData);
                            break;
                        case 1:
                            newDVD.setDirector(currentData);
                            break;
                        case 2:
                            newDVD.setStudio(currentData);
                            break;
                        case 3:
                            newDVD.setMpaaRating(currentData);
                            break;
                        case 4:
                            currentData += '/';
                            String currentDateValue = "";
                            int pos = 0;
                            int day = 0;
                            int month = 0;
                            int year = 0;
                            for (int j = 0; j < currentData.toCharArray().length; j++) {
                                if (currentData.toCharArray()[j] == '/') {
                                    if (pos == 0) {
                                        day = Integer.parseInt(currentDateValue);
                                    } else if (pos == 1) {
                                        month = Integer.parseInt(currentDateValue);
                                    } else if (pos == 2) {
                                        year = Integer.parseInt(currentDateValue);
                                    }
                                    pos++;
                                } else {
                                    currentDateValue += currentData.toCharArray()[j];
                                }
                            }
                            newDVD.setReleaseDate(day, month, year);
                        case 5:
                            newDVD.setUserRating(Integer.parseInt(currentData));
                        case 6:
                            newDVD.setUserRatingNote(currentData);
                    }
                } else if (currentLine[i] != ':') {
                    currentData += currentLine[i];
                }
            }
            dvds.put(newDVD.getTitle(), newDVD);
        }
        return dvds;
    }

    public void saveDVDLibrary(List<DVD> DVDLibrary, String file) throws DVDLibraryDaoException, IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file));
        for(DVD dvd : dvdLibrary.values()){
            out.println(dvd.getTitle() + "::" + dvd.getDirector() + "::" + dvd.getStudio() + "::" + dvd.getMpaaRating() + "::" +
                    dvd.getReleaseDate().getDayOfMonth() + "/" + dvd.getReleaseDate().getMonthValue() + "/" + dvd.getReleaseDate().getYear() + "::" +
                    dvd.getUserRating().getRating() + "::" + dvd.getUserRating().getNote() + "::");
            out.flush();
            out.close();
        }
    }

    public List<DVD> getDvdLibrary() throws DVDLibraryDaoException {
        return new ArrayList<>(dvdLibrary.values());
    }

    public DVD getDVD(String title) throws DVDLibraryDaoException {
        return dvdLibrary.get(title);
    }

    public void addDVD(DVD dvd) throws DVDLibraryDaoException {
        if (dvdLibrary.get(dvd.getTitle()) == null) {
            dvdLibrary.put(dvd.getTitle(), dvd);
        } else {
            System.out.println("This dvd '" + dvd.getTitle() + "' already exists in the library.");
        }
    }

    public void removeDVD(String title) throws DVDLibraryDaoException {
        dvdLibrary.remove(title);
        System.out.println("Removed " + title);
    }

    public void editDVD(String title, DVD dvd) throws DVDLibraryDaoException {
        dvdLibrary.replace(title, dvd);
    }
}
