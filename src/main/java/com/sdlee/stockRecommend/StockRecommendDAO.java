package com.sdlee.stockRecommend;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

@Repository
public class StockRecommendDAO {
	private SqlSession mybatis;
	
	public StockRecommendDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("com/sdlee/stockRecommend/sql-map-config.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			mybatis = sessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	String s;

//	public void insertEmployee(EmployeeVO vo) {
//		System.out.println("===> MyBatis 기반으로 직원 등록 기능 처리");
//		mybatis.insert("EmployeeDAO.insertEmployee", vo);
//		mybatis.commit();
//	}
	
	
	public StockRecommendDTO getStockOne(String ticker) {		
		//return mybatis.selectList("StockDayDAO.getStockOne");
		return mybatis.selectOne("StockDayDAO.getStockOne");
	}
	
	public List<StockRecommendDTO> getEmployeeList() {		
		return mybatis.selectList("StockDayDAO.getStockDayList");
	}
}