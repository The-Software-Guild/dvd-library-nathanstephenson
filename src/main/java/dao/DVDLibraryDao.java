package dao;

import dto.DVD;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public interface DVDLibraryDao {
    void loadDVDLibrary(String file) throws DVDLibraryDaoException, FileNotFoundException;

    void saveDVDLibrary(String file) throws DVDLibraryDaoException, IOException;

    Map<String, DVD> getDvdLibrary() throws DVDLibraryDaoException;

    DVD getDVD(String title) throws DVDLibraryDaoException;

    void addDVD(DVD dvd) throws DVDLibraryDaoException;

    void removeDVD(String title) throws DVDLibraryDaoException;

    void editDVD(String title, DVD dvd) throws DVDLibraryDaoException;
}
