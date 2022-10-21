package com.sdlee.stockRecommend;

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

import com.sdlee.stockRecommend.*;

@Service
public class StockRecommendService  {	
	
	@Autowired
	StockRecommendDAO dao;
	
	public StockRecommendDTO getStockOne(String ticker) {				
//		StockRecommendDTO stock =  new StockRecommendDTO();
//		stock = dao.getStockOne(ticker);
		return dao.getStockOne(ticker);
	}
	
	public List<StockRecommendDTO> getStockList() {				
		return dao.getEmployeeList();
	}
		
		

}
