package com.snsoft.ElectricHeating.mapper.apply;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.snsoft.ElectricHeating.bean.apply.GetMyApplyBean;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年4月11日下午3:58:03
 * 
 * @Description TODO 获取我的申请接口 Mapper
 */
public interface GetMyApplyMapper {

	// 获取我的申请
	@Select("SELECT * FROM unaudited_apply WHERE user=#{account}")
	public List<GetMyApplyBean> getMyApply(String account);
}
