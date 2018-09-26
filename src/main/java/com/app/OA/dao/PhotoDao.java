package com.app.OA.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.app.OA.domain.Photo;

@Component
public interface PhotoDao {
	
	
	/**
	 * 增加图
	 * @param createTime 
	 * 
	 * 
	 * @throws IOException 
	 */
	void add(@Param(value = "photo") Photo photo);

	/**
	 * 删除图
	 * 
	 * 
	 * @param id 所要删除轮播图的编号 
	 * @return
	 */
	void delete(@Param(value = "id")Integer id);
	
	/**
	 * 修改图(修改图片相关 )
	 * 
	 * @param 
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	void updatePhoto(@Param(value = "photo") Photo photo);

	/**
	 * 查询所有的轮播图
	 * 
	 * 
	 * @return
	 */
	List<Photo> selectAllPhoto(@Param(value = "photo") Photo photo);

	/**
	 * 更改图状态
	 * 
	 * 
	 * @return
	 */
	void changeStatus(@Param(value = "status") Integer status, @Param(value = "id") Integer id);

	/**
	 * 查询所有的图总数
	 * 
	 * 
	 * @return
	 */
	Integer selectAllPhotoCount(@Param(value = "photo") Photo photo);
	

	
}
