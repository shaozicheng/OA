package com.app.OA.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.app.OA.domain.Power;

@Component
public interface PowerDao {

	/**
	 * 增加权限
	 * @param power 新增权限相关信息
	 * @return
	 */
	void add(@Param(value = "power") Power power);

	/**
	 * 删除权限
	 * @param name
	 * @return
	 */
	void delete(@Param(value = "id") Integer id);

	/**
	 * 修改权限
	 * @param power 要修改的权限内容
	 * @return
	 */
	void update(@Param(value = "power") Power power);

	/**
	 * 查询权限
	 * @param 
	 * @return
	 */
	List<Power> selectAll();

}
