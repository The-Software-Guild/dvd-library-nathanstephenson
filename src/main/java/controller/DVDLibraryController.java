package controller;

import dao.DVDLibraryDao;
import dao.DVDLibraryDaoException;
import ui.DVDLibraryView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DVDLibraryController {
    private DVDLibraryDao dao;
    private DVDLibraryView view;

    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() throws DVDLibraryDaoException, IOException {
        boolean cont = true;
        File f = new File("dvdlibrary.txt");
        if(f.exists()){
            dao.loadDVDLibrary("dvdlibrary");
        }
        do {
            switch (view.menu()) {
                case 1:
                    dao.addDVD(view.addDVD());
                    break;
                case 2:
                    String filmName = view.removeDVD();
                    dao.removeDVD(filmName);
                    System.out.println("Removed " + filmName);
                    break;
                case 3:
                    String title = view.editDVDGetTitle();
                    dao.editDVD(title, view.editDVD(title, dao.getDvdLibrary()));
                    break;
                case 4:
                    view.showLibrary(new ArrayList<>(dao.getDvdLibrary().values()));
                    break;
                case 5:
                    view.showDVD(dao.getDvdLibrary());
                    break;
                case 6:
                    dao.loadDVDLibrary(view.getFilename());
                    break;
                case 7:
                    dao.saveDVDLibrary(view.getFilename());
                    break;
                case 0:
                    System.out.println("Saving library...");
                    dao.saveDVDLibrary("dvdlibrary");
                    cont = false;
                    break;
            }
        } while (cont);
    }
}
