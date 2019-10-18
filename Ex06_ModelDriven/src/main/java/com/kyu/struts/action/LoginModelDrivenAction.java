package com.kyu.struts.action;

import com.kyu.struts.vo.UserVO;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class LoginModelDrivenAction implements Action, ModelDriven<UserVO> {

	@Override
	// 1. modelDriven 인터페이스 구현
	public UserVO getModel() {	
		return user;
	}
	// 2. 반드시 사용자가 객체를 생성해 주어야 함.
	private UserVO user = new UserVO();
	@Override
	public String execute() throws Exception {
		if("admin".equals(user.getUserID()) && "admin".equals(user.getPassword())){
			user.setUserName("최고 관리자");
			return SUCCESS;
		}else{
			return INPUT;
		}
	}

}
