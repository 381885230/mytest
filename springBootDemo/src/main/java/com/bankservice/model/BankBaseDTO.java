package com.bankservice.model;

/**
 * @author leieb
 * @description 上海银行接口基础DTO(直连接口DTO, 对账下载接口DTO)
 * @time 2017年11月2日 下午4:11:29
 */
public class BankBaseDTO {

    //平台编号
    private static String platformNo = "9100001352";
    //接口名称
    private String serviceName;
    //请求报文,JSON格式
    private BankReqDTO reqData;

    //证书序号,默认值为1
    private String keySerial = "1";

    //对reqData参数的签名
    private String sign;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public BankReqDTO getReqData() {
        return reqData;
    }

    public void setReqData(BankReqDTO reqData) {
        this.reqData = reqData;
    }

    public String getKeySerial() {
        return keySerial;
    }

    public void setKeySerial(String keySerial) {
        this.keySerial = keySerial;
    }

    public String getSign() {
        return sign;
    }

    public String getPlatformNo() {
        return platformNo;
    }

    public static void setPlatformNo(String platformNo) {
        BankBaseDTO.platformNo = platformNo;
    }

    @Override
    public String toString() {
        return "BankBaseDTO [serviceName=" + serviceName + ", platformNo=" + platformNo + ", reqData=" + reqData
                + ", keySerial=" + keySerial + ", sign=" + sign + "]";
    }

}
