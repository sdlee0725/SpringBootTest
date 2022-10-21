package com.rubypaper.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rubypaper.domain.BoardVO;
import com.rubypaper.domain.StockDayVO;
class StockDayServiceTest {

	@Test
	void testGetStockList() {
		//fail("Not yet implemented");
		StockDayService stockDayService = new StockDayServiceImpl();
		System.out.println(stockDayService.toString());
		
		for(StockDayVO stock:stockDayService.getStockList()) {
			System.out.println("------"+stock.getTicker()+"--------");			
			System.out.println(stock.getYyyymmdd());
			System.out.println(stock.getTickerName());
			System.out.println(stock.getStartPrice());
			System.out.println(stock.getHighPrice());
			System.out.println(stock.getLowPrice());
			System.out.println(stock.getEndPrice());
			
		}
	}

}
