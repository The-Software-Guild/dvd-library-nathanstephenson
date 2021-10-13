import controller.DVDLibraryController;

import dao.DVDLibraryDaoException;
import dao.DVDLibraryDaoImpl;
import ui.DVDLibraryView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) throws DVDLibraryDaoException {
        UserIO io = new UserIOConsoleImpl();
        DVDLibraryView view = new DVDLibraryView(io);
        DVDLibraryController controller = new DVDLibraryController(new DVDLibraryDaoImpl(), view);

        try {
            controller.run();
        } catch (Exception e) {
            throw new DVDLibraryDaoException("There was an error.", e);
        }
    }
}
