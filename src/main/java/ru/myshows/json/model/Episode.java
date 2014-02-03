package ru.myshows.json.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by squirrel on 2/3/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Episode {

    @JsonProperty("episodeId")
    private int id;

    @JsonProperty
    private String title;

    @JsonProperty
    private int showId;

    @JsonProperty
    private int seasonNumber;

    @JsonProperty
    private int episodeNumber;

    @JsonProperty
    private String airDate;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getShowId() {
        return showId;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public String getAirDate() {
        return airDate;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", showId='" + showId + '\'' +
                ", seasonNumber='" + seasonNumber + '\'' +
                ", episodeNumber='" + episodeNumber + '\'' +
                ", airDate='" + airDate  +
                '}';
    }
}
