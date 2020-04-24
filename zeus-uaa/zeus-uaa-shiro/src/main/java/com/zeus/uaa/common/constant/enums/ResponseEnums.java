package com.zeus.uaa.common.constant.enums;

public enum ResponseEnums {
    SYSTEM_ERROR(3001, "网络异常"),
    BAD_REQUEST(3002, "错误的请求参数"),
    REQUEST_PARAM_ERROR(3003,"您无权操作或参数为空"),
    CONNECTION_ERROR(3004, "网络连接请求失败！"),
    REQUEST_SUCCESS(2000,"请求成功！"),
    SELECT_ERROR(3005,"查询异常"),
    OLDPWD_ERROR(3006,"旧密码有误");
//	METHOD_NOT_ALLOWED(-10004, "不合法的请求方式"),
//	DATABASE_ERROR(-10005, "数据库异常"),
//	BOUND_STATEMENT_NOT_FOUNT(-10006, "找不到方法！"),
//	NOT_MATCH(-10007, "您输入的用户名和密码不匹配，请重新输入！"),
//	FAIL_GETDATA(-10008, "获取信息失败"),
//	BAD_REQUEST_TYPE(-10009, "错误的请求类型"),
//
//	REPEAT_REGISTER(10001, "重复注册"),
//	NO_USER_EXIST(10002, "用户不存在"),
//	INVALID_PASSWORD(10003, "密码错误"),
//	NO_PERMISSION(10004, "非法请求！"),
//	SUCCESS_OPTION(200, "操作成功！"),
//
//	INVALID_MOBILE(10010, "您输入的手机号码有误，请重新输入！"),
//	INVALID_EMAIL(10011, "无效的邮箱"),
//	INVALID_GENDER(10012, "无效的性别"),
//	REPEAT_MOBILE(10014, "您输入的手机号码已经被注册!"),
//	REPEAT_EMAIL(10015, "已存在此邮箱地址"),
//	NO_RECORD(10016, "没有查到相关记录"),
//	LOGIN_SUCCESS(10017, "登陆成功"),
//	LOGOUT_SUCCESS(10018, "已退出登录"),
//	SENDEMAIL_SUCCESS(10019, "邮件已发送，请注意查收"),
//	EDITPWD_SUCCESS(10020, "修改密码成功"),
//	No_FileSELECT(10021, "未选择文件"),
//	FILEUPLOAD_SUCCESS(10022, "上传成功"),
//	NOLOGIN(10023, "未登陆"),
//	ILLEGAL_ARGUMENT(10024, "参数不合法"),
//	ERROR_IDCODE(10025, "您输入的图形验证码有误，请重新输入！"),
//	REGISTER_SUCCESS(10026, "注册成功"),
//	TWICE_PASSWORD(10028, "您两次输入的密码不一致，请重新输入"),
//	OUT_IDCODE(10029, "您输入的图形验证码已过期,请重新刷新"),
//	USER_NAME_ERROR(10030, "用户名包括6~18 位字符,只能包含英文字母、数字、下 划线"),
//	USER_PASSWORD_ERROR(10031, "6-14个字符，支持数字、大小写字母、标点符号 （例如:Abcd,123）， 不允许有空格"),
//	USER_MOBILE_PHONE_ERROR(10032, "密码必须包含6-14位，支持数字，大小写字母，标点符号，不允许有空格"),
//	USER_MOBILE_CODE(10033, "您输入的手机验证码已过期，,请重新获取！"),
//	MOBILE_CODE_FAIL(10038,"您输入的手机验证码不正确，请重新输入！"),
//	REQUEST_NOTNULL(10034, "请求参数不能为空"),
//	SMS_NOT_FAIL(10037,"手机短信验证码还未过期"),
//	REPATE_POLICY_NUMBER(10035,"政策重复导入"),
//	ERROR_PROFIX(10039,"文件格式不正确！"),
//	NOT_SELECT(10036,"未选中记录"),
//	FILE_PROFIEX_ERROR(10042,"文件格式不正确"),
//	APPLETS_LOGIN_ERROR(10044,"用户未登陆"),
//	POLICY_LIST_ERROR(200,"抱歉，没有找到相关结果,建议：\r\n" +
//			"1. 请您检查输入是否错误\r\n" +
//			"2. 请您尝试简化输入词\r\n" +
//			"3. 请您尝试用相似词或常见词"),
//	SUBMIT_TWICE(10046,"请勿重复提交！"),
//	NO_AUTH(10047,"您没有权限！"),
//	EXCEL_FILE(10048,"导入的文件必须是后缀名为xlsx的excel文件"),
//	NOT_SITE_USER(10049,"不是后台用户"),
//	OLD_PASSWORD_ERROR(10050,"旧密码输入错误！"),
//	FILE_NOT_FOUND(10051,"文件找不到！"),
//	AREASHOWREPATE(10052,"政策区域已存在！不能重复添加"),
//	FORBBEN_DELETE(10053,"禁止删除"),
//	ROlE_REPATE(10054,"角色重复"),
//	DICT_REPATE(10055,"类别编号重复"),
//	USER_FORBBIN(10056,"账号被禁用"),
//	FILE_EXCEL_ERROR(10057,"请按照导入模板结构导入数据！"),
//	DELETE_FORBBIN_POLICY(10058,"该政策关联到政策，暂无法删除！"),
//	REPEAT_USERNAME(10059,"用户名不能重复");


    private int code;

    private String msg;

    private ResponseEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}

