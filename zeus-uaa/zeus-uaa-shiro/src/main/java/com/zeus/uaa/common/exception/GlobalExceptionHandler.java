package com.zeus.uaa.common.exception;

import com.zeus.core.model.Result;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result<String> methodArgumentsExceptionHandler(HttpServletRequest request, Exception e){
        //绑定异常是需要明确提示给用户的
        logger.info("传入参数校验失败："+e.getMessage(), e);
        MethodArgumentNotValidException exception=(MethodArgumentNotValidException) e;
        //获取自错误信息
        StringBuilder msg = new StringBuilder();
        for(ObjectError error : exception.getBindingResult().getAllErrors()) {
            msg.append(error.getDefaultMessage()).append(";\n");
        }
        //将具体错误信息设置到CodeMsg中返回
        return Result.failed(msg.toString());
    }

    @ExceptionHandler(value = UaaException.class)
    public Result<String> UaaExceptionHandler(HttpServletRequest request, Exception e){
        logger.info("业务数据异常："+ e.getMessage(),e);
        UaaException exception=(UaaException) e;
        //获取自错误信息
        String msg= exception.getMessage();
        //将具体错误信息设置到CodeMsg中返回
        return Result.failed(msg);
    }

    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e){
        // 其余异常简单返回为服务器异常
        logger.info("其他异常：null");
        return Result.failed("服务器异常，请联系管理员！！！");
    }

    /**
     * 没有权限 异常
     * <p/>
     * 后续根据不同的需求定制即可
     */
    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Result<String> processUnauthenticatedException(NativeWebRequest request, UnauthorizedException e) {
        return Result.failed("未授权异常，请联系管理员！！！");
    }
}
