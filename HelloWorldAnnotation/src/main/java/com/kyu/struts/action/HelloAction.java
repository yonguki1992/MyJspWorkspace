package com.kyu.struts.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespaces(value={@Namespace("/hello"),@Namespace("/")})
@Result(location="/WEB-INF/contents/hello.jsp")
@Actions(value={@Action(""),@Action("hello")})
public class HelloAction {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "HelloAction [msg=" + msg + "]";
	}
	
	// 스트럿츠가 알아서 호출하는 메서드
	public String execute() throws Exception {
		setMsg("반갑다 스트럿츠2");
		return "success";
	}

}
