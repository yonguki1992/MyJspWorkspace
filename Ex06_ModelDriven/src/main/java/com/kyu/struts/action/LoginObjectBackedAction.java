package com.kyu.struts.action;

import com.kyu.struts.vo.UserVO;
import com.opensymphony.xwork2.Action;

public class LoginObjectBackedAction implements Action {
	@Override
	public String execute() throws Exception {
		if (getUser() != null) {
			if ("admin".equals(getUser().getUserID()) && "admin".equals(getUser().getPassword())) {
				getUser().setUserName("최고 관리자!!!");
				return SUCCESS;
			} else {
				return INPUT;
			}
		} else {			
			return INPUT;
		}
	}

	private UserVO user; // VO를 변수로 선언

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}
}
