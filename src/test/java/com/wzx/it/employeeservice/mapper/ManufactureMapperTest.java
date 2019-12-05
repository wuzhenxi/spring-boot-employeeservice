/*
 * Copyright(c) 2019, 武汉天喻软件股份有限公司
 */

package com.wzx.it.employeeservice.mapper;

import com.wzx.it.employeeservice.entity.ManufactureDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class ManufactureMapperTest {

    @Autowired private ManufactureMapper manufactureMapper;

    @Test
    public void testInsertManufacture(){
        ManufactureDO manufactureDO = new ManufactureDO();
        log.info("插入的数据为:{}",manufactureDO.toString());
        manufactureMapper.insert(manufactureDO);
    }

}