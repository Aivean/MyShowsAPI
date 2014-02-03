package ru.myshows.api;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.net.URI;

/**
 * @author <a href="mailto:ivan.zaytsev@webamg.com">Ivan Zaytsev</a>
 *         2014-02-03
 */
public class MyShowsHttpClientTest {


    @Test
    public void testHttpGet() throws Exception {


        URIBuilder builder = new URIBuilder();
        builder.setScheme("http")
                .setHost("api.myshows.ru")
                .setPath("/profile/login")
                .setParameter("login", "mylogin")
                .setParameter("password", "pas&s");


        System.out.println(builder.build());


    }
}
