package ru.myshows.json.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author <a href="mailto:ivan.zaytsev@webamg.com">Ivan Zaytsev</a>
 *         2014-02-03
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Show {
    @JsonProperty("showId")
    private int id;

    @JsonProperty
    private String title;

    @JsonProperty
    private String ruTitle;

    @JsonProperty
    private String showStatus;

    @JsonProperty
    private String watchStatus;

    @JsonProperty
    private String image;

    @JsonProperty
    private int watchedEpisodes;

    @JsonProperty
    private int totalEpisodes;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getRuTitle() {
        return ruTitle;
    }

    public String getShowStatus() {
        return showStatus;
    }

    public String getWatchStatus() {
        return watchStatus;
    }

    public String getImage() {
        return image;
    }

    public int getWatchedEpisodes() {
        return watchedEpisodes;
    }

    public int getTotalEpisodes() {
        return totalEpisodes;
    }


    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", ruTitle='" + ruTitle + '\'' +
                ", showStatus='" + showStatus + '\'' +
                ", watchStatus='" + watchStatus + '\'' +
                ", image='" + image + '\'' +
                ", watchedEpisodes=" + watchedEpisodes +
                ", totalEpisodes=" + totalEpisodes +
                '}';
    }
}
