package com.snsoft.ElectricHeating.mapper.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年3月25日下午3:50:02
 * 
 * @Description TODO 注册接口 Mapper
 */
public interface RegisterMapper {
	// 判断普通用户是否存在
	@Select("SELECT COUNT(*) FROM user WHERE account=#{account}")
	public Integer judgeUserExist(String account);

	// 注册用户
	@Insert("INSERT INTO user(account,pwd,nickname,gender,age,portrait,gmt_create) VALUES(#{account},#{pwd},#{nickname},#{gender},#{age},1,now())")
	public Integer register(String account, String pwd, String nickname, Integer gender, Integer age);
}
