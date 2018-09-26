package com.app.OA.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.OA.domain.BookPatient;
import com.app.OA.domain.Entity;
import com.app.OA.domain.User;
import com.app.OA.service.AccountService;


/***
 * 账号管理
 * @author 邵子城 2018/7/30
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/account")
public class AccountController {

	final static Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	AccountService accountService;
	
	/**
	 * 登录
	 * @param user
	 * @param session
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/login")
	@PostMapping
	public Entity login(@RequestBody User user ,HttpServletRequest request, HttpServletResponse response) throws ParseException{
		Entity entity= new Entity();
		entity = accountService.login(user,request); 
     	
		return entity;
	}

	/**
	 * 注册
	 * @param user 新注册用户
	 * @return
	 */
	@RequestMapping("/register")
	@PostMapping
	public Entity register(@RequestBody User user){
		Entity entity =new Entity();
		boolean bl=accountService.register(user);
		if(bl){
			entity.setMessage("添加成功");
			entity.setSuccess(true);
		}else{
			entity.setMessage("添加失败");
			entity.setSuccess(false);
		}
		
		return entity;
	}
	
	/**
	 * 退出登录
	 * @param user
	 * @return
	 */
	@RequestMapping("/logout")
	@PostMapping
	public Entity logout(@RequestBody User user,HttpServletRequest request){
		Entity entity =new Entity();
		accountService.logout(user,request);
		entity.setMessage("退出成功");
		entity.setSuccess(true);
		return entity;
	}
	
	/**
	 * 修改用户个人信息
	 * @return
	 */
	@RequestMapping("/modify")
	@PostMapping
	public Entity modify(@RequestBody User user  ){
		Entity entity =new Entity();
		//验证权限
		try {
			 boolean result = accountService.modify(user);
			 if(result){
				 entity.setMessage("修改成功");
				 entity.setSuccess(true);
			 }else{
				 entity.setMessage("信息不匹配,请重新登录");
				 entity.setSuccess(false);
			 }
			
		} catch (Exception e) {
			entity.setMessage(e.toString());
			entity.setSuccess(false);
		}
		 
		return entity;
	}
	
	
	/**
	 * 查询所有管理员(管理员模式下才有)
	 * @return
	 */
	@RequestMapping("/queryalluser")
	@PostMapping
	public Entity queryAllUser(@RequestBody User user ){
		Entity entity =new Entity();
		List<User> users=accountService.queryAllUser(user);
		Integer count =  accountService.queryAllUserCount(user);
		entity.setResult(users);
		entity.setSuccess(true);
		entity.setTotal(count);
		
		return entity;
	}
	
	/**
	 * 删除指定用户(管理员模式下才有)
	 * @return
	 */
	@RequestMapping("/delete")
	@PostMapping
	public Entity delete(@RequestBody User user){
		Entity entity =new Entity();
		//验证权限
		boolean check= accountService.checkPower(user.getName());
		if(check){
			accountService.delete(user);
			entity.setSuccess(true);
		}else{
			entity.setMessage("账户权限不足");
			entity.setSuccess(false);
		}
		return entity;
	}
	
	/**
	 * 获取用户个人信息
	 * @return
	 */
	@RequestMapping("/getuser")
	@PostMapping
	public Entity getUser(@RequestBody User user ){
		Entity entity = new Entity();
		User userData = accountService.getUser(user.getName());
		entity.setResult(userData);
		entity.setSuccess(true);
		return entity;
	}
	
	/**
	 * 获取预约挂号列表
	 * @param user
	 * @return
	 */
	@RequestMapping("/getbooklist")
	@PostMapping
	public Entity getBookList(@RequestBody User user ){
		Entity entity = new Entity();
		List<BookPatient> bookPatientList =  accountService.getBookList(user);
		Integer count =  accountService.getBookListCount(user);//获取预约挂号列表总条数
		entity.setSuccess(true);
		entity.setResult(bookPatientList);
		entity.setTotal(count);
		return entity;
	}
	
	/**
	 * 验证账户名是否存在
	 * @param user
	 * @return
	 */
	@RequestMapping("/checkname")
	@PostMapping
	public Entity checkName(@RequestBody User user ){
		Entity entity = new Entity();
		boolean check = accountService.checkName(user.getUserName());
		
		if(check){
			entity.setSuccess(true);
		}
		
		return entity;
	}
	
	/**
	 * 获取用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/getwechat")
	@PostMapping
	public Entity getWechat(@RequestBody User user ){
		Entity entity =new Entity();
		List<User> users = accountService.getWechat(user);
		Integer count =  accountService.getWechatCount(user);
		entity.setResult(users);
		entity.setSuccess(true);
		entity.setTotal(count);
		
		return entity;
	}
	
	/**
	 * 获取日志信息
	 * 
	 * @return
	 */
	@RequestMapping("/getlogin")
	@PostMapping
	public Entity getLogin(@RequestBody User user ){
		Entity entity =new Entity();
		List<User> users = accountService.getLogin(user);
		Integer count =  accountService.getLoginCount(user);
		entity.setResult(users);
		entity.setSuccess(true);
		entity.setTotal(count);
		
		return entity;
	}
	
}
