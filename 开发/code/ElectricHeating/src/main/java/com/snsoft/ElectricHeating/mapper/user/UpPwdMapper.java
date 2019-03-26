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
 * @date 2019年3月26日下午1:15:29
 * 
 * @Description TODO 修改密码接口 Mapper
 */
public interface UpPwdMapper {

	@Update("UPDATE user SET pwd=#{newPwd} WHERE account=#{account} AND pwd=#{oldPwd}")
	public Integer upPwd(String account, String oldPwd, String newPwd);
}
