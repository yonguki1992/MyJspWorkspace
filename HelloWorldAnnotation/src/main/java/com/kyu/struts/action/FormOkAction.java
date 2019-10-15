package com.kyu.struts.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespaces(value={@Namespace("/hello"),@Namespace("/")})
@Action(value = "formOk", results = {
		@Result(name = "success", location = "/WEB-INF/contents/formOk.jsp"),
		@Result(name = "input", location = "/WEB-INF/contents/form.jsp") })
public class FormOkAction {
	private boolean flag;
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		flag = true;
	}
	
	@Override
	public String toString() {
		return "FormOkAction [name=" + name + ", age=" + age + "]";
	}


	// 스트럿츠가 알아서 호출하는 메서드
	public String execute() throws Exception {
		System.out.println("호출");

		if(!flag) {
			return "input";
		}
		System.out.println("리턴");

		return "success";
	}

}
