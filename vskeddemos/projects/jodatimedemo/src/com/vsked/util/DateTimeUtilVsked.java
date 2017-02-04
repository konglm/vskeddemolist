﻿package com.vsked.util;


import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;

public class DateTimeUtilVsked {
    private static final String FORMATE_DATE = "yyyy-MM-dd";  
    private static final String FORMATE_SECONDS = "HH:mm:ss";  
    private static final String FORMATE_FULL = FORMATE_DATE.concat(" ").concat(FORMATE_SECONDS); 
    static DateTime dt=new DateTime();
	
	/**
	 * 获取当前日期 如2015-07-15
	 * @return String 
	 */
	public static String getCurrentDate(String dateformat){
		return LocalDate.now().toString(dateformat);
	}
	
	/**
	 * 获取本周周一日期
	 * @return String
	 */
	public static String getMondayOfCurrentWeek(){
		return DateTime.now().dayOfWeek().withMinimumValue().toString(FORMATE_DATE);
	}
	
	/**
	 * 获取上周周一日期
	 * @return String
	 */
	public static String getMondayOfBeforeWeek(){
		return LocalDate.now().minusWeeks(1).dayOfWeek().withMinimumValue().toString(FORMATE_DATE, Locale.CHINESE);
	}
	
	/**
	 * 获取下周周一日期
	 * @return String
	 */
	public static String getMondayOfNextWeek(){
		return LocalDate.now().plusWeeks(1).dayOfWeek().withMinimumValue().toString(FORMATE_DATE, Locale.CHINESE);
	}
	
	/**
	 * 获取本周周末日期
	 * @return String
	 */
	public static String getSundayOfCurrentWeek(){
		return DateTime.now().dayOfWeek().withMaximumValue().toString(FORMATE_DATE);
	}
	
	/**
	 * 获取上周周末日期
	 * @return String
	 */
	public static String getSundayOfBeforeWeek(){
		return LocalDate.now().minusWeeks(1).dayOfWeek().withMaximumValue().toString(FORMATE_DATE, Locale.CHINESE);
	}
	
	/**
	 * 获取上周周末日期
	 * @return String
	 */
	public static String getSundayOfNextWeek(){
		return LocalDate.now().plusWeeks(1).dayOfWeek().withMaximumValue().toString(FORMATE_DATE, Locale.CHINESE);
	}
	
	/**
	 * 获取本月第一天
	 * @return String
	 */
	public static String getFirstDayOfCurrentMonth(){
		return DateTime.now().dayOfMonth().withMinimumValue().toString(FORMATE_DATE);
	}
	
	/**
	 * 获取上月第一天
	 * @return String
	 */
	public static String getFirstDayOfBeforeMonth(){
		return DateTime.now().minusMonths(1).dayOfMonth().withMinimumValue().toString(FORMATE_DATE);
	}
	
	/**
	 * 获取本年第一天
	 * @return
	 */
	public static String getFirstDayOfCurrentYear(){
		return DateTime.now().dayOfYear().withMinimumValue().toString(FORMATE_DATE);
	}
	
	/**
	 * 获取下月第一天
	 * @return String
	 */
	public static String getFirstDayOfNextMonth(){
		return DateTime.now().plusMonths(1).dayOfMonth().withMinimumValue().toString(FORMATE_DATE);
	}
	
	/**
	 * 获取上年第一天
	 * @return String
	 */
	public static String getFirstDayOfBeforeYear(){
		return DateTime.now().minusYears(1).dayOfYear().withMinimumValue().toString(FORMATE_DATE);
	}
	
	/**
	 * 获取下年第一天
	 * @return String
	 */
	public static String getFirstDayOfNextYear(){
		return DateTime.now().plusYears(1).dayOfYear().withMinimumValue().toString(FORMATE_DATE);
	}
	
	//TODO will goon  wirte
	public static String getFirstDayOfCurrentSeason(){
		return dt.getMonthOfYear()/3+"";
	}
	
	
	/**
	 * 获取本月最后一天
	 * @return String
	 */
	public static String getLastDayOfCurrentMonth(){
		return DateTime.now().dayOfMonth().withMaximumValue().toString(FORMATE_DATE);
	}
	
	/**
	 * 获取上月最后一天
	 * @return String
	 */
	public static String getLastDayOfBeforeMonth(){
		return DateTime.now().minusMonths(1).dayOfMonth().withMaximumValue().toString(FORMATE_DATE);
	}
	
	/**
	 * 获取下月最后一天
	 * @return String
	 */
	public static String getLastDayOfNextMonth(){
		return DateTime.now().plusMonths(1).dayOfMonth().withMaximumValue().toString(FORMATE_DATE);
	}
	
	/**
	 * 获取本年最后一天
	 * @return
	 */
	public static String getLastDayOfCurrentYear(){
		return DateTime.now().dayOfYear().withMaximumValue().toString(FORMATE_DATE);
	}
	
	/**
	 * 获取上年最后一天
	 * @return
	 */
	public static String getLastDayOfBeforeYear(){
		return DateTime.now().minusYears(1).dayOfYear().withMaximumValue().toString(FORMATE_DATE);
	}
	
	/**
	 * 获取下年最后一天
	 * @return String
	 */
	public static String getLastDayOfNextYear(){
		return DateTime.now().plusYears(1).dayOfYear().withMaximumValue().toString(FORMATE_DATE);
	}
	
	/**
	 * 计算两个日期之间相隔多少天
	 * @param startDate
	 * @param endDate
	 * @return int
	 */
	public static int getDaysBetweenTwoDate(DateTime startDate,DateTime endDate){
		return new Period(startDate,endDate,PeriodType.days()).getDays();
	}

}
