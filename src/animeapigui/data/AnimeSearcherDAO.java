package animeapigui.data;

import animeapigui.controllers.Controller;
import animeapigui.models.Serie;
import animeapigui.views.View;
import org.json.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class AnimeSearcherDAO extends Controller {
    static List<Serie> searchResults;


public AnimeSearcherDAO(){
}

    public static String link = "https://api.jikan.moe/v4/anime";

    public static void requestSearch(String animeUnparsed){
        String anime = animeUnparsed.replaceAll("\\s+", "/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(link+"?q="+anime)).build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(AnimeSearcherDAO::parseSearch)
                .thenAccept(System.out::println)
                .join();

    }



    public static List<Serie> parseSearch(String responseBody){
        searchResults = new ArrayList<>();

        int id = 0;
        String title = "";
        String url = "";
        JSONArray titleArray = null;

        JSONObject response = new JSONObject(responseBody);

        JSONArray dataArray = response.getJSONArray("data");

        for (int i = 0; i < dataArray.length(); i++) {
            url = dataArray.getJSONObject(i).getString("url");
            id = dataArray.getJSONObject(i).getInt("mal_id");
            Serie anime = null;

            titleArray = dataArray.getJSONObject(i).getJSONArray("titles");

            title = titleArray.getJSONObject(0).getString("title");
            anime = new Serie(id,title,url);

            searchResults.add(anime);
        }
        return searchResults;
    }

    public List<Serie> getAll(){
        return searchResults;
    }

    @Override
    public View getView() {
        return null;
    }
}
