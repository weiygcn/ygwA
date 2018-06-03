package com.ygw;

import core.ActionCode;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import rvo.RVO;

import java.io.IOException;
import java.util.List;

/**
 * 全局异常处理
 * Created by cc_want on 2018/6/2.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public RVO exceptionHandler(Exception ex) throws IOException {
        if (ex instanceof MethodArgumentNotValidException) {
            BindingResult result = ((MethodArgumentNotValidException) ex).getBindingResult();
            if (result.hasErrors()) {
                StringBuffer sb = new StringBuffer();
                printBindException(sb, result);
                return new RVO<>(ActionCode.VALID, sb.toString(), null);
            }
        }
        return new RVO<>(ActionCode.EXCEPTION);
    }

    public void printBindException(StringBuffer message, BindingResult result) {
        List<ObjectError> allErrors = result.getAllErrors();
        for (int i = 0; i < allErrors.size(); i++) {
            message.append(allErrors.get(i).getDefaultMessage());
            if (allErrors.size() > 1 && i < allErrors.size() - 1) {
                message.append(",");
            }
        }
    }
}