package ujeongri.com.gh.main.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test2 {
	
	public void con() throws ParseException {
		String date = "2020-07-25 08:30:00,000";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
		Date date1 = simpleDateFormat.parse(date);
		
		System.out.println(date1.getTime());
	}
	
	
}
