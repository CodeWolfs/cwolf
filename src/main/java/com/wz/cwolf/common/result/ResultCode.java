package com.wz.cwolf.common.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS(20000, "操作成功"),
    /**
     * 未登录
     */
    NO_LOGIN(40001, "用户未登录"),
    /**
     * 没有操作权限
     */
    AUTHORIZED(40300, "没有操作权限"),
    /**
     * 系统异常
     */
    SYSTEM_ERROR(50000, "系统异常"),
    /**
     * 失败
     */
    FAIL(51000, "操作失败"),
    /**
     * 参数校验失败
     */
    VALID_ERROR(52000, "参数格式不正确"),
    /**
     * 用户名已存在
     */
    USERNAME_EXIST(52001, "用户名已存在"),
    /**
     * 用户名不存在
     */
    USERNAME_NOT_EXIST(52002, "用户名不存在"),


    /**
     * 邮箱已被注册
     */
    EMAIL_EXIST(52003,"邮箱已被注册"),

    /**
     * qq登录错误
     */
    QQ_LOGIN_ERROR(53001, "qq登录错误"),
    /**
     * 微博登录错误
     */
    WEIBO_LOGIN_ERROR(53002, "微博登录错误"),

    /**
     * 用户名或密码错误
     */
    USERNAME_OR_PASSWORD_ERROR(53003,"用户名或密码错误"),

    /**
     * 账号已被禁用
     */
    ACCOUNT_DISABLED(53004,"账户已被禁用"),

    /**
     *没有登录
     */
    NOT_LOGIN(53005,"没有登录"),

    /**
     * 邮箱验证码错误
     */
    EMAIL_CODE_ERROR(54001,"验证码错误"),

    /**
     *没有发送验证码或者验证码过期
     */
    EMAIL_CODE_NULL(54002,"没有发送验证码或者验证码过期"),

    /**
     * 分类正在被使用
     */
    CATEGORY_USING(55001,"分类正在被使用"),

    /***
     * 分类名称存在
     **/
    CATEGORY_EXIST(55002,"分类已经存在"),

    /**
     * 标签正在被使用
     */
    TAG_USING(55003,"标签正在被使用"),

    /***
     * 标签名称存在
     **/
    TAG_EXIST(55004,"标签已经存在"),

    /**
     * 字典编码存在
     */
    DICT_CODE_EXIST(56001,"字典编码存在"),

    /**
     * 字典项编码存在
     */
    DICT_ITEM_VALUE_EXIST(57001,"字典项编码存在"),

    /**
     * 中国节假日期存在
     */
    CHINA_HOLIDAY_DATE_EXIST(58001, "节假日期存在"),

    /**
     * 文件不存在
     */
    UPLOAD_FILE_NOT_EXIST(59001, "文件不存在"),


    /**
     * 构造结束
     */
    CODE_END(1234,"构造结束");


    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 描述
     */
    private final String desc;
}
