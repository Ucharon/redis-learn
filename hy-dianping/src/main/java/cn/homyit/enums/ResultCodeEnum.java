package cn.homyit.enums;

import lombok.Getter;
import lombok.ToString;

/**
 * 通用状态码枚举
 */
@Getter
public enum ResultCodeEnum {
    //成功状态码
    SUCCESS(200, "成功");

    //状态码信息
    private final Integer code;

    //响应信息，以来响应情况
    private final String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
