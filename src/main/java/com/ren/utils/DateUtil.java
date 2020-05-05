package com.ren.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 获取指定时间
 * @author 任振星
 * rzx_365880@163.com
 * 306524624
 * 2017年6月29日 下午2:09:13
 * com.xinxing.utils
 * XinxingWeb
 */
public class DateUtil {
	/**
	 * 获取当天时间的开始
	 * @return
	 */
	public static Long getTodayStartTime(){  
        Calendar todayStart = Calendar.getInstance();  
        todayStart.set(Calendar.HOUR_OF_DAY, 0);  
        todayStart.set(Calendar.MINUTE, 0);  
        todayStart.set(Calendar.SECOND, 0);  
        todayStart.set(Calendar.MILLISECOND, 0);  
        return todayStart.getTime().getTime();
    }  
     /**
      * 获取当天时间的结束
      * @return
      */
	public static Long getTodayEndTime(){  
        Calendar todayEnd = Calendar.getInstance();  
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);  
        todayEnd.set(Calendar.MINUTE, 59);  
        todayEnd.set(Calendar.SECOND, 59);  
        todayEnd.set(Calendar.MILLISECOND, 999);  
        return todayEnd.getTime().getTime();  
    }

	
	/**
	 * 获得本周一0点时间
	 * @return
	 */
	public static Long getWeekStartTime(){
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0,0);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return cal.getTimeInMillis();
	}
	
	/**
	 * 获得本周日24点时间
	 * @return
	 */
	public static Long getWeekEndTime(){
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0,0);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return cal.getTime().getTime()+ (7 * 24 * 60 * 60 * 1000);
	}
	
	/**
	 * 获得本月第一天0点时间
	 * @return
	 */
	public static Long getMonthStartTime(){
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0,0);
		cal.set(Calendar.DAY_OF_MONTH,cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return cal.getTimeInMillis();
	}
	
	
	/**
	 * 获得本月最后一天24点时间
	 * @return
	 */
	public static Long getMonthEndTime(){
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0,0);
		cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY, 24);
		return cal.getTimeInMillis();
	}
	
	/**
	 * 获取指定年月日的时间戳  月份&日期 -1
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static Long getDayStartTime(int year,int month,int day){
		Calendar cal = Calendar.getInstance();
		cal.set(year,month, day, 0, 0,0);
		cal.set(Calendar.HOUR_OF_DAY, 24);
		return cal.getTime().getTime();
	}
	
	/**
	 * 需要注意的是：月份是从0开始的，比如说如果传5的话，实际上是6月份，千万不要搞错了哦  
	 * 获取指定月份的最后时间戳
	 * @param year
	 * @param month
	 * @return
	 */
    public static Long getLastDayOfMonth(int year, int month) {     
        Calendar cal = Calendar.getInstance();     
        cal.set(year,month, cal.get(Calendar.DAY_OF_MONTH), 0, 0,0);
        cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 24);
        return cal.getTimeInMillis();
    }
    /**
     * 需要注意的是：月份是从0开始的，比如说如果传5的话，实际上是6月份，千万不要搞错了哦  
     * 获取指定月份第一天时间戳
     * @param year
     * @param month
     * @return
     */
    public static Long getFirstDayOfMonth(int year, int month) {     
        Calendar cal = Calendar.getInstance();     
        cal.set(year,month, cal.get(Calendar.DAY_OF_MONTH), 0, 0,0);
        cal.set(Calendar.DAY_OF_MONTH,cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTimeInMillis();
    }
    
    /**
     * 获取当前时间的年月日 获取的月份需 + 1
     * @return
     */
    public static HashMap<String, Integer> getThisTime(){
    	HashMap<String, Integer> thisTime = new HashMap<>();
    	Calendar cal = Calendar.getInstance();
    	thisTime.put("year", cal.get(Calendar.YEAR));
    	thisTime.put("month", cal.get(Calendar.MONTH));
    	thisTime.put("day", cal.get(Calendar.DAY_OF_MONTH));
    	return thisTime;
    }
    
    /**
     * 获取某年某月总共有多少天
     * @param year
     * @param month
     * @return
     */
    public static int getDayNum(int year, int month){
    	Calendar cal = Calendar.getInstance();
    	cal.set(year, month,0);
    	int day = cal.get(Calendar.DAY_OF_MONTH);
    	return day;
    }
    
    /**
	 * 获取当时日期时间
	 * @return yyyy-MM-dd HH:mm:ss
	 */
    public static String getThisDateTime(){
		Date data = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String thisTime = simpleDateFormat.format(data);
		return thisTime;
	}
    
    /**
	 * 微秒时间戳转日期
	 * @param stamp 微秒时间戳
	 * @return 时间 yyyy-MM-dd HH:mm:ss
	 */
	public static String toDate(String stamp){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long lt = new Long(stamp);
		Date date = new Date(lt);
		String str = simpleDateFormat.format(date);
		return str;
	}
	
	/**
	 * 微秒时间戳转日期
	 * @param stamp 微秒时间戳
	 * @param type yyyy-MM-dd
	 * @return 时间 
	 */
	public static String toDate(String stamp,String type){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type);
		Long lt = new Long(stamp);
		Date date = new Date(lt);
		String str = simpleDateFormat.format(date);
		return str;
	}
	
	/**
	 * 指定年月日转换时间戳 (秒)
	 * @param s 指定时间
	 * @return 时间戳
	 * @throws ParseException 
	 */
    public static int dateToStamp(String s) throws ParseException{
    	int res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime()/1000;
        res = (int) ts;
        return res;
    }
    
	
	/**
	 * 获取年月日文件夹格式
	 * @return 时间
	 */
	public static String getMonthDay() { 
	    Calendar cal = Calendar.getInstance(); 
	    int year = cal.get(Calendar.YEAR); 
	    int month = cal.get(Calendar.MONTH) + 1; 
	    int day = cal.get(Calendar.DAY_OF_MONTH); 
	    return year + "/" + month + "/" + day;
	 } 
	
	/**
	 * 获取年月日订单格式
	 * @return 时间
	 */
	public static String getMonthDayToOrderNum() { 
	    Date date = new Date();
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
	    return simpleDateFormat.format(date);
	 }
	
	/**
	 * 获取时间内每日的开始时间和结束时间
	 * @param startTime 开始时间戳
	 * @param endTime 结束时间戳
	 * @return 
	 */
	public static List<Integer> getEverydayByStartAndEnd(int startTime,int endTime) {
		List<Integer> list = new ArrayList<>();
		int i = 0;
		while (true) {
			if(startTime + (24*3600 * i) > endTime) {
				break;
			}else {
				list.add( startTime + (24*3600 * i));
			}
			i++;
		}
		return list;
	}
	
	/**
	 * 获取时间内每周的开始结束时间 周日为一周的开始。
	 * @param startTime
	 * @param endTime
	 * @return 
	 * @throws ParseException 
	 */
	public static List<Integer> getWeeklyByStartAndEnd(String start,int startTime,int endTime) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式  
        Calendar cal = Calendar.getInstance();
        Date time=sdf.parse(start);
        cal.setTime(time);  
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天  
        
        List<Integer> list = new ArrayList<>();
        list.add(startTime);
        int thisWeekEndTime = startTime + 24*3600*(7 - dayWeek + 1);
        int i = 0;
        while(true) {
        	if((thisWeekEndTime + 24*3600*7*i) >= endTime) {
        		list.add(endTime);
        		break;
        	}else {
        		list.add(thisWeekEndTime + 24*3600*7*i);
        	}
        	i++;
        }
        return list;
	}
	
	/**
	 * 获取指定时间段内月的开始结束时间戳
	 * @param startYear
	 * @param endYear
	 * @param startMonth
	 * @param endMonth
	 * @return 
	 */
	public static List<Integer> getMonthByStartAndEnd(int startYear,int endYear,int startMonth,int endMonth) {
		List<Integer> list = new ArrayList<>();
		int num = (endYear - startYear) * 12 + endMonth - startMonth;
		int j = 0; //是否为同一个月的标识
		if(num == 0) { //是同一个月，为了下面的循环和判断 月份的数量+1
			j++; 
			num++;
		}
		for(int i=0;i<num;i++) {
			if(startMonth - 1 + i == 12) {
				startYear++;
				startMonth = 1-i;
			}
			list.add((int)(DateUtil.getFirstDayOfMonth(startYear, startMonth-1+i) / 1000));
			if(i == num - 1 && j == 0) {
				list.add((int)(DateUtil.getFirstDayOfMonth(endYear, endMonth-1) / 1000));
				list.add((int)(DateUtil.getLastDayOfMonth(endYear, endMonth-1) / 1000));
			}else if(i == num - 1 && j == 1){
				list.add((int)(DateUtil.getLastDayOfMonth(endYear, endMonth-1) / 1000));
			}
		}
		return list;
	}
	
	/**
	 * 获取时间内 每年的时间戳
	 * @param startYear
	 * @param endYear
	 * @return 
	 */
	public static List<Integer> getYearByStartAndEnd(int startYear,int endYear) {
		int num = endYear - startYear;
		List<Integer> list = new ArrayList<>();
		if(num == 0) {
			list.add((int) (DateUtil.getFirstDayOfMonth(startYear, 0) /1000));
			list.add((int) (DateUtil.getFirstDayOfMonth(endYear+1, 0) /1000));
		}else {
			for(int i = 0;i<num;i++) {
				list.add((int) (DateUtil.getFirstDayOfMonth(startYear+i, 0) /1000));
				if(i == num - 1) {
					list.add((int) (DateUtil.getFirstDayOfMonth(endYear, 0) /1000));
					list.add((int) (DateUtil.getFirstDayOfMonth(endYear+1, 0) /1000));
				}
			}
		}
		return list;
	}
	
	
	
	
	
}
