package com.app.OA.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.app.OA.controller.AccountController;
import com.app.OA.service.AccountService;

@Component
public class Timetask {

	@Autowired
	AccountService accountService;
	
	/**
	 * 定时删除日志
	 * 
	 * 
	 */
	@Scheduled(cron="0 0 2 28 * ?")
	public void deleteLogByTime(){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date); // 设置为当前时间
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
		date = calendar.getTime();
		String loginTime=sdf.format(date);
		deleteLog(loginTime);
	}
	
	public void deleteLog(String loginTime){
		accountService.deleteLogByTime(loginTime);
	}
	
	
}
