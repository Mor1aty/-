package com.snsoft.ElectricHeating.bean.apply;
/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年4月11日下午4:29:45
 * 
 * @Description TODO 
 *	获取我的审核接口 返回 Bean
 */
public class GetMyExamineBean {
	private int id;
	private String content;
	private String gmtApply;
	private String isPass;
	private String reason;
	private String gmtAudit;
	@Override
	public String toString() {
		return "GetMyExamineBean [id=" + id + ", content=" + content + ", gmtApply=" + gmtApply + ", isPass=" + isPass
				+ ", reason=" + reason + ", gmtAudit=" + gmtAudit + "]";
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
	public String getIsPass() {
		return isPass;
	}
	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getGmtAudit() {
		return gmtAudit;
	}
	public void setGmtAudit(String gmtAudit) {
		this.gmtAudit = gmtAudit;
	}
}
