package animeapigui.controllers;

import animeapigui.data.AnimeSearcherDAO;
import animeapigui.models.Serie;
import animeapigui.views.SearchView;
import animeapigui.views.View;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class SearchController extends Controller{
    private SearchView view;
    public Serie animeList;
    public List<Serie> anime;
    public ObservableList<Serie> observableList;
    public AnimeSearcherDAO animeSearcher;

    public SearchController(){
         animeSearcher = new AnimeSearcherDAO();

        view = new SearchView();



        view.getSearchButton().setOnAction(event -> {
            handleSearchKnop();
        });

    }

    private void handleSearchKnop(){
        AnimeSearcherDAO.requestSearch(view.getSearchField().getText());

        anime = animeSearcher.getAll();
        observableList = FXCollections.observableArrayList(anime);
        view.getAnimes().setItems(observableList);

    }



    @Override
    public View getView() {
        return view;
    }
}
