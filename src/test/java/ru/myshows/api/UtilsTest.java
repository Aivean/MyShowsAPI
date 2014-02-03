package ru.myshows.api;

import org.junit.Assert;
import org.junit.Test;
import ru.myshows.api.Utils;

/**
 * @author <a href="mailto:ivan.zaytsev@webamg.com">Ivan Zaytsev</a>
 *         2014-02-03
 */
public class UtilsTest {

    @Test
    public void testMd5() throws Exception {
        Assert.assertEquals("07d435de065bd04823cda69349553802", Utils.md5("test string Test blabla"));
    }
}
