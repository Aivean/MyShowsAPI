package ru.myshows.api;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * @author <a href="mailto:ivan.zaytsev@webamg.com">Ivan Zaytsev</a>
 *         2014-02-02
 */
class MyShowsHttpClient {

    private static final Logger logger = Logger.getLogger(MyShowsHttpClient.class);
    private final CookieStore cookieStore = new BasicCookieStore();
    private final HttpClient httpClient = HttpClients.custom()
            .setDefaultCookieStore(cookieStore)
            .build();

    public String get(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse response = httpClient.execute(httpGet);

            StatusLine status = response.getStatusLine();
            if (status.getStatusCode() == 200) {
                return EntityUtils.toString(response.getEntity());
            } else {
                throw new HttpCodeException(status.getStatusCode());
            }
        } finally {
            httpGet.releaseConnection();
        }
    }

    static class HttpCodeException extends RuntimeException {
        private int code;

        private HttpCodeException(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }
}
