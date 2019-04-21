package com.bankservice.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class RechargeDetailDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal amount;

	private String platformUserNo;
	

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getPlatformUserNo() {
		return platformUserNo;
	}

	public void setPlatformUserNo(String platformUserNo) {
		this.platformUserNo = platformUserNo;
	}

	
}
