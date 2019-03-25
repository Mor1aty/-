package com.snsoft.ElectricHeating.controller.user;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snsoft.ElectricHeating.service.user.RegisterService;
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
 * @date 2019年3月25日下午3:58:27
 * 
 * @Description TODO 注册接口 Controller
 */
@RestController
public class RegisterController {
	@Autowired
	RegisterService service;

	@PostMapping("register")
	public String register(HttpServletRequest request) {
		// 返回结果
		String result = "";
		try {
			// 解析请求参数
			HashMap<String, String> params = JsonUtil.getRequestParams(request);
			// 参数校验
			result = HttpUtil.checkParams(params, new String[] { "account", "pwd", "nickname", "gender", "age" });
			// 校验不通过，适用于需要请求参数的情况
			if (!"".equals(result.trim())) {
				return result;
			}
			int i = service.judgeUserExist(params.get("account"));
			if (i == 0) {
				// 不存在用户帐号
				i = service.register(params.get("account"), params.get("pwd"), params.get("nickname"),
						Integer.parseInt(params.get("gender")), Integer.parseInt(params.get("age")));
				if (i > 0) {
					result = JsonUtil.jsonResponse(null, AllConstant.CODE_SUCCESS, "注册成功");
				} else {
					result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "注册失败");
				}
			} else {
				result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "帐号已经存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, AllConstant.MSG_ERROR);
		}
		return result;
	}
}
