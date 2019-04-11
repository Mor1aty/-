package com.snsoft.ElectricHeating.mapper.apply;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.snsoft.ElectricHeating.bean.apply.GetMyExamineBean;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年4月11日下午4:31:41
 * 
 * @Description TODO 
 *	获取我的审核接口 Mapper
 */
public interface GetMyExamineMapper {
	
	// 获取我的审核
	@Select("SELECT * FROM auditing_apply WHERE user=#{account}")
	public List<GetMyExamineBean> getMyExamine(String account);
}
