package com.snsoft.ElectricHeating.service.apply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snsoft.ElectricHeating.mapper.apply.ApplyMapper;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年4月2日下午7:56:27
 * 
 * @Description TODO 申请接口 Service
 */
@Service
public class ApplyService {

	@Autowired(required = false)
	private ApplyMapper mapper;

	public Integer insertApply(String content, String user) {
		return mapper.insertApply(content, user);
	}
}
