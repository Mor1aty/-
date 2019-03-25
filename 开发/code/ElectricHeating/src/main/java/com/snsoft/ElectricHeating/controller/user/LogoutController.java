package com.snsoft.ElectricHeating.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snsoft.ElectricHeating.utils.AllConstant;
import com.snsoft.ElectricHeating.utils.JsonUtil;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年3月25日下午3:43:59
 * 
 * @Description TODO 
 *	注销接口 Controller
 */
@RestController
public class LogoutController {
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginmark");
		return JsonUtil.jsonResponse(null, AllConstant.CODE_SUCCESS, "注销成功");
	}
}
