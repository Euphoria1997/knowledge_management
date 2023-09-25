package com.example.knowledge_managing.util;


import java.io.Serializable;


public class RespResult implements Serializable {

    private static final long serialVersionUID = -999362211833007653L;

    /**
     * 返回结果编码
     */
    private final String errCode;

    /**
     * 返回消息，一般放置可追溯的错误消息
     */
    private final String errMsg;
    /**
     * 返回数据
     */
    private final Object data;
    /**
     * 返回分页信息
     */
    private RespPage respPage = null;



    public RespResult(String errCode, String errMsg, Object data, RespPage respPage) {
		super();
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.data = data;
		this.respPage = respPage;
	}

	public static RespResult responseWithoutData(RespCode resultCode) {
        return new RespResult(resultCode.getErrCode(), resultCode.getErrMsg(), null, null);
    }

    public static RespResult responseWithData(RespCode resultCode, Object data) {
        return new RespResult(resultCode.getErrCode(), resultCode.getErrMsg(), data, null);
    }

    public static RespResult responseWithPageData(RespCode resultCode, Object data, RespPage respPage) {
        return new RespResult(resultCode.getErrCode(), resultCode.getErrMsg(), data, respPage);
    }



    public RespPage getRespPage() {
		return respPage;
	}

    public String getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public Object getData() {
        return data;
    }
}