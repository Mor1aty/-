package com.snsoft.ElectricHeating.mapper.apply;

import org.apache.ibatis.annotations.Insert;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年4月2日下午7:52:20
 * 
 * @Description TODO 
 *	申请接口 Mapper
 */
public interface ApplyMapper {
	
	// 写入未审核申请
	@Insert("INSERT INTO unaudited_apply(content,user,gmt_apply) VALUES(#{content},#{user},now())")
	public Integer insertApply(String content,String user);
}
