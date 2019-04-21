package com.bankservice.model;

import java.util.List;

public class RechargeTransactionRespDTO extends BankServiceResp{

	private static final long serialVersionUID = 1L;
	
	private List<RechargeDetailDTO> records;

	public List<RechargeDetailDTO> getRecords() {
		return records;
	}

	public void setRecords(List<RechargeDetailDTO> records) {
		this.records = records;
	}

	@Override
	public String toString() {
		return "RechargeTransactionRespDTO [records=" + records + "]";
	}
	
}
