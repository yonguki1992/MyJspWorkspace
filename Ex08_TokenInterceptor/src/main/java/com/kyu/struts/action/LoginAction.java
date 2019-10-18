package com.kyu.struts.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.kyu.struts.vo.UserVO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements SessionAware, ModelDriven<UserVO>{

	private static final long serialVersionUID = -3369875299120377549L;

	@Override
	public String execute(){
		System.out.println("inside execute");
		if("admin".equals(vo.getUserName()) && "admin".equals(vo.getPassword())){
			vo.setUserName("admin");
			sessionAttributes.put("USER", vo);
			return SUCCESS;
		}
		return INPUT;
	}
	
	private UserVO vo = new UserVO();
	private Map<String, Object> sessionAttributes = null;

	@Override
	public void setSession(Map<String, Object> sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
	}
	
	@Override
	public UserVO getModel() {
		return vo;
	}
	
}
