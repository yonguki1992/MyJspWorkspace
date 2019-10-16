package com.kyu.struts.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	// 폼검증하는 메서드
	@Override
	public void validate(){
		if("".equals(getName())){
			addFieldError("name", "UserName can't be empty");
		}
		if("".equals(getPwd())){
			addFieldError("pwd", "Password can't be empty");
		}
	}
	
	// Java Bean to hold the form parameters
	private String name;
	private String pwd;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
