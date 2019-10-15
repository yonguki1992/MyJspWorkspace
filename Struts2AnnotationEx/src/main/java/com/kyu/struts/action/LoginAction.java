package com.kyu.struts.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Action(value = "login", results = { 
		@Result(name = "success", location = "/WEB-INF/contents/welcome.jsp"),
		@Result(name = "error", location = "/WEB-INF/contents/error.jsp") })
@Namespaces(value = { @Namespace("/hello"), @Namespace("/") })
public class LoginAction extends ActionSupport {
	public String execute() throws Exception {
		if("yonguki1992".equals(getName()) && "1234".equals(getPwd()))
			return SUCCESS;
		else return ERROR;
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
