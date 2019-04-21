package com.bankservice.model;


/**
 * @author leieb
 * @description 银行接口请求报文基础类
 * @time 2017年11月2日 下午5:41:42
 */
public class BankReqDTO {

    private String timestamp = "2019-01-01";

    private String platformUserNo;

    public String getPlatformUserNo() {
        return platformUserNo;
    }

    public void setPlatformUserNo(String platformUserNo) {
        this.platformUserNo = platformUserNo;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
