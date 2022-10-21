package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.BoardVO;
import com.rubypaper.domain.StockDayVO;
import com.rubypaper.service.BoardService_old;
import com.rubypaper.service.StockDayService;

@RestController
public class StockDayController {
	@Autowired
	private StockDayService stockDayService;
	
	@GetMapping("/stockToday")
	public String hello(String name) {
		return stockDayService.getStockList().get(1).getTickerName();
	}
	
	@GetMapping("/stockOne")
	public StockDayVO getStockDay() {
		return stockDayService.getStockList().get(1);
	}
	
	@GetMapping("/stockList")
	public List<StockDayVO> getStockDayList() {
		return stockDayService.getStockList();
	}

	public StockDayController() {
		System.out.println("===> StockDayController 생성");
	}

}
