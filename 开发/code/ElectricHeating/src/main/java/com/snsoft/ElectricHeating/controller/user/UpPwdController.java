package com.snsoft.ElectricHeating.controller.user;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snsoft.ElectricHeating.service.user.UpPwdService;
import com.snsoft.ElectricHeating.utils.AllConstant;
import com.snsoft.ElectricHeating.utils.HttpUtil;
import com.snsoft.ElectricHeating.utils.JsonUtil;

/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年3月26日下午1:19:33
 * 
 * @Description TODO 修改密码接口 Controller
 */
@RestController
public class UpPwdController {
	@Autowired
	UpPwdService service;

	@PostMapping("upPwd")
	public String upPwd(HttpServletRequest request, HttpSession session) {
		// 返回结果
		String result = "";
		try {
			// 解析请求参数
			HashMap<String, String> params = JsonUtil.getRequestParams(request);
			// 参数校验
			result = HttpUtil.checkParams(params, new String[] { "oldPwd", "newPwd" });
			// 校验不通过，适用于需要请求参数的情况
			if (!"".equals(result.trim())) {
				return result;
			}
			int i = service.upPwd(session.getAttribute("loginmark").toString(), params.get("oldPwd"), params.get("newPwd"));
			if(i > 0) {
				result = JsonUtil.jsonResponse(null, AllConstant.CODE_SUCCESS, "修改成功");
			} else {
				result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "修改失败");
			}
		} catch (Exception e) {
			result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, AllConstant.MSG_ERROR);
		}
		return result;
	}
}
