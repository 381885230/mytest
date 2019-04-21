package com.bankservice;

import com.bankservice.model.BankQueryRespDTO;
import com.bankservice.model.PreTransactionRespDTO;
import com.bankservice.model.RechargeTransactionRespDTO;

public interface BankService<T> {
	

	/**
	 * 查询银行订单
	 * @param requestNo  		订单号
	 * @param transactionType  	交易查询类型
	 * @return
	 */
	public PreTransactionRespDTO queryTransaction(String requestNo, String transactionType);
	
	/**
	 * 查询银行订单
	 * @param requestNo 		订单号
	 * @param transactionType 	交易查询类型
	 * @return
	 */
	public RechargeTransactionRespDTO queryRechargeTransaction(String requestNo, String transactionType);

	public BankQueryRespDTO<T> queryBankOrder(String requestNo, String transactionType,T t);
}
