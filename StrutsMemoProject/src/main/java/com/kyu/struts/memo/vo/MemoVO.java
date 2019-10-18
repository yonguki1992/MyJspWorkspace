package com.kyu.struts.memo.vo;

import java.util.Date;

public class MemoVO {
	private int		idx;
	private String	name;
	private String	password;
	private String	memo;
	private Date	reg_date;
	private String	ip;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@Override
	public String toString() {
		return "MemoVO [idx=" + idx + ", name=" + name + ", password=" + password + ", memo=" + memo + ", reg_date="
				+ reg_date + ", ip=" + ip + "]";
	}
	
}
