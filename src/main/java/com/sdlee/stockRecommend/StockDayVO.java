package com.sdlee.stockRecommend;

import java.util.Date;

import lombok.*;

@Data
public class StockDayVO {	
	private String ticker;
	private String yyyymmdd;	
	private int startPrice;
	private int highPrice;
	private int lowPrice;
	private int endPrice;
	private int volume;	
} 
