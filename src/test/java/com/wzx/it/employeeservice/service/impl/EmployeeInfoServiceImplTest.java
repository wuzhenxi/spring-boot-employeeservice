package com.wzx.it.employeeservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.wzx.it.employeeservice.domain.EmployeeInfo;
import com.wzx.it.employeeservice.domain.EmployeeInfoRepository;
import com.wzx.it.employeeservice.utils.ReadTestProperties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * EmployeeInfoServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>04/14/2019</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmployeeInfoServiceImplTest {

    @Autowired
    private ReadTestProperties readTestProperties;

    @Autowired
    private EmployeeInfoRepository employeeInfoRepository;

    @Autowired
    private EmployeeInfoServiceImpl employeeInfoService;

    private EmployeeInfo employeeInfo;

    @Before
    public void before() throws Exception {
        employeeInfo = employeeInfoRepository.save(get("emp_save_data01", EmployeeInfo.class));
    }

    @After
    public void after() throws Exception {
        employeeInfoRepository.deleteAll();
    }

    /**
     * Method: getEmpInfos()
     */
    @Test
    public void testGetEmpInfos() throws Exception {
        List<EmployeeInfo> empInfos = employeeInfoService.getEmpInfos();
        assertEquals(1, empInfos.size());
        assertEquals(employeeInfo.getName(),empInfos.get(0).getName());
    }

    private <T> T get(String key, Class<T> clazz) {
        String result = readTestProperties.getPropertiesForKey(key);
        return JSON.parseObject(result, clazz);
    }
    // git

} 
