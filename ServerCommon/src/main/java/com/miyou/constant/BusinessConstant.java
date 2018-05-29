package com.miyou.constant;

import java.nio.charset.Charset;

public class BusinessConstant {

    public static class ERR_CODE {
        public static final String NORMAL = "0000";
        public static final String AUTHENTICATION_FAILED = "1000";
        public static final String AUTHORIZATION_FAILED = "1001";
        public static final String ILLEGAL_CALL = "9000";
        public static final String ILLEGAL_PARAMETER = "9001";
        public static final String FATAL = "9999";
    }
    public static class ERR_INFO {
        public static final String NORMAL = "正常";
        public static final String AUTHENTICATION_FAILED = "认证失败";
        public static final String AUTHORIZATION_FAILED = "授权失败";
        public static final String ILLEGAL_CALL = "非法访问";
        public static final String ILLEGAL_PARAMETER = "请求参数校验失败";
        public static final String FATAL = "系统错误";
    }
    public static class ATTRIBUTE {
        public static final String APP = BusinessConstant.class.getName() + ".APP";
        public static final String APPLY_SERVICE_ATTRIBUTES = BusinessConstant.class.getName() + ".APPLY_SERVICE_ATTRIBUTES";
        public static final String SESSION = BusinessConstant.class.getName() + ".SESSION";
        public static final String SERVICE_CODE = BusinessConstant.class.getName() + ".SERVICE_CODE";
    }
    public static class HEADER {
        public static final String AUTHORIZATION = "Authorization";
        public static final String VERSION = "X-Version";
        public static final String FORWARDED_FOR = "X-Forwarded-For";
    }
    public static Charset DEFAULT_ENCODING_CHARSET = Charset.forName("UTF-8");
}
