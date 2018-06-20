package com.miyou.framework;

import com.alibaba.fastjson.JSON;
import com.miyou.constant.BusinessConstant;
import com.miyou.domain.BusinessContext;
import com.miyou.domain.BusinessRequest;
import com.miyou.domain.BusinessResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Set;

/**
* @Author: lizhijie
* @Description: 服务调用接口
* @Date: Created in 16:43 2018/5/25
*/
@Slf4j
@Component
public class ProcessService {

    private Validator validator;

    public ProcessService() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public BusinessResponse jsonProcess(String actionType, String reqInStr, HttpServletRequest request) {
        BusinessResponse businessResponse;
        BusinessContext context = new BusinessContext();
        try {
            BusinessService service = ServiceRegistry.getService(actionType);
            log.info("-------> {}", service.getName());
            BusinessRequest reqIn = JSON.parseObject(reqInStr, service.getBusinessRequest().getClass());
            String token = request.getHeader("token");
            if(StringUtils.isEmpty(token)){
                throw new BusinessException(BusinessConstant.ERR_CODE.FATAL,"非法请求");
            }
            reqIn.setToken(token);
            reqIn.setPrivateKey((String) request.getSession().getAttribute("privateKey"));
            reqIn.setSession(request.getSession());
            reqIn.setRequestStr(reqInStr);
            HttpSession session = request.getSession();
            if(session.getAttribute("userInfo") == null){
                throw new BusinessException(BusinessConstant.ERR_CODE.FATAL,"请求超时,请重新登录");
            }
            ArrayList<String> tokenes = (ArrayList<String>) session.getAttribute("tokenes");
            if(tokenes==null){
                tokenes = new ArrayList<>();
            }
            //检验token是否重复
            if(tokenes.contains(token)){
                throw new BusinessException(BusinessConstant.ERR_CODE.FATAL, "重复的请求: ");
            }
            // 检查输入值是否合法
            Set violations = validator.validate(reqIn);
            if (violations.size() > 0) {
                StringBuilder buf = new StringBuilder();
                for (Object v : violations) {
                    ConstraintViolation cv = (ConstraintViolation) v;
                    buf.append(cv.getPropertyPath());
                    buf.append(" ");
                    buf.append(cv.getMessage());
                    buf.append(", ");
                }
                throw new BusinessException(BusinessConstant.ERR_CODE.FATAL, "参数不合法: " + buf.toString());
            }

            context.setBusinessRequestStr(reqInStr);
            context.setBusinessRequest(reqIn);
            context.setServiceAcceptTime(System.currentTimeMillis());
            //处理业务请求
            service.process(context);
            //返回响应报文
            // resInStr = JSON.toJSONString(context.getBusinessResponse());
            businessResponse = context.getBusinessResponse();

            /*tokenes.add(token);
            session.setAttribute("tokenes",tokenes);*/
        } catch (Throwable e) {
            log.error("", e);
            String resultCode = BusinessConstant.ERR_CODE.FATAL;
            String resultMsg = "系统内部错误";
            if (e instanceof BusinessException) {
                resultCode = ((BusinessException) e).getErrCode();
                resultMsg = ((BusinessException) e).getErrInfo();
            }
            businessResponse = new BusinessResponse();
            businessResponse.setErrCode(resultCode);
            businessResponse.setErrInfo(resultMsg);
            //resInStr = JSON.toJSONString(businessResponse);
        }
        long cost = System.currentTimeMillis() - context.getServiceAcceptTime();
        log.info("完成请求, 耗时: {}, 返回报文: \r\n{}", cost, JSON.toJSONString(businessResponse));
        return businessResponse;
    }

}
