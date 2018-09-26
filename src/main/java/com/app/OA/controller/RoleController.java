package com.app.OA.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.OA.domain.Entity;
import com.app.OA.domain.Role;
import com.app.OA.domain.User;
import com.app.OA.service.AccountService;
import com.app.OA.service.RoleService;

/***
 * 角色管理
 * @author 邵子城 2018/7/30
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/role")
public class RoleController {

	final static Logger logger = LoggerFactory.getLogger(RoleController.class);
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	AccountService accountService;
	
	/**
	 * 增加角色
	 * @param Role 新增角色相关信息
	 * @return
	 */
	@RequestMapping("/add")
	@PostMapping
	public Entity add(@RequestBody Role role) {
		Entity entity= new Entity();
		roleService.add(role);
		entity.setSuccess(true);
		entity.setMessage("创建成功");
		return entity;
	}
	
	/**
	 * 删除角色
	 * @param name 账户	
	 * @param passward	 密码
	 * @return
	 */
	@RequestMapping("/delete")
	@PostMapping
	public Entity delete(@RequestBody User user){
		Entity entity= new Entity();
		boolean check= accountService.checkPower(user.getUserName());
		if(check){
			roleService.delete(user);
			entity.setMessage("删除成功");
			entity.setSuccess(true);
		}else{
			entity.setMessage("账户权限不足");
			entity.setSuccess(false);
		}
		return entity;
	}
	
	/**
	 * 修改角色
	 * @param Role 要修改的角色内容
	 * @return
	 */
	@RequestMapping("/update")
	@PostMapping
	public Entity update(@RequestBody Role role){
		Entity entity= new Entity();
		try {
			roleService.update(role);
			entity.setMessage("修改成功");
			entity.setSuccess(true);
		} catch (Exception e) {
			entity.setMessage("修改失败"+e.toString());
			entity.setSuccess(false);
			e.printStackTrace();
		}
		
		return entity;
	}
	
	/**
	 * 查询角色
	 * @param 
	 * @return
	 */
	@RequestMapping("/select")
	@PostMapping
	public Entity select() {
		Entity entity= new Entity();
		
		List<Role> roles = roleService.selectAll();
		
		entity.setResult(roles);
		entity.setSuccess(true);
		return entity;
	}
}
