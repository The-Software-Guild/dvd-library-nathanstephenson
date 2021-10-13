package dao;

import dto.DVD;

import java.io.*;
import java.util.*;

public class DVDLibraryDaoImpl implements DVDLibraryDao {
    private Map<String, DVD> dvdLibrary = new HashMap<>();

    public DVDLibraryDaoImpl() {

    }

    public void loadDVDLibrary(String file) throws DVDLibraryDaoException, FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new FileReader(file + ".txt")));
        Map<String, DVD> dvds = new HashMap<>();
        try{
            while (in.hasNextLine()) {
                DVD newDVD = new DVD();
                int linePos = 0;
                String currentData = "";
                char[] currentLine = in.nextLine().toCharArray();
                for (int i = 0; i < currentLine.length; i++) {
                    if (currentLine[i] == ':' && currentLine[i - 1] == ':') {
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
                                        currentDateValue = "";
                                    } else {
                                        currentDateValue += currentData.toCharArray()[j];
                                    }
                                }
                                newDVD.setReleaseDate(day, month, year);
                                break;
                            case 5:
                                newDVD.setUserRating(Integer.parseInt(currentData));
                                break;
                            case 6:
                                newDVD.setUserRatingNote(currentData);
                                break;
                        }
                        linePos++;
                        currentData = "";
                    } else if (currentLine[i] != ':') {
                        currentData += currentLine[i];
                    }
                }
                dvds.put(newDVD.getTitle(), newDVD);
            }
        } catch(Exception e){
            throw new DVDLibraryDaoException("Error loading from file.", e);
        }
        dvdLibrary = dvds;
    }

    public void saveDVDLibrary(String file) throws DVDLibraryDaoException, IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file + ".txt"));
        List<DVD> dvds = new ArrayList<>(dvdLibrary.values());
        try{
            for (DVD dvd : dvdLibrary.values()) {
                out.println(dvd.getTitle() + "::" + dvd.getDirector() + "::" + dvd.getStudio() + "::" + dvd.getMpaaRating() + "::" +
                        dvd.getReleaseDate().getDayOfMonth() + "/" + dvd.getReleaseDate().getMonthValue() + "/" + dvd.getReleaseDate().getYear() + "::" +
                        dvd.getUserRating().getRating() + "::" + dvd.getUserRating().getNote() + "::");
            }
        } catch(Exception e){
            throw new DVDLibraryDaoException("Error saving to file.", e);
        }
        out.flush();
        out.close();
    }

    public Map<String, DVD> getDvdLibrary() throws DVDLibraryDaoException {
        try {
            return dvdLibrary;
        }catch(Exception e){
            throw new DVDLibraryDaoException("Error retrieving DVD library.", e);
        }
    }

    public DVD getDVD(String title) throws DVDLibraryDaoException {
        try {
            return dvdLibrary.get(title);
        } catch(Exception e){
            throw new DVDLibraryDaoException("Error finding DVD.", e);
        }
    }

    public void addDVD(DVD dvd) throws DVDLibraryDaoException {
        try {
            if (dvdLibrary.get(dvd.getTitle()) == null) {
                dvdLibrary.put(dvd.getTitle(), dvd);
            } else {
                System.out.println("This dvd '" + dvd.getTitle() + "' already exists in the library.");
            }
        }catch(Exception e){
            throw new DVDLibraryDaoException("Error adding DVD.", e);
        }
    }

    public void removeDVD(String title) throws DVDLibraryDaoException {
        try {
            dvdLibrary.remove(title);
        }catch(Exception e){
            throw new DVDLibraryDaoException("Error removing DVD.", e);
        }
    }

    public void editDVD(String title, DVD dvd) throws DVDLibraryDaoException {
        try {
            dvdLibrary.replace(title, dvd);
        }catch(Exception e){
            throw new DVDLibraryDaoException("Error updating DVD.", e);
        }
    }
}
