package animeapigui;

import animeapigui.controllers.AnimeSearcher;
import animeapigui.controllers.Controller;
import animeapigui.controllers.SearchController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

    private static int WIDTH = 640;
    private static int HEIGHT = 480;
    private static String TITLE = String.format("OAP");
    public static Stage stage;

    @Override
    public void start(Stage stage) {
        if (!Main.launchedFromMain){
            System.out.println("je vader start via main");
            System.exit(1337);

            return;
        }

        MainApplication.stage = stage;

        switchController(new SearchController());
        stage.setTitle(TITLE);
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);

    }



    public static void switchController(Controller controller){
        if (stage.getScene()!= null){
            stage.getScene().setRoot(controller.getView().getRoot());
        } else {
            stage.setScene(new Scene(controller.getView().getRoot()));
        }

        stage.show();
    }
}
