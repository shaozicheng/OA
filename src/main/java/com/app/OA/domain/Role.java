package com.app.OA.domain;

public class Role {

	//id
	private Integer id;
	
	//角色名称
	private String roleName;
	
	//创建人
	private String createUser;
	
	//创建时间
	private String createTime;
	
	//权限等级
	private String powerGrade;
	
	//权限等级
	private String powerGradeName;
	
	//修改人
	private String updateUser;
		
	//修改时间
	private String updateTime;
	
	//说明
	private String explains;

	public String getPowerGradeName() {
		return powerGradeName;
	}

	public void setPowerGradeName(String powerGradeName) {
		this.powerGradeName = powerGradeName;
	}

	public String getPowerGrade() {
		return powerGrade;
	}

	public void setPowerGrade(String powerGrade) {
		this.powerGrade = powerGrade;
	}

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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
