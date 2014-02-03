package ru.myshows.api;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author <a href="mailto:ivan.zaytsev@webamg.com">Ivan Zaytsev</a>
 *         2014-02-02
 */
final class Utils {
    private Utils() {
    }


    public static String md5(String s) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            md5.update(s.getBytes());

            MessageDigest mdEnc = MessageDigest.getInstance("MD5");
            mdEnc.update(s.getBytes(), 0, s.length());
            return String.format("%32s", new BigInteger(1, mdEnc.digest()).toString(16)).replace(' ', '0');
        } catch (NoSuchAlgorithmException e) {

            throw new IllegalStateException("Can't find MD5 algo! ", e);
        }
    }

}
