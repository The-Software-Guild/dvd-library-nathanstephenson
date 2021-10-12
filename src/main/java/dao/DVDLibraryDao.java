package dao;

import dto.DVD;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface DVDLibraryDao {
    Map<String, DVD> loadDVDLibrary(String file) throws DVDLibraryDaoException, FileNotFoundException;

    void saveDVDLibrary(List<DVD> DVDLibrary, String file) throws DVDLibraryDaoException, IOException;

    List<DVD> getDvdLibrary() throws DVDLibraryDaoException;

    DVD getDVD(String title) throws DVDLibraryDaoException;

    void addDVD(DVD dvd) throws DVDLibraryDaoException;

    void removeDVD(String title) throws DVDLibraryDaoException;

    void editDVD(String title, DVD dvd) throws DVDLibraryDaoException;
}
