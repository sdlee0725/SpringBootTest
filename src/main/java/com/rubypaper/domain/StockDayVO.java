package com.rubypaper.domain;

import java.util.Date;

import lombok.*;

@Data
public class StockDayVO {	
	private String yyyymmdd;
	private String ticker;
	private String tickerName;
	private int BPS;
	private int PER;
	private int EPS;
	private int DPS;
	private int startPrice;
	private int highPrice;
	private int lowPrice;
	private int endPrice;
	
} 

