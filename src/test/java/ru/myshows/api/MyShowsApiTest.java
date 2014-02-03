package ru.myshows.api;

import org.junit.Test;
import ru.myshows.api.MyShowsApi;

/**
 * @author <a href="mailto:ivan.zaytsev@webamg.com">Ivan Zaytsev</a>
 *         2014-02-03
 */
public class MyShowsApiTest {

    @Test
    public void testSimpleRequest() throws Exception {
        MyShowsApi myShowsApi = new MyShowsApi("demo", "fe01ce2a7fbac8fafaed7c982a04e229");
        System.out.println(myShowsApi.get("http://api.myshows.ru/profile/"));
    }

    @Test
    public void testGetShows() throws Exception {
        MyShowsApi myShowsApi = new MyShowsApi("demo", "fe01ce2a7fbac8fafaed7c982a04e229");
        System.out.println(myShowsApi.getShows());
    }

    @Test
    public void testGetUnwatchedEpisodes() throws Exception {
        MyShowsApi myShowsApi = new MyShowsApi("demo", "fe01ce2a7fbac8fafaed7c982a04e229");
        System.out.println(myShowsApi.getUnwatchedEpisodes());
    }
}
