package bam.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Util {

	public static String getDateStr() {
		Date date = new Date(Calendar.getInstance().getTimeInMillis());
		SimpleDateFormat sdf = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		return  sdf.format(date);
			
	}
		
}
