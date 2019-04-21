package com.bankservice.model;

import java.io.Serializable;

/**
 * 
 * @description 上海银行直连接口RESP
 * @author leieb
 * @time 2017年11月2日 下午6:37:45
 *
 */
public class BankServiceResp implements Serializable{

	private static final long serialVersionUID = 1L;

	//0调用成功 1调用失败
	private String code;
	
	//处理失败INIT 处理成功SUCCESS
	private String status;
	
	//错误码
	private String errorCode;
	
	//错误码描述
	private String errorMessage;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "BankServiceResp{" +
				"code='" + code + '\'' +
				", status='" + status + '\'' +
				", errorCode='" + errorCode + '\'' +
				", errorMessage='" + errorMessage + '\'' +
				'}';
	}
}
