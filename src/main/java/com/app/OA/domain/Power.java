package com.app.OA.domain;

public class Power {
	
	//id
	private Integer id;

	//权限名称
	private String powerName;
	
	//权限等级
	private Integer powerGrade;
	
	//创建者
	private String createUser;
	
	//创建时间
	private String createTime;
	
	//更新时间
	private String updateTime;
	
	//修改者
	private String updateUser;
	
	//说明
	private String explains;


	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPowerName() {
		return powerName;
	}

	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}

	public Integer getPowerGrade() {
		return powerGrade;
	}

	public void setPowerGrade(Integer powerGrade) {
		this.powerGrade = powerGrade;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getExplains() {
		return explains;
	}

	public void setExplains(String explains) {
		this.explains = explains;
	}


	
	
}
