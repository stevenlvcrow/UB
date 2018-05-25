package com.miyou;

import com.miyou.framework.BusinessConstant;
import com.miyou.framework.BusinessResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;


/**
　* @Description: contoller所有异常都抛向这里
　* @author lizhijie
　* @date 2018/2/7 14:04
　*/
@Slf4j
@ControllerAdvice
@ResponseStatus(value = HttpStatus.OK)
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * bean的验证异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object validExceptionHandler(MethodArgumentNotValidException e) {
        BusinessResponse errorRes = new BusinessResponse();
        try {
            List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
            if (!fieldErrors.isEmpty()) {
                errorRes.setErrCode(BusinessConstant.ERR_CODE.FATAL);
                errorRes.setErrInfo(fieldErrors.get(0).getDefaultMessage());
                return errorRes;
            }
        } catch (Exception e1) {
            log.error("{}" , e1);
        }
        return errorRes;
    }


    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(Exception e) {
        log.error("{}" , e);
        BusinessResponse errorRes = new BusinessResponse();
        errorRes.setErrCode(BusinessConstant.ERR_CODE.FATAL);
        errorRes.setErrInfo("系统内部错误");
        return errorRes;
    }

}
