package com.miyou.utils;





import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public class RSAUtil {
    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    public static byte[] decryptBASE64(String key) {
        return Base64Util.decode(key);
    }

    public static String encryptBASE64(byte[] bytes) {
        return new String(Base64Util.encode(bytes));
    }

    /**
     * 用私钥对信息生成数字签名
     *
     * @param data
     *            加密数据
     * @param privateKey
     *            私钥
     * @return
     * @throws Exception
     */
    public static String sign(byte[] data, String privateKey) throws Exception {
        // 解密由base64编码的私钥
        byte[] keyBytes = decryptBASE64(privateKey);
        // 构造PKCS8EncodedKeySpec对象
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 取私钥匙对象
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 用私钥对信息生成数字签名
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(priKey);
        signature.update(data);
        return encryptBASE64(signature.sign());
    }

    /**
     * 校验数字签名
     *
     * @param data
     *            加密数据
     * @param publicKey
     *            公钥
     * @param sign
     *            数字签名
     * @return 校验成功返回true 失败返回false
     * @throws Exception
     */
    public static boolean verify(byte[] data, String publicKey, String sign)
            throws Exception {
        // 解密由base64编码的公钥
        byte[] keyBytes = decryptBASE64(publicKey);
        // 构造X509EncodedKeySpec对象
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 取公钥匙对象
        PublicKey pubKey = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(pubKey);
        signature.update(data);
        // 验证签名是否正常
        return signature.verify(decryptBASE64(sign));
    }

    public static byte[] decryptByPrivateKey(byte[] data, String key)
            throws Exception {
        // 对密钥解密
        byte[] keyBytes = decryptBASE64(key);
        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * 解密<br>
     * 用私钥解密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(String data, String key)
            throws Exception {
        return decryptByPrivateKey(decryptBASE64(data), key);
    }

    /**
     * 解密<br>
     * 用公钥解密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] data, String key)
            throws Exception {
        // 对密钥解密
        byte[] keyBytes = decryptBASE64(key);
        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);
        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 加密<br>
     * 用公钥加密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(String data, String key)
            throws Exception {
        // 对公钥解密
        byte[] keyBytes = decryptBASE64(key);
        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data.getBytes());
    }

    public static byte[] encryptByPublicKeyString(String data, String key) throws Exception {
        return Base64Util.encode(encryptByPublicKey(data,key));
    }

    /**
     * 加密<br>
     * 用私钥加密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, String key)
            throws Exception {
        // 对密钥解密
        byte[] keyBytes = decryptBASE64(key);
        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }



    /**
     * 初始化密钥
     *
     * @return
     * @throws Exception
     */
    public static Map<String, Key> initKey() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator
                .getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        Map<String, Key> keyMap = new HashMap(2);
        keyMap.put(PUBLIC_KEY, keyPair.getPublic());// 公钥
        keyMap.put(PRIVATE_KEY, keyPair.getPrivate());// 私钥
        return keyMap;
    }

    /*
     * <p>
     * 获取私钥
     * </p>
     *
     * @param keyMap 密钥对
     * @return
     * @throws Exception
     */
    public static byte[] getPrivateKey(Map<String, Object> keyMap)
            throws Exception {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        return Base64Util.encode(key.getEncoded());
    }

    /** *//**
     * <p>
     * 生成密钥对(公钥和私钥)
     * </p>
     *
     * @return
     * @throws Exception
     */
    public static Map<String, Object> genKeyPair() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(2048);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Object> keyMap = new HashMap<String, Object>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }

    /*
     * <p>
     * 获取公钥
     * </p>
     *
     * @param keyMap 密钥对
     * @return
     * @throws Exception
     */
    public static byte[] getPublicKey(Map<String, Object> keyMap)
            throws Exception {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        return Base64Util.encode(key.getEncoded());
    }


    public static void main(String[] args) throws Exception {
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCfiHzaD3pCvHBGBEH0RNakb8zykxRU/2urVHrBfu2kdtNXK39OVv8vjigVGS9Hz1HxlRSCiTiTzJbXSoEHnI9GhXiCp6v5dRsn+FGSuA3qYQtPeQfYuTDDOIVkzlOVUMP0XOD+NQxN9Mnc3Ob6zHZIP7bEs41qja7643t8uOTa2QIDAQAB";
        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJ+IfNoPekK8cEYEQfRE1qRvzPKTFFT/a6tUesF+7aR201crf05W/y+OKBUZL0fPUfGVFIKJOJPMltdKgQecj0aFeIKnq/l1Gyf4UZK4DephC095B9i5MMM4hWTOU5VQw/Rc4P41DE30ydzc5vrMdkg/tsSzjWqNrvrje3y45NrZAgMBAAECgYBpclfD8nMHZXJ4dRv7Dv0o11UKCTlpLSLHriEtgG4nRPtQJMoSx+IIVtgbiff8aQZqvfU+iuDAoHwbdX1vwIXaNHUZQF2bdw0TKODtEN3lEhvoVpDcKeikmanCYdtOotkvo45NgwRKg4oNpHrHFMhwg3yM9jpE5VrktG3ONBU7AQJBAODYEMMHmMqY9b/ckKEXriQHdcinA2ohovSvZRZBHmR+i6za1ArZU4OXYsSjym0nATdv5HLKcmuH5Ne0ayu20pECQQC1o6NNVbIcXP+uKulgTvQOZJQ8Ae37yRSMy8ZTUu/3WNxupoCtICoQcFhq7Q/3NK0AC01/I1PbAAiunN50xpfJAkEAl+GcQQIqtgBpUPc/Q3JpkbDwYWBgMBsUptCsKkJGs3+//j27qrBvd56Ve1tg7CbC7Z3J5bjXXcfoT8Vx94+B4QJAUghLUjvnqsOdfW1H5QUDWBS4lblRX6taqpPFSBBm69CoDRkJeCbUmIQEipXx5fVWRHTWVRsBXiDPyvxxw0+FcQJAVKrlLktLaMFAuM5xCaRf61bRO6oqLVJqsM5DKGGxvoeXIfpr4iWzer1TtXHe7mbrpRRAGGY4tXNDC3b+yjsB7w==";

        String inputStr = "inputStrinputStrinputStrinputStrinputStrinputStrinputStrinputStr777777777";
        byte[] data = inputStr.getBytes();

        byte[] encodedData = RSAUtil.encryptByPrivateKey(data, privateKey);
        System.out.println(RSAUtil.encryptByPublicKeyString(inputStr,publicKey));
//        byte[] decodedData = RSAUtil
//                .decryptByPrivateKey(Base64Util.decode("lqDXYUAymSNFK1KmZJkGXw2pUoE/NO+huKIPxp6CU2/xteB6SDnwWqYIfota3hTCHfyiuM2qH7qzYoOwFZLNN3W0PmU4uJtcBCcOtzwIigUIAzv/fjpl22FInezh9aZJYgO2NgQDeMJI12XDVYYoHpMrhrMkgpnihlLrtOuv7pY="),
//                        privateKey);
//        String outputStr = new String(decodedData);
//        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);
//
//        System.err.println("私钥签名——公钥验证签名");
//        // 产生签名
//        String sign = RSAUtil.sign(encodedData, privateKey);
//        System.err.println("签名:" + sign);
//        // 验证签名
//        boolean status = RSAUtil.verify(encodedData, publicKey, sign);
//        System.err.println("状态:" + status);
    }
}
