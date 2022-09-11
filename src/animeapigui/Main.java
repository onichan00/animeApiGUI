package animeapigui;

import javafx.application.Application;

public class Main {
    static boolean launchedFromMain = true;

    public static void main(String[] args) {

        launchedFromMain = true;

        Application.launch(MainApplication.class, args);

    }
}
