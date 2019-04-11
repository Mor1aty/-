package com.snsoft.ElectricHeating.bean.apply;
/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年4月11日下午3:58:49
 * 
 * @Description TODO 
 *	获取我的申请接口 返回 Bean
 */
public class GetMyApplyBean {
	private int id;
	private String content;
	private String gmtApply;
	@Override
	public String toString() {
		return "GetMyApplyBean [id=" + id + ", content=" + content + ", gmtApply=" + gmtApply + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getGmtApply() {
		return gmtApply;
	}
	public void setGmtApply(String gmtApply) {
		this.gmtApply = gmtApply;
	}
}
