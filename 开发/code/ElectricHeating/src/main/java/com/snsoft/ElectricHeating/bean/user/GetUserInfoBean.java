package com.snsoft.ElectricHeating.bean.user;
/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 © 2018
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2019年3月25日下午4:15:44
 * 
 * @Description TODO 
 *	获取个人信息接口 返回 Bean
 */
public class GetUserInfoBean {
	private String account;
	private String nickname;
	private Integer gender;
	private Integer age;
	private String portrait;
	private String phone;
	private Integer balance;
	@Override
	public String toString() {
		return "GetUserInfoBean [account=" + account + ", nickname=" + nickname + ", gender=" + gender + ", age=" + age
				+ ", portrait=" + portrait + ", phone=" + phone + ", balance=" + balance + "]";
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
}
