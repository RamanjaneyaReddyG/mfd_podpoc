package com.ram.mft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class JasperCronScheduler {
	
	@Autowired
	CopyFilesPoc poc;
	
	@Scheduled(cron = "${cron.expression.job}")
	public void runTask() {
		System.out.println("Started moving files....");
		poc.moveXmlFiles();
	}

}
