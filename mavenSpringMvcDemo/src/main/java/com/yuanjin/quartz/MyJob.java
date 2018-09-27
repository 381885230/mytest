package com.yuanjin.quartz;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class MyJob implements Job {
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Ҫȥ���ݿ�ɨ����������");
	}

	public static void main(String[] args) throws Exception { // ��������
		JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
				.withIdentity("job1", "group1").build(); // ���������� ÿ3����ִ��һ��
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group3")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever()).build();
		Scheduler scheduler = new StdSchedulerFactory().getScheduler(); // �������䴥�������������
		scheduler.scheduleJob(jobDetail, trigger); // ��������ʼ��������
		scheduler.start();
	}
}