package com.snsoft.ElectricHeating.controller.apply;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snsoft.ElectricHeating.bean.apply.GetMyApplyBean;
import com.snsoft.ElectricHeating.service.apply.GetMyApplyService;
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
 * @date 2019年4月11日下午4:15:18
 * 
 * @Description TODO 获取我的申请接口 Controller
 */
@RestController
public class GetMyApplyController {

	@Autowired
	private GetMyApplyService service;

	@GetMapping("getMyApply")
	public String getMyApply(HttpServletRequest request, HttpSession session) {
		// 返回结果
		String result = "";
		try {
			List<GetMyApplyBean> list = service.getMyApply(session.getAttribute("loginmark").toString());
			if (list == null || list.isEmpty()) {
				result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "申请不存在");
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
