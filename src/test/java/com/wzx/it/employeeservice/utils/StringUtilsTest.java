package com.wzx.it.employeeservice.utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * StringUtils Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>05/24/2019</pre>
 */
public class StringUtilsTest {

    @Before
    public void before() throws Exception {
        StringUtils stringUtils = new StringUtils();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getRandomStr(Integer len)
     */
    @Test
    public void testGetRandomStr() throws Exception {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(()-> System.out.println(Thread.currentThread().getName()));
        singleThreadPool.shutdown();
    }


} 
