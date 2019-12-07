/*
 * Copyright(c) 2019, 武汉天喻软件股份有限公司
 */

package com.wzx.it.employeeservice.domain;

import static org.junit.Assert.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class PartInfoRepositoryTest {

    @Autowired private PartInfoRepository partInfoRepository;

    @Test
    public void testSavePartInfo(){
        PartInfo partInfo = new PartInfo();
        PartInfo saveInfo = partInfoRepository.save(partInfo);
        log.info("保存的part数据为:{}",saveInfo.toString());
    }

}