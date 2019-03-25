package com.snsoft.ElectricHeating.mapper.user;

import org.apache.ibatis.annotations.Select;

import com.snsoft.ElectricHeating.bean.user.GetUserInfoBean;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年3月25日下午4:22:29
 * 
 * @Description TODO 获取个人信息接口 Mapper
 */
public interface GetUserInfoMapper {
	@Select("SELECT account,nickname,gender,age,attach.file_location AS portrait,phone,balance,user.gmt_create FROM user LEFT JOIN attach ON user.portrait = attach.id WHERE user.account = #{account}")
	public GetUserInfoBean getUserInfo(String account);
}
