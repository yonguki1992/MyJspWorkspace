package com.kyu.struts.action;

// pojo(plain object java object)

public class HomeAction {
	public String execute() {
		setMsg("기본 excute()가 실행됩니다.");
		return "success";
	}
	public String method() {
		setMsg("method()가 실행됩니다.");
		return "success";
	}
	private String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "HomeAction [msg=" + msg + "]";
	}
	
}
