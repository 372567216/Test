package com.example.demo.config;

import com.example.demo.config.entity.ResultEntity;
import com.example.demo.exception.AlertException;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class NextGlobalExceptionHandler {
    private static final Logger log = Logger.getLogger(NextGlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ResultEntity handleException(Exception e) {
        log.error("系统内部异常，异常信息", e);
//        return ResultEntity.alert("系统内部异常");
        return new ResultEntity<>(200, null, 6, "系统内部异常");
    }

    @ExceptionHandler(value = AlertException.class)
    public ResultEntity handleAlertException(AlertException e) {
        log.error("业务异常", e);
        return new ResultEntity<>(200, null, 6, e.getMessage());
//        return ResultEntity.alert(e.getMessage());
    }

    /**
     * 统一处理请求参数校验(实体对象传参)
     *
     * @param e BindException
     * @return ResultEntity
     */
    @ExceptionHandler(BindException.class)
    public ResultEntity validExceptionHandler(BindException e) {
        StringBuilder message = new StringBuilder();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrors) {
            message.append(error.getField()).append(error.getDefaultMessage()).append(",");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return new ResultEntity<>(message.toString(), HttpStatus.BAD_REQUEST);
    }

    /**
     * 统一处理请求参数校验(普通传参)
     *
     * @param e ConstraintViolationException
     * @return ResultEntity
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResultEntity handleConstraintViolationException(ConstraintViolationException e) {
        StringBuilder message = new StringBuilder();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            Path path = violation.getPropertyPath();
            String[] pathArr = StringUtils
                    .splitByWholeSeparatorPreserveAllTokens(path.toString(), ".");
            message.append(pathArr[1]).append(violation.getMessage()).append(",");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return new ResultEntity<>(message.toString(), HttpStatus.BAD_REQUEST);
    }


}
