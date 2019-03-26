package com.snsoft.ElectricHeating.mapper.user;

import org.apache.ibatis.annotations.Update;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年3月26日下午1:00:35
 * 
 * @Description TODO 设置个人信息接口 Mapper
 */
public interface SetUserInfoMapper {

	@Update("UPDATE user SET nickname=#{nickname},gender=#{gender},age=#{age},phone=#{phone} WHERE account=#{account}")
	public Integer setUserInfo(String nickname, Integer gender, Integer age, String phone, String account);
}
