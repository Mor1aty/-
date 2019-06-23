package com.snsoft.ElectricHeating.controller.apply;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snsoft.ElectricHeating.service.apply.ApplyService;
import com.snsoft.ElectricHeating.utils.AllConstant;
import com.snsoft.ElectricHeating.utils.HttpUtil;
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
 * @date 2019年4月2日下午7:57:57
 * 
 * @Description TODO 申请接口 Controller
 */
@RestController
public class ApplyController {

	@Autowired
	private ApplyService service;

	@PostMapping("apply")
	public String apply(HttpServletRequest request, HttpSession session) {
		// 返回结果
		String result = "";
		try {
			// 解析请求参数
			HashMap<String, String> params = JsonUtil.getRequestParams(request);
			// 参数校验
			result = HttpUtil.checkParams(params, new String[] { "content" });
			// 校验不通过，适用于需要请求参数的情况
			if (!"".equals(result.trim())) {
				return result;
			}
			int i = service.insertApply(params.get("content"), JWTUtil.getPlaintextMap(request).get("account").toString());
			if(i > 0) {
				result = JsonUtil.jsonResponse(null, AllConstant.CODE_SUCCESS, "写入成功");
			}else {
				result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "写入失败");
			}
		} catch (Exception e) {
			result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, AllConstant.MSG_ERROR);
		}
		return result;

	}
}
