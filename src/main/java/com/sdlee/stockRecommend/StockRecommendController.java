package com.sdlee.stockRecommend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdlee.stockRecommend.*;

@RestController
@RequestMapping("/api/v1/stockRecommend")
public class StockRecommendController {
	@Autowired
	private StockRecommendService stockRecommendService;
	
	
	@GetMapping("/stockToday")
	public String hello(String name) {
		return stockRecommendService.getStockList().get(1).getTickerName();
	}
	
	@GetMapping("/stockOne")
	public StockRecommendDTO getStockDay() {
		return stockRecommendService.getStockList().get(1);
	}
	
	@GetMapping("/stockList")
	public List<StockRecommendDTO> getStockDayList() {
		return stockRecommendService.getStockList();
	}

	public StockRecommendController() {
		System.out.println("===> StockRecommendController 생성");
	}

}
