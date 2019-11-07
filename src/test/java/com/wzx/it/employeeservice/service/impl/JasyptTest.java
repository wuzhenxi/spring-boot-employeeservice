package com.wzx.it.employeeservice.service.impl;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JasyptTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(JasyptTest.class);

    @Autowired
    StringEncryptor stringEncryptor;

    @Test
    public void decrypter() {
        LOGGER.info("[123qwe!@#]加密后={}", stringEncryptor.encrypt("123qwe!@#"));
        LOGGER.info("[N9u4tCSDFD5Fut29MTVprOQGn86puiiL]解密后={}", stringEncryptor.decrypt("N9u4tCSDFD5Fut29MTVprOQGn86puiiL"));
    }

    @Test
    public void encryptUser() {
        String encrypt = stringEncryptor.encrypt("root");
        LOGGER.info("root>>>加密>>>"+encrypt);
    }

    @Test
    public void encryptPwd() {
        String encrypt = stringEncryptor.encrypt("huawei123@");
        LOGGER.info("huawei123@@>>>加密>>>"+encrypt);
    }

    @Test
    public void encryptName() {
        String encrypt = stringEncryptor.encrypt("test");
        LOGGER.info("test>>>加密>>>"+encrypt);
    }

    @Test
    public void encryptPwd2() {
        String encrypt = stringEncryptor.encrypt("19941005zsh@");
        LOGGER.info("19941005zsh@>>>加密>>>" + encrypt);
    }

    @Test
    public void decryptUser() {
        String decrypt = stringEncryptor.decrypt("jj4q/7QzsIX8UCXKAcy9Aw==");
        LOGGER.info("解密user："+decrypt);
    }

    @Test
    public void decryptPwd() {
        String decrypt = stringEncryptor.decrypt("4JHTKIGy5dkPq3/cjqFTI2mnbmB++aMI");
        LOGGER.info("解密pwd："+decrypt);
    }

}
