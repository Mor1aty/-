package com.snsoft.ElectricHeating.service.apply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snsoft.ElectricHeating.bean.apply.GetMyApplyBean;
import com.snsoft.ElectricHeating.mapper.apply.GetMyApplyMapper;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年4月11日下午4:11:54
 * 
 * @Description TODO 获取我的申请接口 Service
 */
@Service
public class GetMyApplyService {

	@Autowired(required = false)
	private GetMyApplyMapper mapper;

	public List<GetMyApplyBean> getMyApply(String account) {
		return mapper.getMyApply(account);
	}
}
