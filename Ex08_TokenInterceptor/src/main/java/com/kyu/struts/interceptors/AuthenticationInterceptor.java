package com.kyu.struts.interceptors;

import com.opensymphony.xwork2.interceptor.Interceptor;

import java.util.Map;

import com.kyu.struts.vo.UserVO;
import com.kyu.struts.vo.UserVOAware;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;

public class AuthenticationInterceptor implements Interceptor {

	private static final long serialVersionUID = -5011962009065225959L;

	@Override
	public void destroy() {
		//release resources here
	}

	@Override
	public void init() {
		// create resources here
	}

	@Override
	public String intercept(ActionInvocation actionInvocation)
			throws Exception {
		System.out.println("inside auth interceptor");
		Map<String, Object> sessionAttributes = actionInvocation.getInvocationContext().getSession();
		
		UserVO vo = (UserVO) sessionAttributes.get("USER");
		
		if(vo == null){
			return Action.LOGIN;
		}else{
			Action action = (Action) actionInvocation.getAction();
			if(action instanceof UserVOAware){
				((UserVOAware) action).setUserVO(vo);
			}
			return actionInvocation.invoke();
		}
	}

}
