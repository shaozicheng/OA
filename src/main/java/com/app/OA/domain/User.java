package com.app.OA.domain;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{

	private static final long serialVersionUID = 2416069058255000796L;

	//用户序列id
	private Integer id;
	
	//用户唯一id
	private String guid;
	
	//用户账户
	private String name;
	
	//密码
	private String passWard;
	
	//姓名
	private String userName;
	
	//手机号
	private String userPhone;
	
	//性别
	private Integer userSex;
	
	//生日
	private String userBoth;
	
	//角色
	private Integer roleGrade;
	
	//角色名称
	private String roleName;

	//最后一次登录时间
	private String lastLoginTime;
	
	//账户创建时间
	private String createTime;
	
	//状态
	private Integer status;
	
	//最后一次登出时间
	private String lastOutTime;
	
	//最后一次修改时间
	private String updateTime;
	
	//所获取的系列ID
	List<Integer> ids;
	
	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public String getUserBoth() {
		return userBoth;
	}

	public void setUserBoth(String userBoth) {
		this.userBoth = userBoth;
	}

	public Integer getRoleGrade() {
		return roleGrade;
	}

	public void setRoleGrade(Integer roleGrade) {
		this.roleGrade = roleGrade;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Integer getUserSex() {
		return userSex;
	}

	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassWard() {
		return passWard;
	}

	public void setPassWard(String passWard) {
		this.passWard = passWard;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastOutTime() {
		return lastOutTime;
	}

	public void setLastOutTime(String lastOutTime) {
		this.lastOutTime = lastOutTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	
}
