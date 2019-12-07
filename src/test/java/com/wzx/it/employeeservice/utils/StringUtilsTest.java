package com.wzx.it.employeeservice.utils;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * StringUtils Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>05/24/2019</pre>
 */
@Slf4j
public class StringUtilsTest {

    @Test
    public void testStr() {
        StringBuffer enSb = new StringBuffer();
        StringBuffer zhSb = new StringBuffer();
        String enStr = "|";
        String zhStr = "｜";
        log.info("英文getBytes:{}",enStr.getBytes());
        log.info("中文getBytes:{}",zhStr.getBytes());

        char[] chars = enStr.toCharArray();
        for (char aChar : chars) {
            enSb.append("\\u").append(Integer.toHexString(aChar));
        }
        log.info("英文转Hex:{}",enSb.toString());
        char[] chars1 = zhStr.toCharArray();
        for (char aChar1 : chars1) {
            zhSb.append("\\u").append(Integer.toHexString(aChar1));
        }
        log.info("中文转Hex:{}",zhSb.toString());
    }

    @Test
    public void testSplitStr(){
        String valueNumber = "12.78";
        String dottStr = ".";
        String escapeDottStr = "\\.";

        log.info("【"+valueNumber+"】直接用【.】切割后的值为:{}", Arrays.asList(valueNumber.split(dottStr)));
        log.info("【"+valueNumber+"】用转义【.】切割后的值为:{}", Arrays.asList(valueNumber.split(escapeDottStr)));

        String valueStr = "我|你";
        String versusStr = "|";
        String escapeVersusStr = "\\|";

        log.info("【"+valueStr+"】直接用【|】切割后的值为:{}", Arrays.asList(valueStr.split(versusStr)));
        log.info("【"+valueStr+"】用转义【|】切割后的值为:{}", Arrays.asList(valueStr.split(escapeVersusStr)));

    }

}
