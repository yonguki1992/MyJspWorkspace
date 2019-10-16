package com.kyu.struts.action;

public class FormOkAction {

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
	}
	
	@Override
	public String toString() {
		return "FormOkAction [name=" + name + ", age=" + age + "]";
	}


	// 스트럿츠가 알아서 호출하는 메서드
	public String execute() throws Exception {
		
		return "success";
	}

}
