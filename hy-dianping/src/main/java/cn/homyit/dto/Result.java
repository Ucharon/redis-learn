//package cn.homyit.dto;
//
//import cn.homyit.enums.ExceptionCodeEnum;
//import cn.homyit.enums.ResultCodeEnum;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//public class Result<T> {
//
//    private Integer code;
//    private boolean success;
//    private String message;
//    private T data;
//
//    public Result(Integer code, String message, T data, boolean success) {
//        this.code = code;
//        this.message = message;
//        this.data = data;
//        this.success = success;
//    }
//
//    public Result(Integer code, String message, boolean success) {
//        this.code = code;
//        this.message = message;
//        this.success = success;
//    }
//
//    /**
//     * 带数据成功返回
//     *
//     * @param data
//     * @param <T>
//     * @return
//     */
//    public static <T> Result<T> success(T data) {
//        return new Result<>(ResultCodeEnum.SUCCESS.getCode(),
//                ResultCodeEnum.SUCCESS.getMessage(), data, true);
//    }
//
//    /**
//     * 未携带数据成功返回
//     *
//     * @param <T>
//     * @return
//     */
//    public static <T> Result<T> success() {
//        return new Result(ResultCodeEnum.SUCCESS.getCode(),
//                ResultCodeEnum.SUCCESS.getMessage(), true);
//    }
//
//    /**
//     * 通用错误返回
//     *
//     * @param exceptionCodeEnum
//     * @return
//     */
//    public static <T> Result<T> error(ExceptionCodeEnum exceptionCodeEnum) {
//        return new Result(exceptionCodeEnum.getCode(),
//                exceptionCodeEnum.getDesc(), false);
//    }
//
//    /**
//     * 通用错误返回
//     *
//     * @param exceptionCodeEnum
//     * @param msg
//     * @return
//     */
//    public static <T> Result<T> error(ExceptionCodeEnum exceptionCodeEnum, String msg) {
//        return new Result(exceptionCodeEnum.getCode(), msg, false);
//    }
//
//    /**
//     * 通用错误返回
//     *
//     * @param exceptionCodeEnum
//     * @param data
//     * @param <T>
//     * @return
//     */
//    public static <T> Result<T> error(ExceptionCodeEnum exceptionCodeEnum, T data) {
//        return new Result<>(exceptionCodeEnum.getCode(),
//                exceptionCodeEnum.getDesc(), data, false);
//    }
//}

package cn.homyit.dto;

import cn.homyit.enums.ExceptionCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Boolean success;
    private String errorMsg;
    private T data;
    private Long total;

    public static <T> Result<T> success() {
        return new Result<>(true, null, null, null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(true, null, data, null);
    }

    public static <T> Result<T> success(List<?> data, Long total) {
        return new Result(true, null, data, total);
    }


    public static <T> Result<T> error(ExceptionCodeEnum exceptionCodeEnum, T data) {
        return new Result<>(false,  exceptionCodeEnum.getDesc(), data, null);
    }

    public static <T> Result<T> error(ExceptionCodeEnum exceptionCodeEnum) {
        return new Result<>(false,  exceptionCodeEnum.getDesc(), null, null);
    }
}
