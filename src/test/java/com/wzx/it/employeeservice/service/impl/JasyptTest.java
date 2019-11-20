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
        LOGGER.info("[UzJiRDqZ8AVPzr08POUBag==]解密:{}", stringEncryptor.decrypt("UzJiRDqZ8AVPzr08POUBag=="));
        LOGGER.info("[sB1g3NU9zHHUh8o/1E2zgg==]解密:{}", stringEncryptor.decrypt("sB1g3NU9zHHUh8o/1E2zgg=="));
        LOGGER.info("[8imjgIFnmC4ekx3UC+mDseak5js9PX2g]解密:{}", stringEncryptor.decrypt("8imjgIFnmC4ekx3UC+mDseak5js9PX2g"));
        LOGGER.info("[sHhjUbTUtWPHUSe7jyBDdQ==]解密:{}", stringEncryptor.decrypt("sHhjUbTUtWPHUSe7jyBDdQ=="));
        LOGGER.info("[SeK2Ye6rfGCrsepfi1gEFl0xVh0MQMHV]解密:{}", stringEncryptor.decrypt("SeK2Ye6rfGCrsepfi1gEFl0xVh0MQMHV"));
    }

    @Test
    public void encryptUser() {
        LOGGER.info("[root]>>>加密>>>:{}",stringEncryptor.encrypt("root"));
        LOGGER.info("[admin]>>>加密>>>:{}",stringEncryptor.encrypt("admin"));
        LOGGER.info("[huawei123@]>>>加密>>>:{}",stringEncryptor.encrypt("huawei123@"));
        LOGGER.info("[test]>>>加密>>>:{}",stringEncryptor.encrypt("test"));
        LOGGER.info("[19941005zsh@]>>>加密>>>:{}",stringEncryptor.encrypt("19941005zsh@"));
    }

}
