package com.wzx.it.employeeservice.utils;

import java.security.KeyPair;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * RSAUtils Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>12/02/2019</pre>
 */
@Slf4j
public class RSAUtilsTest {

    private KeyPair keyPair;
    private String contentStr = "明文内容";
    private String privateKey;
    private String publicKey;

    @Before
    public void before() throws Exception {
        keyPair = RSAUtils.getKeyPair();
        privateKey = Base64.encodeBase64String(keyPair.getPrivate().getEncoded());
        publicKey = Base64.encodeBase64String(keyPair.getPublic().getEncoded());
    }

    /**
     * Method: getKeyPair()
     */
    @Test
    public void testGetKeyPair() throws Exception {
        log.info("随机生成的私钥：{}", privateKey);
        log.info("随机生成的公钥：{}", publicKey);
        Assert.assertNotNull(privateKey);
        Assert.assertNotNull(publicKey);
    }

    /**
     * Method: getMd5Sign(String content, PrivateKey privateKey)
     */
    @Test
    public void testGetMd5Sign() throws Exception {
        String md5Sign = RSAUtils.getMd5Sign(contentStr, keyPair.getPrivate());
        log.info("通过随机生成的私钥：{},铭文：{}，生成md5签名：{}",privateKey,contentStr,md5Sign);
        Assert.assertNotNull(md5Sign);
    }

    /**
     * Method: verifyWhenMd5Sign(String content, String sign, PublicKey publicKey)
     */
    @Test
    public void testVerifyWhenMd5Sign() throws Exception {
        String md5Sign = RSAUtils.getMd5Sign(contentStr, keyPair.getPrivate());
        Assert.assertTrue(RSAUtils.verifyWhenMd5Sign(contentStr, md5Sign, keyPair.getPublic()));
    }

    /**
     * Method: getSha1Sign(String content, PrivateKey privateKey)
     */
    @Test
    public void testGetSha1Sign() throws Exception {
        String sha1Sign = RSAUtils.getSha1Sign(contentStr, keyPair.getPrivate());
        log.info("通过随机生成的私钥：{},铭文：{}，生成sha1签名：{}",privateKey,contentStr,sha1Sign);
        Assert.assertNotNull(sha1Sign);
    }

    /**
     * Method: verifyWhenSha1Sign(String content, String sign, PublicKey publicKey)
     */
    @Test
    public void testVerifyWhenSha1Sign() throws Exception {
        String sha1Sign = RSAUtils.getSha1Sign(contentStr, keyPair.getPrivate());
        Assert.assertTrue(RSAUtils.verifyWhenSha1Sign(contentStr, sha1Sign, keyPair.getPublic()));
    }

    /**
     * Method: encrypt(String str, String publicKey)
     */
    @Test
    public void testEncrypt() throws Exception {
        String encryptStr = RSAUtils.encrypt(contentStr, publicKey);
        log.info("通过随机生成的公钥：{},铭文:{},加密后:{}",publicKey,contentStr,encryptStr);
        Assert.assertNotNull(encryptStr);
    }

    /**
     * Method: decrypt(String str, String privateKey)
     */
    @Test
    public void testDecrypt() throws Exception {
        String encryptStr = RSAUtils.encrypt(contentStr, publicKey);
        String decryptStr = RSAUtils.decrypt(encryptStr, privateKey);
        log.info("公钥：{}，加密铭文：{},后：{}",publicKey,contentStr,encryptStr);
        log.info("私钥：{}，解密密文：{}，后：{}",privateKey,encryptStr,decryptStr);
        Assert.assertEquals(contentStr,decryptStr);
    }


} 
