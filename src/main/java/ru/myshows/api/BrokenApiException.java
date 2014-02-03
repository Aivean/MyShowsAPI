package ru.myshows.api;

/**
 * @author <a href="mailto:ivan.zaytsev@webamg.com">Ivan Zaytsev</a>
 *         2014-02-03
 */
public class BrokenApiException extends RuntimeException {

    public BrokenApiException() {
    }

    public BrokenApiException(String message) {
        super(message);
    }

    public BrokenApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public BrokenApiException(Throwable cause) {
        super(cause);
    }
}
