package com.app.OA.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.OA.domain.Entity;
import com.app.OA.domain.Photo;
import com.app.OA.domain.User;
import com.app.OA.service.AccountService;
import com.app.OA.service.PhotoService;

/***
 * 轮播图管理
 * @author 邵子城 2018/8/2
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/photo")
public class PhotoController {

	final static Logger logger = LoggerFactory.getLogger(PhotoController.class);
	
	@Autowired
	PhotoService photoService;
	
	@Autowired
	AccountService accountService;
	
	/**
	 * 上传文件
	 * 
	 * @param file 上传的图片
	 * @throws IOException 
	 */
	@RequestMapping("/upload")
	@PostMapping
	public Entity upload(@RequestBody MultipartFile file ) throws IOException {
		Entity entity= new Entity();
		try {
			String photoName = photoService.upload(file);
			entity.setSuccess(true);
			entity.setResult(photoName);
			entity.setMessage("文件上传成功");
		} catch (Exception e) {
			entity.setMessage(e.toString());
			entity.setSuccess(false);
		}
		return entity;
	}
	
	/**
	 * 删除上传文件
	 * 
	 * @param file 上传的图片
	 * @throws IOException 
	 */
	@RequestMapping("/deletephoto")
	@PostMapping
	public Entity deletephoto(@RequestBody Photo photo )  {
		Entity entity= new Entity();
		try {
			photoService.deletephoto(photo);
			entity.setSuccess(true);
			entity.setMessage("文件删除成功");
		} catch (Exception e) {
			entity.setMessage(e.toString());
			entity.setSuccess(false);
		}
		return entity;
	}
	
	/**
	 * 增加图
	 * 
	 * @param file 上传的图片
	 * @param text 上传的文案
	 * @param title 上传的文案标题
	 * @param createUserId 上传者id
	 * @throws IOException 
	 */
	@RequestMapping("/add")
	@PostMapping
	public Entity add(@RequestBody Photo photo ) throws IOException {
		Entity entity= new Entity();
		try {
			photoService.add(photo);
			entity.setSuccess(true);
			entity.setMessage("上传成功");
		} catch (Exception e) {
			entity.setSuccess(false);
			e.printStackTrace();
		}
			
		return entity;
	}
	
	/**
	 * 删除图
	 * 
	 * @param name 账户	
	 * @param passward	 密码
	 * @param id 所要删除轮播图的编号 
	 * @return
	 */
	@RequestMapping("/delete")
	@PostMapping
	public Entity delete(@RequestBody User user){
		Entity entity= new Entity();
		boolean check= accountService.checkPower(user.getName());
		if(check){
			photoService.delete(user);
			entity.setMessage("删除成功");
			entity.setSuccess(true);
		}else{
			entity.setMessage("账户权限不足");
			entity.setSuccess(false);
		}
		return entity;
	}
	
	/**
	 * 修改图
	 * 
	 * @param photo 要修改的内容
	 * @return
	 */
	@RequestMapping("/updatephoto")
	@PostMapping
	public Entity updatePhoto(@RequestBody Photo photo){
		Entity entity= new Entity();
		try {
			photoService.updatePhoto(photo);
			entity.setMessage("修改成功");
			entity.setSuccess(true);
		} catch (Exception e) {
			entity.setMessage("修改失败"+e.toString());
			entity.setSuccess(false);
		}
		return entity;
	}
	
	
	/**
	 * 查询所有的图
	 * 
	 * @param type 图片类型
	 * @param id 当前页
	 * @param status 每页条数
	 * @return
	 */
	@RequestMapping("/selectallphoto")
	@GetMapping
	public Entity selectAllPhoto(@RequestBody Photo photo) {
		Entity entity= new Entity();
		try {
			List<Photo> pootos = photoService.selectAllPhoto(photo);
			Integer count = photoService.selectAllPhotoCount(photo);
			entity.setResult(pootos);
			entity.setTotal(count);
			entity.setSuccess(true);
		} catch (Exception e) {
			entity.setMessage(e.toString());
			entity.setSuccess(false);
		}
		return entity;
	}
	
	/**
	 * 更改图状态
	 * 
	 * @param status
	 * @param id
	 * @return
	 */
	@RequestMapping("/changestatus")
	@GetMapping
	public Entity changeStatus(@RequestBody Photo photo) {
		Entity entity= new Entity();
		try {
			photoService.changeStatus(photo);
			entity.setSuccess(true);
		} catch (Exception e) {
			entity.setSuccess(false);
			entity.setMessage(e.toString());
		}
		return entity;
	}
	
	
	
	
	
	
}
