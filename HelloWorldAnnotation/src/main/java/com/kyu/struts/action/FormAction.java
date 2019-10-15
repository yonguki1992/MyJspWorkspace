package com.kyu.struts.action;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespaces(value={@Namespace("/hello"),@Namespace("/")})
@Result(location="/WEB-INF/contents/form.jsp")
@Actions(value={@Action("form")})


public class FormAction {
	// 스트럿츠가 알아서 호출하는 메서드
	public String execute() throws Exception {
		
		return "success";
	}
}
