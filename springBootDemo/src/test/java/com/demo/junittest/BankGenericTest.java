package com.demo.junittest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.Application;
import com.bankservice.BankService;
import com.bankservice.model.BankQueryRespDTO;
import com.bankservice.model.PreTransactionRecords;
import com.bankservice.model.RechargeTransactionRespDTO;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={Application.class})
public class BankGenericTest {

	@Autowired
	BankService bankService;

	
	@Test
	public void test(){
		String requestNo="";
		String transactionType="";
		
		BankQueryRespDTO<PreTransactionRecords> t1=bankService.queryBankOrder(requestNo,transactionType,PreTransactionRecords.class);
		BankQueryRespDTO<RechargeTransactionRespDTO> t2=bankService.queryBankOrder(requestNo,transactionType,PreTransactionRecords.class);

		
	}
	
}