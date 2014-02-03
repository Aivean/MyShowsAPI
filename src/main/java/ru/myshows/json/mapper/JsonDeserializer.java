package ru.myshows.json.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.myshows.api.BrokenApiException;
import ru.myshows.json.model.Episode;
import ru.myshows.json.model.Show;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:ivan.zaytsev@webamg.com">Ivan Zaytsev</a>
 *         2014-02-03
 */
public class JsonDeserializer {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public Map<Integer, Show> showsMap(String str) {
        try {
            return objectMapper.readValue(str, new TypeReference<Map<Integer, Show>>() {
            });
        } catch (IOException e) {
            throw new BrokenApiException("Can't deserialize Shows list", e);
        }
    }

    public Map<Integer, Episode> unwatchedEpisodesMap(String str){
        try {
            return objectMapper.readValue(str, new TypeReference<Map<Integer, Episode>>() {
            });
        } catch (IOException e) {
            throw new BrokenApiException("Can't deserialize unwatched Episodes list", e);
        }
    }


}
