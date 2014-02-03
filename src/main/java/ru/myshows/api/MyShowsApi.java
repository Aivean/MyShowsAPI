package ru.myshows.api;

import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;
import ru.myshows.json.mapper.JsonDeserializer;
import ru.myshows.json.model.Show;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * @author <a href="mailto:ivan.zaytsev@webamg.com">Ivan Zaytsev</a>
 *         2014-02-03
 */
public class MyShowsApi {
    private static final Logger logger = Logger.getLogger(MyShowsApi.class);
    private static final int NTRIES = 3;


    private String user;
    private String passwordMd5;
    private MyShowsHttpClient client = new MyShowsHttpClient();
    private final JsonDeserializer deserializer = new JsonDeserializer();

    public MyShowsApi(String user, String passwordMd5) {
        this.user = user;
        this.passwordMd5 = passwordMd5;
    }


    public Map<Integer, Show> getShows() {
        return deserializer.showsMap(get(buildRequest("/profile/shows/")));
    }

    String get(String url) {
        logger.info("Requesting " + url);
        for (int tryN = 0; tryN < NTRIES; tryN++) {
            try {
                return client.get(url);
            } catch (MyShowsHttpClient.HttpCodeException e) {
                logger.info("Got HTTP error code: " + e.getCode() + " on try: " + tryN);
                switch (e.getCode()) {
                    case 401:
                        logger.info("Authentication required, on try: " + tryN);
                        authorize();
                        break;
                    case 403:
                        throw new ForbiddenCode403();
                    case 404:
                        throw new NotFoundCode404();
                    default:
                        throw new BrokenApiException("Unexpected return code: " + e.getCode() + "  on try: " + tryN);
                }
            } catch (IOException e) {
                logger.warn("Something wrong with the connection on try: " + tryN, e);
            }
        }
        throw new IllegalStateException("Number of tries exceeded limit: " + NTRIES);
    }

    private String buildRequest(String path, String... params) {
        if (params.length % 2 != 0) {
            throw new IllegalArgumentException("Wrong number of params and values provided "
                    + Arrays.toString(params));
        }

        URIBuilder builder = new URIBuilder();
        builder.setScheme("http")
                .setHost("api.myshows.ru")
                .setPath(path);

        for (int i = 0; i < params.length; i += 2) {
            builder.addParameter(params[i], params[i + 1]);
        }
        return builder.toString();
    }


    private void authorize() {
        try {
            get(buildRequest("/profile/login", "login", user, "password", passwordMd5));
        } catch (ForbiddenCode403 e) {
            throw new IllegalArgumentException("Wrong username or password");
        } catch (Exception e) {
            throw new BrokenApiException("Can't authorize", e);
        }
    }

    public static class NotFoundCode404 extends RuntimeException {
    }

    public static class ForbiddenCode403 extends RuntimeException {
    }

}

