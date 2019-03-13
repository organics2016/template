package ink.organics.openjdk11.common.config;

import ink.organics.openjdk11.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by 王汗超 on 2017/6/12.
 * <p>
 * 全局异常处理配置
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    /**
     * 身份验证异常
     *
     * @param e
     * @return
     */
//    @ExceptionHandler(UnauthorizedException.class)
//    public ResponseEntity unauthorizedException(UnauthorizedException e) {
//        return new ResponseEntity<>(new ResponseDTO(HttpStatus.UNAUTHORIZED.value()), HttpStatus.UNAUTHORIZED);
//    }


    /**
     * 业务异常处理
     *
     * @param e
     * @return
     */
//    @ExceptionHandler(OperationException.class)
//    public ResponseEntity operationException(OperationException e) {
//        log.warn("web warn : {}", e.getMessage());
//        return new ResponseEntity<>(new ResponseDTO(e.getMessage(), HttpStatus.FORBIDDEN.value()), HttpStatus.FORBIDDEN);
//    }

    /**
     * 表单验证失败
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StringBuilder sb = new StringBuilder();

        ex.getBindingResult().getFieldErrors()
                .forEach(e ->
                        sb.append(e.getField()).append(e.getDefaultMessage()).append(";"));

        return this.handleExceptionInternal(ex, new ResponseDTO(sb.toString(), status.value()), headers, status, request);
    }
}
