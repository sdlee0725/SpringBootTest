package com.sdlee.stockRecommend;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class StockRecommendDAOTest {

	@Test
	void testGetEmployeeList() {
		System.out.println("ddddddddddddddddddd");
		StockRecommendDAO stockRecommendDAO = new StockRecommendDAO();
		
		List<StockRecommendDTO> stockRecommnedList = stockRecommendDAO.getEmployeeList();		
		for(StockRecommendDTO stock : stockRecommnedList ) {
			System.out.println(stock.toString());
		}
		System.out.println("eeeeeeeeeeeeeeeeeeeee");
		
		
		StockRecommendDTO stock = stockRecommendDAO.getStockOne("");
		System.out.println(stock);
		
	}

}
