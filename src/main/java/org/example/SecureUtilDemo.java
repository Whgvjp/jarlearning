package org.example;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.digest.DigestUtil;

import java.security.KeyPair;
import java.util.Base64;

public class SecureUtilDemo {
    public static void main(String[] args) {
        String text = "Hello Hutool";

        // MD5/SHA 摘要
        String md5 = SecureUtil.md5(text);
        String sha256 = DigestUtil.sha256Hex(text);
        System.out.println("md5: " + md5);
        System.out.println("sha256: " + sha256);

        // AES 对称加密
        String aesKey = "1234567890abcdef"; // 16字节
        String aesEncrypted = SecureUtil.aes(aesKey.getBytes()).encryptHex(text);
        String aesDecrypted = SecureUtil.aes(aesKey.getBytes()).decryptStr(aesEncrypted);
        System.out.println("aes enc: " + aesEncrypted);
        System.out.println("aes dec: " + aesDecrypted);

        // RSA 非对称加密
        KeyPair pair = SecureUtil.generateKeyPair("RSA");
        RSA rsa = new RSA(pair.getPrivate(), pair.getPublic());
        byte[] enc = rsa.encrypt(text.getBytes(), KeyType.PublicKey);
        byte[] dec = rsa.decrypt(enc, KeyType.PrivateKey);
        System.out.println("rsa enc(b64): " + Base64.getEncoder().encodeToString(enc));
        System.out.println("rsa dec: " + new String(dec));
    }
}


