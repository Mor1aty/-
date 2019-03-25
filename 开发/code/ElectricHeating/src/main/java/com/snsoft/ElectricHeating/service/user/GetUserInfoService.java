package com.snsoft.ElectricHeating.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snsoft.ElectricHeating.bean.user.GetUserInfoBean;
import com.snsoft.ElectricHeating.mapper.user.GetUserInfoMapper;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年3月25日下午4:25:55
 * 
 * @Description TODO 
 *	获取个人信息接口 Service
 */
@Service
public class GetUserInfoService {
	@Autowired(required=false)
	GetUserInfoMapper mapper;
	
	public GetUserInfoBean getUserInfo(String account) {
		return mapper.getUserInfo(account);
	}
}
