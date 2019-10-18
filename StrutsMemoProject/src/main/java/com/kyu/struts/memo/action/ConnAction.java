package com.kyu.struts.memo.action;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.kyu.struts.memo.mybatis.MyBatisUtil;

public class ConnAction {
	private SqlSession	sqlSession;
	private String		today;
	private int			sum;
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public String execute(){
		setSqlSession(MyBatisUtil.getSqlSessionFactory().openSession());
		setToday(sqlSession.selectOne("test.selectToday"));
		HashMap<String, Integer> map = new HashMap<>();
		map.put("num1", 10);
		map.put("num2", 20);
		map.put("num3", 30);
		setSum(sqlSession.selectOne("test.getSum", map));
		return "success";
	}
}
