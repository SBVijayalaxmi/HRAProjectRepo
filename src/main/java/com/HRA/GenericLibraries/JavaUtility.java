package com.HRA.GenericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	
/**
 * This is used to get Random number
 * @author ROOMAN
 * @return
 */
	public int getRandomNumber()
	{
		Random ran = new Random();
		int random = ran.nextInt(10000);
		return random;
	}
	
	
	/**
	 * This method is used to get the System Date
	 * @author ROOMAN
	 * @return
	 */
	public String getSystemDate()
	{
		Date date = new Date();
		String systemdate = date.toString();
		return systemdate;
	}
	
	
	/**
	 * This method is used to get System date and date in format
	 * @author ROOMAN
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/mm/yyyy HH:MM:SS");
		Date systemdate = new Date();
		String getDateAndTime = dateformat.format(systemdate);
		System.out.println(getDateAndTime);
		return getDateAndTime;
	}
}
