package com.snsoft.ElectricHeating.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snsoft.ElectricHeating.mapper.user.SetUserInfoMapper;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年3月26日下午1:04:26
 * 
 * @Description TODO 设置个人信息接口 Service
 */
@Service
public class SetUserInfoService {
	@Autowired(required = false)
	SetUserInfoMapper mapper;

	public Integer setUserInfo(String nickname, Integer gender, Integer age, String phone, String account) {
		return mapper.setUserInfo(nickname, gender, age, phone, account);
	}
}
