package com.wzx.it.employeeservice;

import java.math.BigDecimal;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
public class EmployeeserviceApplicationTests {

    @Test
    public void testMain() throws Exception {

        ThreadFactory threadFactory1 = Executors.defaultThreadFactory();

        ThreadFactory threadFactory = r -> new Thread(r, "my-thread-" + new AtomicInteger(1).getAndIncrement());

        RejectedExecutionHandler handler = (runnable, executor) -> log.error("ThreadPool is full");

        // 直接提交队列
        new SynchronousQueue<>();
        // 无边际队列
        new LinkedBlockingQueue<>();
        // 有边界队列
        new ArrayBlockingQueue<>(10);
        // 优先任务队列
        new PriorityBlockingQueue<>();


        // 拒绝策略
        /**
         * 1、AbortPolicy策略：该策略会直接抛出异常，阻止系统正常工作；
         *
         * 2、CallerRunsPolicy策略：如果线程池的线程数量达到上限，该策略会把任务队列中的任务放在调用者线程当中运行；
         *
         * 3、DiscardOledestPolicy策略：该策略会丢弃任务队列中最老的一个任务，也就是当前任务队列中最先被添加进去的，马上要被执行的那个任务，并尝试再次提交；
         *
         * 4、DiscardPolicy策略：该策略会默默丢弃无法处理的任务，不予任何处理。当然使用此策略，业务场景中需允许任务的丢失；
         */
        new ThreadPoolExecutor.AbortPolicy();

        new ThreadPoolExecutor.CallerRunsPolicy();

        new ThreadPoolExecutor.DiscardOldestPolicy();

        new ThreadPoolExecutor.DiscardPolicy();


        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 200, 1, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(200),
                threadFactory1, handler);
        int i1 = executor.prestartAllCoreThreads();
        log.info("线程池个数:{}", i1);

        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executor.execute(() -> log.info("Thread" + finalI));
        }
    }

    @Test
    public void testBigdecimal(){
        BigDecimal num1 = new BigDecimal(Double.toString(12145452.1));
        BigDecimal num2 = new BigDecimal(Double.toString(0.2));
        BigDecimal result = num1.multiply(num2);
        log.info("计算结果为:{}",result.toPlainString());

    }
}
