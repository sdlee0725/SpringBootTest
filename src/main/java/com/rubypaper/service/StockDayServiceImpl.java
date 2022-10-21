package com.rubypaper.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.StockDayVO;

@Service
public class StockDayServiceImpl implements StockDayService {
	// JDBC APIs	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private String LIST_STOCK = 
			" SELECT yyyymmdd, m.ticker, tickerName, startPrice, highPrice, lowPrice, endPrice "
			+ " FROM Stock_Master m, Stock_day d"
			+ " WHERE 1=1"
			+ "	AND m.ticker = d.ticker"
			+ " 	AND yyyymmdd = '20190812' limit 10 ";
			//+ " 	AND yyyymmdd = DATE_FORMAT(now(), '%Y%m%d') limit 10 ";
	
	@Override
	public List<StockDayVO> getStockList() {
		System.out.println("===> JDBC 기반으로 직원 목록 조회 기능 처리");
		System.out.println(LIST_STOCK);
		List<StockDayVO> stockList = new ArrayList<StockDayVO>();
		try {
			conn = getConnection();	
			stmt = conn.prepareStatement(LIST_STOCK);
			rs = stmt.executeQuery();
			while(rs.next()){
				StockDayVO stock = new StockDayVO();				
				
				
				stock.setYyyymmdd(rs.getString("yyyymmdd"));
				stock.setTicker(rs.getString("ticker"));
				stock.setTickerName(rs.getString("tickerName"));
				stock.setStartPrice(rs.getInt("startPrice"));
				stock.setHighPrice(rs.getInt("highPrice"));
				stock.setLowPrice(rs.getInt("lowPrice"));
				stock.setStartPrice(rs.getInt("endPrice"));
				stockList.add(stock);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, stmt, conn);
		}
		return stockList;
		
		
//		
//		
//		List<StockDayVO> stockList = new ArrayList<StockDayVO>();
//		for (int i = 1; i <= 10; i++) {
//			StockDayVO stock = new StockDayVO();
//			stock.setYyyymmdd(null);
//			stock.setTicker(null);
//			stock.setWriter("테스터getstockList");
//			stock.setContent(i + "번 내용입니다.");
//			stock.setCreateDate(new Date());
//			stock.setCnt(0);
//			stockList.add(stock);
//		}
		
	}
	
	
	
	// 커넥션 획득
	public Connection getConnection() {
		try {
//				Class.forName("org.h2.Driver");	
//				String url = "jdbc:h2:tcp://localhost/~/test";
//				conn = DriverManager.getConnection(url, "sa", "");	
			
			Class.forName("com.mysql.cj.jdbc.Driver");	
			String url = "jdbc:mysql://172.17.250.110/study?useSSL=false";			
			conn = DriverManager.getConnection(url, "study", "qwer1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
		
	// 커넥션 종료(ResultSet, Statement, Connection)
	public void close(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if(rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs = null;
		}
		
		try {
			if(stmt != null)
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}
		
		try {
			if(conn != null && !conn.isClosed())
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
	
	// 커넥션 종료(Statement, Connection)
	public void close(Statement stmt, Connection conn) {
		try {
			if(stmt != null)
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}
		
		try {
			if(conn != null && !conn.isClosed())
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}

}
