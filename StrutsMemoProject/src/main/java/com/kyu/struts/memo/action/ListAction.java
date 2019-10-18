package com.kyu.struts.memo.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.kyu.struts.memo.service.MemoService;
import com.kyu.struts.memo.vo.MemoVO;
import com.kyu.struts.memo.vo.Paging;

public class ListAction {
	private Paging<MemoVO> pvo;
	private int currentPage;
	private int pageSize;
	private int blockSize;
	private int idx;
	private String br="<br>";
	private String newLine="\n";
	

	

	public Paging<MemoVO> getPvo() {
		return pvo;
	}

	public void setPvo(Paging<MemoVO> pvo) {
		this.pvo = pvo;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getBr() {
		return br;
	}

	public void setBr(String br) {
		this.br = br;
	}

	public String getNewLine() {
		return newLine;
	}

	public void setNewLine(String newLine) {
		this.newLine = newLine;
	}

	private HttpServletRequest request = ServletActionContext.getRequest();
	// 스트럿츠가 호출할 기본 메서드
	public String execute(){
		currentPage = 1;
		try {
			currentPage = Integer.parseInt((String)request.getParameter("p"));
		}catch (Exception e) {
			//e.printStackTrace();
		}
		pageSize = 10;
		try {
			pageSize = Integer.parseInt((String)request.getParameter("s"));
		}catch (Exception e) {
			//e.printStackTrace();
		}
		blockSize = 10;
		try {
			blockSize = Integer.parseInt((String)request.getParameter("b"));
		}catch (Exception e) {
			//e.printStackTrace();
		}
		idx = 0;
		try {
			idx = Integer.parseInt((String)request.getParameter("idx"));
		}catch (Exception e) {
			//e.printStackTrace();
		}
		setPvo(MemoService.getInstance().selectList(currentPage, pageSize, blockSize));
		return "success";
	}
}
