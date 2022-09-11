package animeapigui.views;

import animeapigui.models.Serie;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SearchView extends View{

    private TextField searchField;
    private Button searchButton;
    public ListView<Serie> animes;

    @Override
    protected void initializeView() {
        HBox outerBox = new HBox();
        outerBox.setAlignment(Pos.CENTER);

        VBox innerBox = new VBox();

        searchField = new TextField("Please type the anime name");
        searchButton = new Button("Search");

        animes = new ListView<>();

        outerBox.getChildren().add(innerBox);
        innerBox.getChildren().addAll(searchField, searchButton,animes);

        root = outerBox;
    }

    public TextField getSearchField() {
        return searchField;
    }

    public Button getSearchButton() {
        return searchButton;
    }

    public ListView<Serie> getAnimes() {
        return animes;
    }
}
