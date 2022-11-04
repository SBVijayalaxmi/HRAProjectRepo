package com.HRA.GenericLibraries;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {

	/*   just print   /** to get this      */
	/**
	 * This method is used to read data from property file
	 * @author ROOMAN
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertFile(String key) throws Throwable
	{
		/*Step1: get java representation of physical file*/
		FileInputStream fis = new FileInputStream(IPathConstants.FilePath);
		
		/*Step2: Create object for properties class*/
		Properties pObj = new Properties();
		
		/*Step3: Load the keys*/
		pObj.load(fis);

		/*Step4: get the value using getProperty*/
		String value = pObj.getProperty(key);
		
		/*return the value*/
		return value;
	
	}
	
}
