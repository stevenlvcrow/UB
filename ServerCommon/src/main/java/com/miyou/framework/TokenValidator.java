package com.miyou.framework;

import com.miyou.utils.Base64Utils;
import com.miyou.utils.RSAUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.binary.Hex;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.security.MessageDigest;
import java.util.Map;

/**
* @Author: lizhijie
* @Description: 验签的实现类
* @Date: Created in 17:32 2018/5/15
*/
@Slf4j
public class TokenValidator  implements ConstraintValidator<TokenVerify, Object> {

    @Override
    public void initialize(TokenVerify tokenVerify) {}

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        try {

            Map map = BeanUtils.describe(o);
            String tokenStr = (String) map.get("token");
            String privateKey = (String) map.get("privateKey");
            String requestStr = (String) map.get("requestStr");

            //将请求参数进行 SHA256
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(requestStr.getBytes("UTF-8"));
            String encdeStr = Hex.encodeHexString(hash);

            // 对token进行解密
            byte[] decodedData = RSAUtil.decryptByPrivateKey(Base64Utils.decode(tokenStr),privateKey);
            String deTxt = new String(decodedData);
            deTxt = deTxt.replaceAll("#asso#","");
            if(!deTxt.equals(encdeStr)){
                throw new Exception("验签失败");
            }

        } catch (Exception e) {
            log.error("未知的错误:{}",e);
            return false;
        }

        return true;
    }



}
