package com.kyu.struts.memo.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kyu.struts.memo.dao.MemoDAO;
import com.kyu.struts.memo.mybatis.MyBatisUtil;
import com.kyu.struts.memo.vo.MemoVO;
import com.kyu.struts.memo.vo.Paging;


public class MemoService {
	private static MemoService instance = new MemoService();
	private MemoService() {
		// TODO Auto-generated constructor stub
	}
	public static MemoService getInstance() {
		return instance;
	}
	
	//
	public Paging<MemoVO> selectList(int currentPage, int pageSize, int blockSize){
		Paging<MemoVO> paging = null;
		SqlSession sqlSession = null;
		MemoDAO dao = null;
		try {
			sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
			dao = MemoDAO.getInstance();
			sqlSession.commit(false);
			int totalCount = dao.selectCount(sqlSession);
			
			paging = new Paging<>(totalCount, currentPage, pageSize, blockSize);
			List<MemoVO> list = dao.selectList(sqlSession, paging.getStartNo(), paging.getEndNo());
			paging.setList(list);
			sqlSession.commit();
		} catch (SQLException e) {
			// TODO: handle SQLException
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		
		return paging;
	}
	
	//
	public void insert(MemoVO vo) {
		SqlSession sqlSession = null;
		MemoDAO dao = null;
		try {
			sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
			dao = MemoDAO.getInstance();
			sqlSession.commit(false);
			
			if(vo !=null && vo.getName() != null && vo.getMemo() != null && vo.getPassword() != null){
				dao.insert(sqlSession, vo);
			}
			
			sqlSession.commit();
		} catch (SQLException e) {
			// TODO: handle SQLException
			sqlSession.rollback();
		} finally {
			sqlSession.close();

		}
	}
	
	//
	public void delete(MemoVO vo) {
		SqlSession sqlSession = null;
		MemoDAO dao = null;
		try {
			sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
			dao = MemoDAO.getInstance();
			sqlSession.commit(false);
			
			MemoVO dbvo = dao.selectByIdx(sqlSession, vo.getIdx());
			if(dbvo !=null && vo.getPassword().equals(dbvo.getPassword()) ){
				dao.delete(sqlSession, vo.getIdx());
			}
			
			sqlSession.commit();
		} catch (SQLException e) {
			// TODO: handle SQLException
			sqlSession.rollback();
		} finally {
			sqlSession.close();

		}
	}
	//2.
	public void update(MemoVO vo) {
		SqlSession sqlSession = null;
		MemoDAO dao = null;
		try {
			sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
			dao = MemoDAO.getInstance();
			sqlSession.commit(false);
			
			MemoVO dbvo = dao.selectByIdx(sqlSession, vo.getIdx());
			if(dbvo !=null && vo.getPassword().equals(dbvo.getPassword()) ){
				dao.update(sqlSession, vo);
			}
			
			sqlSession.commit();
		} catch (SQLException e) {
			// TODO: handle SQLException
			sqlSession.rollback();
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
	}
}
