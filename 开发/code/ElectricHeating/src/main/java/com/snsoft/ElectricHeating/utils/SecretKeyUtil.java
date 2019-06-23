package com.snsoft.ElectricHeating.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;

/**
 * @author 16计算机 Moriaty
 * @version 1.0
 * @copyright ：Moriaty 版权所有 © 2019
 * @date 2019/6/17 21:25
 * @Description TODO
 * RSA 密钥生成工具
 */
public class SecretKeyUtil {
    // 公钥
    public static final Integer PUBLIC_KEY = 0;
    // 私钥
    public static final Integer PRIVATE_KEY = 1;

    /**
     * 生成公钥私钥 HashMap
     *
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static HashMap<Integer, String> genKeyPair() throws NoSuchAlgorithmException {

        HashMap<Integer, String> keyMap = new HashMap<Integer, String>();

        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为96-1024位
        keyPairGen.initialize(1024, new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        // 使用 Base64 加密公钥私钥,并存储到 keyMap 中
        String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
        String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
        keyMap.put(PUBLIC_KEY, publicKeyString);
        keyMap.put(PRIVATE_KEY, privateKeyString);

        return keyMap;
    }

    /**
     * RSA 公钥加密
     *
     * @param str
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static String encrypt(String str, String publicKey) throws Exception {
        // Base64 解码公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        // RSA 加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

    public static String decrypt(String str, String privateKey) throws Exception {
        // Base64 解码加密字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        // Base64 解码私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }

}
