package com.example.demo.exceptions;

import com.example.demo.common.BaseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;

/**异常处理类
 * @author Administrator
 */
@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(value = Exception.class )
    BaseResult handlerException(Exception e, HttpServletRequest request) {
        return  BaseResult.fail("内部服务器错误");
    }

}
