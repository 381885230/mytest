package com.bankservice.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bankservice.BankService;
import com.bankservice.model.BankQueryRespDTO;
import com.bankservice.model.PreTransactionRecords;
import com.bankservice.model.PreTransactionRespDTO;
import com.bankservice.model.RechargeDetailDTO;
import com.bankservice.model.RechargeTransactionRespDTO;

@Service
public class BankServiceImpl<T> implements  BankService{
	

	/**
	 * 查询银行订单
	 * @param requestNo  		订单号
	 * @param transactionType  	交易查询类型
	 * @return
	 */
	public PreTransactionRespDTO queryTransaction(String requestNo, String transactionType) {
		List<PreTransactionRecords> records=new ArrayList<PreTransactionRecords>();
		PreTransactionRecords ptr=new PreTransactionRecords();
		ptr.setBizType("01");
		ptr.setPlatformUserNo("1000000");
		records.add(ptr);
		
		PreTransactionRespDTO ptd=new PreTransactionRespDTO();
		ptd.setCode("0000");
		ptd.setErrorCode("0000");
		ptd.setErrorMessage("error");
		ptd.setStatus("00");
		ptd.setRecords(records);
		return ptd;
	}
	
	/**
	 * 查询银行订单
	 * @param requestNo 		订单号
	 * @param transactionType 	交易查询类型
	 * @return
	 */
	public RechargeTransactionRespDTO queryRechargeTransaction(String requestNo, String transactionType) {
		List<RechargeDetailDTO> records=new ArrayList<RechargeDetailDTO>();
		RechargeDetailDTO rdd=new RechargeDetailDTO();
		rdd.setPlatformUserNo("1000000");
		records.add(rdd);
		
		RechargeTransactionRespDTO rtd=new RechargeTransactionRespDTO();
		rtd.setCode("0000");
		rtd.setErrorCode("12345");
		rtd.setErrorMessage("exp");
		rtd.setStatus("01");
		rtd.setRecords(records);
		
		return rtd;
	}

	@Override
	public BankQueryRespDTO<T> queryBankOrder(String requestNo, String transactionType,
			Object t) {
//		if(t instanceof PreTransactionRecords){
//			return  queryTransaction(requestNo,transactionType);
//		}
//		if(t instanceof RechargeTransactionRespDTO){
//			return  queryRechargeTransaction(requestNo,transactionType);
//		}
		return null;		
	}



}
