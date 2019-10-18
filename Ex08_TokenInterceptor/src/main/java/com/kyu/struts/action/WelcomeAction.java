package com.kyu.struts.action;


import com.kyu.struts.vo.UserVO;
import com.kyu.struts.vo.UserVOAware;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class WelcomeAction extends ActionSupport implements UserVOAware, ModelDriven<UserVO> {

	private static final long serialVersionUID = 8111120314704779336L;

	@Override
	public String execute(){
		return SUCCESS;
	}
	
	private UserVO user;
	
	public void setUser(UserVO user) {
		this.user=user;
	}
	
	public UserVO getUser(UserVO user){
		return this.user;
	}

	@Override
	public UserVO getModel() {
		return this.user;
	}

	@Override
	public void setUserVO(UserVO vo) {
		// TODO Auto-generated method stub
		setUser(vo);
	}

}


