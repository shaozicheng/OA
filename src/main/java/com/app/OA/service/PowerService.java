package com.app.OA.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.OA.dao.AccountDao;
import com.app.OA.dao.PowerDao;
import com.app.OA.domain.Power;
import com.app.OA.domain.User;

@Component
public class PowerService {

	@Autowired
	PowerDao powerDao;
	
	@Autowired
	AccountDao accountDao;
	
	//获取当前时间
	public String getTime(){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		
		return sdf.format(date);
	}
	
	/**
	 * 增加权限
	 * @param power 新增权限相关信息
	 * @return
	 */
	public void add(Power power) {
		String createTime = getTime();
		power.setCreateTime(createTime);
		powerDao.add(power);
		accountDao.addLog(power.getCreateUser(),createTime,"新增权限: "+power.getPowerName());//记录日志
	}

	/**
	 * 删除权限
	 * @param name
	 * @return
	 */
	public void delete(User user) {
		String updateTime = getTime();
		powerDao.delete(user.getId());
		accountDao.addLog(user.getName(),updateTime,"删除权限: "+user.getRoleName());//记录日志
	}
	
	/**
	 * 修改权限
	 * @param power 要修改的权限内容
	 * @return
	 */
	public void update(Power power) {
		String updateTime = getTime();
		power.setUpdateTime(updateTime);
		powerDao.update(power);
		accountDao.addLog(power.getUpdateUser(),updateTime,"修改权限: "+power.getPowerName());//记录日志
	}

	/**
	 * 查询权限
	 * @param 
	 * @return
	 */
	public List<Power> selectAll() {

		return powerDao.selectAll();

	}

}
