package com.snsoft.ElectricHeating.service.apply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snsoft.ElectricHeating.bean.apply.GetMyExamineBean;
import com.snsoft.ElectricHeating.mapper.apply.GetMyExamineMapper;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年4月11日下午4:34:03
 * 
 * @Description TODO 获取我的审核接口 Service
 */
@Service
public class GetMyExamineService {

	@Autowired(required = false)
	private GetMyExamineMapper mapper;

	public List<GetMyExamineBean> getMyExamine(String account) {
		return mapper.getMyExamine(account);
	}
}
