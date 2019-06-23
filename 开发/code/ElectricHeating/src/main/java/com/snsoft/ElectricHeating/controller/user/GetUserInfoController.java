package com.snsoft.ElectricHeating.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snsoft.ElectricHeating.bean.user.GetUserInfoBean;
import com.snsoft.ElectricHeating.service.user.GetUserInfoService;
import com.snsoft.ElectricHeating.utils.AllConstant;
import com.snsoft.ElectricHeating.utils.JWTUtil;
import com.snsoft.ElectricHeating.utils.JsonUtil;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年3月25日下午4:27:29
 * 
 * @Description TODO 获取个人信息接口 Controller
 */
@RestController
public class GetUserInfoController {
	@Autowired
	GetUserInfoService service;

	@GetMapping("getUserInfo")
	public String getUserInfo(HttpServletRequest request, HttpSession session) {
		// 返回结果
		String result = "";
		try {
			GetUserInfoBean userInfo = service.getUserInfo(JWTUtil.getPlaintextMap(request).get("account").toString());
			if (userInfo == null) {
				result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "获取失败");
			} else {
				result = JsonUtil.jsonResponse(userInfo, AllConstant.CODE_SUCCESS, "获取成功");
			}
		} catch (Exception e) {
			result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, AllConstant.MSG_ERROR);
		}
		return result;
	}
}
