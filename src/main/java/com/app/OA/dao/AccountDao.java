package com.app.OA.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.OA.domain.BookPatient;
import com.app.OA.domain.User;

public interface AccountDao {

	/**
	 * 获取管理员相关所有信息
	 * @param name 用户名
	 * @return
	 */
	User selectOneUser(@Param(value = "name") String name);


	/**
	 * 更新管理员登录相关信息
	 * @param loginTime 最近一次登录时间
	 * @param name 用户名
	 * @param sessionid	最近登录的sessionID
	 */
	void updateLoginTime(@Param(value = "loginTime") String loginTime,@Param(value = "name") String name);

	/**
	 * 注册新管理员
	 * @param user
	 */
	void register(@Param(value = "user") User user);


	/**
	 * 退出登录
	 * @param name
	 */
	void logout(@Param(value = "name") String name,@Param(value = "logoutTime") String logoutTime);

	/**
	 * 修改管理员信息
	 * @param user
	 */
	void modify(@Param(value = "user") User user);


	/**
	 * 获取所有管理员
	 *
	 * @return
	 */
	List<User> queryAllUser(@Param(value = "user") User user);

	/**
	 * 删除管理员
	 * @param name 用户名
	 * @return
	 */
	void delete(@Param(value = "name")  String name);


	/**
	 * 验证是否是管理员并且拥有权限
	 *
	 * @return
	 */
	Integer checkPower(@Param(value = "name") String administrators);

	/**
	 * 获取管理员个人信息
	 * @return
	 */
	User getUser(@Param(value = "name") String name);

	/**
	 * 获得角色所拥有的权限组合
	 * @param roleNum
	 * @return
	 */
	String getUserPower(@Param(value = "roleNum") Integer roleNum);

	/**
	 * 获取预约挂号列表
	 * @param user
	 * @return
	 */
	List<BookPatient> getBookList(@Param(value = "user") User user);

	/**
	 * 记录用户日志
	 * @param roleName
	 * @param loginTime
	 * @param string
	 */
	void addLog(@Param(value = "name") String name, @Param(value = "loginTime") String loginTime, @Param(value = "active") String active);

	/**
	 * 定时删除日志
	 * 
	 * @param loginTime
	 */
	void deleteLogByTime(@Param(value = "loginTime") String loginTime);

	/**
	 * 获取预约挂号列表总条数
	 * @param user
	 * @return
	 */
	Integer getBookListCount(@Param(value = "user") User user);

	/**
	 * 验证账户名是否存在
	 * @param user
	 * @return
	 */
	int checkName(@Param(value = "userName") String userName);

	/**
	 * 清空登录状态
	 * @param user
	 * @return
	 */
	void clearStatus(@Param(value = "name") String name);

	/**
	 * 查询所有管理员总数
	 * @return
	 */
	Integer queryAllUserCount(@Param(value = "user") User user);

	/**
	 * 获取用户
	 * @param user
	 * @return
	 */
	List<User> getWechat(@Param(value = "user") User user);

	/**
	 * 获取用户总数
	 * @param user
	 * @return
	 */
	Integer getWechatCount(@Param(value = "user") User user);

	/**
	 * 获取日志信息
	 * @param user
	 * @return
	 */
	List<User> getLogin(@Param(value = "user") User user);

	/**
	 * 获取日志信息总数
	 * @param user
	 * @return
	 */
	Integer getLoginCount(@Param(value = "user") User user);

}
