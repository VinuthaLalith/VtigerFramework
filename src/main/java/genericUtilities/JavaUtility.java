package genericUtilities;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	/**
	 * This method will generate random number
	 * @return
	 */
	
	public int getRandomNumber() {
		
		Random r=new Random();
		return r.nextInt(1000);
		
	}
	/**
	 * This method will get date
	 * @return
	 */
	public String getSystemDate() {
		
		Date d=new Date();
		return d.toString();
	}
	/**
	 * This method will generate date in required format
	 * @return
	 */
	public String getSystemDateInFormat() {
		
		Date d=new Date();
		String[] dArr=d.toString().split(" ");
		String date=dArr[2];
		String month=dArr[1];
		String year=dArr[5];
		String time=dArr[3].replace(":", "-");
		return date+" "+month+" "+year+" "+time;
	}

}
