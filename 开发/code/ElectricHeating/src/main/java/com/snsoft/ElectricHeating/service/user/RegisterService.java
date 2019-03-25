package com.snsoft.ElectricHeating.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snsoft.ElectricHeating.mapper.user.RegisterMapper;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年3月25日下午3:54:58
 * 
 * @Description TODO 
 *	注册接口 Service
 */
@Service
public class RegisterService {
	@Autowired(required=false)
	RegisterMapper mapper;
	
	// 判断用户帐号是否存在
	public Integer judgeUserExist(String account) {
		return mapper.judgeUserExist(account);
	}
	
	// 注册用户
	public Integer register(String account, String pwd, String nickname, Integer gender, Integer age) {
		return mapper.register(account, pwd, nickname, gender, age);
	}
}
