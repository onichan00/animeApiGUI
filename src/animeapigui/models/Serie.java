package animeapigui.models;

import java.io.Serializable;

public class Serie implements Serializable {

    protected int mal_id;
    protected String defaultTitel;
    protected String url;

    public Serie(int mal_id, String defaultTitel, String url){
        this.mal_id = mal_id;
        this .defaultTitel = defaultTitel;
        this.url = url;
    }

    public int getMal_id() {
        return mal_id;
    }

    public String getDefaultTitel() {
        return defaultTitel;
    }

    public String getUrl() {
        return url;
    }

    public void setMal_id(int mal_id) {
        this.mal_id = mal_id;
    }

    public void setDefaultTitel(String defaultTitel) {
        this.defaultTitel = defaultTitel;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "mal_id=" + mal_id +
                ", Titel='" + defaultTitel;
    }
}
