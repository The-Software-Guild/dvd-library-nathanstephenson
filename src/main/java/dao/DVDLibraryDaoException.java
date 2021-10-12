package dao;

public class DVDLibraryDaoException extends Exception {
    public DVDLibraryDaoException(String errMessage) {
        super(errMessage);
    }

    public DVDLibraryDaoException(String errMessage, Throwable err) {
        super(errMessage, err);
    }
}
