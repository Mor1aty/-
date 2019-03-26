package com.snsoft.ElectricHeating.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snsoft.ElectricHeating.mapper.user.UpPwdMapper;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年3月26日下午1:17:52
 * 
 * @Description TODO 修改密码接口 Service
 */
@Service
public class UpPwdService {

	@Autowired(required = false)
	UpPwdMapper mapper;

	public Integer upPwd(String account, String oldPwd, String newPwd) {
		return mapper.upPwd(account, oldPwd, newPwd);
	}
}
