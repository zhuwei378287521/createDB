package zjw.generater.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import org.junit.Test;

public class CreatDate {

	public static String randomDate() {
		Random rndYear = new Random();
		int year = rndYear.nextInt(118) + 1900; // 生成[1900,2017]的整数；年
		Random rndMonth = new Random();
		int month = rndMonth.nextInt(12) + 1; // 生成[1,12]的整数；月
		Random rndDay = new Random();
		int Day = rndDay.nextInt(30) + 1; // 生成[1,30)的整数；日
		Random rndHour = new Random();
		int hour = rndHour.nextInt(23); // 生成[0,23)的整数；小时
		Random rndMinute = new Random();
		int minute = rndMinute.nextInt(60); // 生成分钟
		Random rndSecond = new Random();
		int second = rndSecond.nextInt(60); // 秒
		return (year + "-" + month + "-" + Day + "  " + hour + ":" + minute + ":" + second);
	}

	
	public static Date getCDate() {
		while(true) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date start = format.parse("1800-1-1");// 构造开始日期
			Date end = format.parse("2018-2-31");// 构造结束日期
			// getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
			if (start.getTime() >= end.getTime()) {
//				return null;
			}
			long date = random(start.getTime(), end.getTime());
//			Date d= new Date(date);
//			System.out.println(d);
			return new Date(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		return null;
	}}

	private static long random(long begin, long end) {
		long rtn = begin + (long) (Math.random() * (end - begin));
		// 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
		if (rtn == begin || rtn == end) {
			return random(begin, end);
		}
		return rtn;
	}
}
