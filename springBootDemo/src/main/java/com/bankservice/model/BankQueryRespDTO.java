package com.bankservice.model;

import java.util.List;

public class BankQueryRespDTO<T> extends BankServiceResp{

	private static final long serialVersionUID = 1L;
	
	private List<T> records ;

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}
	
	
	
}
