package com.snsoft.ElectricHeating.controller.apply;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snsoft.ElectricHeating.bean.apply.GetMyExamineBean;
import com.snsoft.ElectricHeating.service.apply.GetMyExamineService;
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
 * @date 2019年4月11日下午4:36:45
 * 
 * @Description TODO 获取我的审核接口 Controller
 */
@RestController
public class GetMyExamineController {

	@Autowired
	private GetMyExamineService service;

	@GetMapping("getMyExamine")
	public String getMyApply(HttpServletRequest request, HttpSession session) {
		// 返回结果
		String result = "";
		try {
			List<GetMyExamineBean> list = service.getMyExamine(session.getAttribute("loginmark").toString());
			if (list == null || list.isEmpty()) {
				result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "审核不存在");
			} else {
				result = JsonUtil.jsonResponse(list, AllConstant.CODE_SUCCESS, "查找成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, AllConstant.MSG_ERROR);
		}
		return result;
	}
}
