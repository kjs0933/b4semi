package common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateFormatTemplate {
	
	public static String getTillDate(Timestamp timestamp)
	{
		SimpleDateFormat result = new SimpleDateFormat("YYYY-MM-dd");
		return result.format(timestamp);
	}
	
	public static String getTillMin(Timestamp timestamp)
	{
		SimpleDateFormat result = new SimpleDateFormat("YYYY-MM-dd hh:mm");
		return result.format(timestamp);
	}
	
	public static String getTillSec(Timestamp timestamp)
	{
		SimpleDateFormat result = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
		return result.format(timestamp);
	}
	
	public static String getTillMinKorLoc(Timestamp timestamp)
	{
		SimpleDateFormat result = new SimpleDateFormat("YYYY-MM-dd [hh시 mm분]");
		return result.format(timestamp);
	}
	
	public static String getTillSecKorLoc(Timestamp timestamp)
	{
		SimpleDateFormat result = new SimpleDateFormat("YYYY-MM-dd [hh시 mm분 ss초]");
		return result.format(timestamp);
	}
}
