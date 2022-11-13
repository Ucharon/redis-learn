package cn.homyit.handler;


import cn.homyit.dto.Result;
import cn.homyit.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    ////请求参数里的参数校验
    //@ExceptionHandler(ConstraintViolationException.class)
    //public ResultVo<ExceptionCodeEnum> handleConstraintViolationException(ConstraintViolationException e) {
    //    //返回泛化的错误信息，比如“参数错误”
    //    return ResultVo.error(ExceptionCodeEnum.ERROR_PARAM, e.getMessage());
    //}

    /**
    // * 字段校验异常
    // * @param e
    // * @return
    // */
    //@ExceptionHandler(MethodArgumentNotValidException.class)
    //public ResultVo handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    //    //从异常对象中拿到ObjectError对象
    //    String defaultMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
    //    return ResultVo.error(ExceptionCodeEnum.LOGIN_INPUT_ERROR, defaultMessage);
    //}


    @ExceptionHandler(BizException.class)
    public Result handleBizException(BizException e) {
        return Result.error(e.getError());
    }
    //
    ///**
    // * 文件或图片大小过大
    // * @param e
    // * @return
    // */
    //@ExceptionHandler(SizeException.class)
    //public ResultVo handleSizeException(SizeException e) {
    //    return Result.error(ExceptionCodeEnum.UPLOAD_FAIL);
    //}

}
