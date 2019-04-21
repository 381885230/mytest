package com.bankservice.model;

import java.util.List;

public class PreTransactionRespDTO extends BankServiceResp{

	private static final long serialVersionUID = 1L;
	
	private List<PreTransactionRecords> records ;

	public List<PreTransactionRecords> getRecords() {
		return records;
	}

	public void setRecords(List<PreTransactionRecords> records) {
		this.records = records;
	}
	
	
	
}
