package com.huan.exception;

import com.huan.vo.ApiResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

import static com.huan.enums.MsgCommonEnum.E0001;
import static com.huan.vo.ApiResult.error;

/**
 * @Author YueDong Huan
 * @Date 2021/5/20
 * @Email huanyued@163.com
 */
@RestControllerAdvice
public class SysExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResult handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        String errorMsg = exception.getBindingResult().getFieldErrors().stream()
                .map(errorInfo -> errorInfo.getField() + errorInfo.getDefaultMessage()).collect(Collectors.joining(","));
        ApiResult error = error(E0001, errorMsg);
        //log.error(errorMsg);
        return error;
    }

}
