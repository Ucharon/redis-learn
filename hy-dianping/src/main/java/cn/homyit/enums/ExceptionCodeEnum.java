package cn.homyit.enums;


import lombok.Getter;

/**
 * 通用错误枚举
 */

@Getter
public enum ExceptionCodeEnum {

    //统一异常
    ERROR(600, "服务器异常"),

    UNREALIZE(601, "功能未实现"),

    //用户登录异常
    PHONENUMBER_FORMAT_INVALID(700, "手机号格式错误"),
    CODE_INVALID(701, "验证码异常"),


    //文件名称错误
    FILE_NAME_ERROR(800, "文件名称错误"),


    /**
     * 店铺有关
     */
    SHOP_NOT_EXIST(900, "店铺不存在"),
    SHOP_TYPE_NOT_EXIST(901, "商品类型不存在"),
    SHOP_ID_NOt_EXIST(902, "店铺id不存在")
    ;
    private final Integer code;
    private final String desc;

    ExceptionCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
