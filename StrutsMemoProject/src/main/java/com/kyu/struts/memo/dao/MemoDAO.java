package com.kyu.struts.memo.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kyu.struts.memo.vo.MemoVO;


public class MemoDAO {
	private static MemoDAO instance = new MemoDAO();
	private MemoDAO() {
		// TODO Auto-generated constructor stub
	}
	public static MemoDAO getInstance() {
		return instance;
	}

	//1
	public int selectCount(SqlSession sqlSession) throws SQLException {
		return (int)sqlSession.selectOne("memo.selectCount");
	}
	
	//2
	public MemoVO selectByIdx(SqlSession sqlSession, int idx) throws SQLException {
		return sqlSession.selectOne("memo.selectByIdx", idx);
	}
	//3
	public List<MemoVO> selectList(SqlSession sqlSession, int startNo, int endNo) throws SQLException {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("startNo", startNo);
		map.put("endNo", endNo);
		
		return sqlSession.selectList("memo.selectList", map);
	}
	//2
	public void insert(SqlSession sqlSession, MemoVO vo) throws SQLException {
		sqlSession.insert("memo.insert", vo);
	}
	//2
	public void update(SqlSession sqlSession, MemoVO vo) throws SQLException {
		sqlSession.update("memo.update", vo);
	}
	//2
	public void delete(SqlSession sqlSession, int idx) throws SQLException {
		sqlSession.delete("memo.delete", idx);
	}
	
}

