package com.example.knowledge_managing.util;

public enum RespCode {

    /**
     * 错误来源：用户-A
     */
    TOKEN_NULL_OR_EMPTY("100", "缺少token参数或为空!"),
    TOKEN_OVERTIME("101", "token已过期!请重新登录!"),
    USER_EXSITING_ERROR("102", "用户不存在"),
    USER_LOGIN_ERROR("103", "用户已禁用"),
    ADMIN_CODE_OVERTIME("204", "验证码已过期,请重新刷新验证码!"),
    ADMIN_LOGOUT_ERROR("205", "退出登录失败!"),
    ADMIN_LOGIN_ERROR("210", "密码错误!"),
    ADMIN_EXIST_ERROR("206", "该用户已存在!"),
    ADMIN_LACK_INFO("207", "缺少用户信息！"),
    PARAMETER_NULL("208", "请求参数中缺少必要的参数:"),
    PHONE_NUMBER_EXIST("209","该手机号已注册,无法再次注册!"),
    RID_NOT_RECIEVE("210","未收到订单号!"),
    /**
     * 支付错误
     */
    BLANCE_NOT_ENOUGH("22","账户余额不足"),
    WITHOUT_UNPAY_CHECK("23","不存在未支付订单"),

    WITHOUT_PREORDER_RIDE("24","不存在预约订单"),
    WITHOUT_CONTINUE_RIDE("25","不存在正在进行的订单"),


//    密码重设错误
    RESET_PASSWORD_TIMES_INFO("300", "发送次数已达上线"),
    RESET_PASSWORD_EMAIL_ERROR("301","请输入正确的邮箱地址"),
    RESET_PASSWORD_USERID_ERROR("302","请输入正确的userID"),
    RESET_PASSWORD_CODE_OVERTIME("303","验证码已过期,请重新发送"),
    RESET_PASSWORD_CODE_ERROR("304","验证码不正确,请重新输入"),
    RESET_CODE_NULL_OR_EMPTY("305","请输入验证码"),
    RESET_CODE_ERROR("306","未知错误"),
//    密码
    /* 成功状态码 */
    SUCCESS("0", "操作成功!"),
    REQUEST_ERROR("21", "请求失败"),
    REQUEST_WAIT("11", "过一段时间后再次请求"),
    REQUEST_STOP("12", "停止请求"),
    /* 数据库错误：001-010*/
    DATABASE_UPDATE_ERROR("1", "数据库更新数据发生错误!"),
    DATABASE_INSERT_ERROR("2", "数据库插入数据发生错误!"),
    DATABASE_DELETE_ERROR("3", "数据库删除数据发生错误!"),
    DATABASE_INSERT_EXIST("4", "已存在!"),
    DATABASE_SELECT_ERROR("5", "数据库查询数据发生错误!");

    /**
     * 正常运行状态码
     */


    private String errCode;
    private String errMsg;

    RespCode(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }


    public String getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
