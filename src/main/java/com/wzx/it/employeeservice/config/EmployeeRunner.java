package com.wzx.it.employeeservice.config;

import com.wzx.it.employeeservice.cache.EmployeeCache;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
@Slf4j
public class EmployeeRunner implements ApplicationRunner {
//    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRunner.class);

    @Autowired
    private EmployeeCache employeeCache;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("employeeCache begin*****");
        employeeCache.syncEmployee();
        log.info("employeeCache end*****");
    }

}