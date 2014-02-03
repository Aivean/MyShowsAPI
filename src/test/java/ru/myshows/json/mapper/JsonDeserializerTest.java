package ru.myshows.json.mapper;

import org.junit.Test;
import ru.myshows.json.model.Show;

import java.util.Map;

/**
 * @author <a href="mailto:ivan.zaytsev@webamg.com">Ivan Zaytsev</a>
 *         2014-02-03
 */
public class JsonDeserializerTest {


    @Test
    public void testDeserializeShowsList() throws Exception {

        String shows = "{\"14\":{\"showId\":14,\"title\":\"Prison Break\"," +
                "\"ruTitle\":\"\\u041f\\u043e\\u0431\\u0435\\u0433\",\"runtime\":43," +
                "\"showStatus\":\"Canceled\\/Ended\",\"watchStatus\":\"watching\"," +
                "\"watchedEpisodes\":76,\"totalEpisodes\":79,\"rating\":4,\"image\":" +
                "\"http:\\/\\/images.tvrage.com\\/shows\\/5\\/4895.jpg\"}," +
                "\"4\":{\"showId\":4,\"title\":\"24\",\"ruTitle\":\"24 \\u0447\\u0430\\u0441\\u0430\"," +
                "\"runtime\":43,\"showStatus\":\"Returning Series\",\"watchStatus\":\"cancelled\"," +
                "\"watchedEpisodes\":191,\"totalEpisodes\":192,\"rating\":5," +
                "\"image\":\"http:\\/\\/images.tvrage.com\\/shows\\/3\\/2445.jpg\"}}";


        Map<Integer, Show> stringShowMap = new JsonDeserializer().showsMap(shows);

        System.out.println(stringShowMap);

    }
}
