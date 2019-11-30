package com.wzx.it.employeeservice.utils;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import tk.mybatis.mapper.genid.GenId;

@Slf4j
public class GenUUIDUtils implements GenId {

    @Override
    public String genId(String s, String s1) {
        log.info("表名:{},列名:{}",s,s1);
        return UUID.randomUUID().toString();
    }
}
