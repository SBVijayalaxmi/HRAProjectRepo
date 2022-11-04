 package com.HRA.GenericLibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.cj.jdbc.Driver;


public class DatabaseUtility {
/**
 * This method is used to register and get the connection for the database
 * @author ROOMAN
 */
	Connection con = null;
	
	public void connectToDB() throws Throwable
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IPathConstants.dbURL, IPathConstants.dbUsername, IPathConstants.dbPassword);
	}
	
	
	/**
	 * This method is used to execute query and get the data for user
	 * @author ROOMAN
	 * @param query
	 * @param ColumnIndex
	 * @param expdata
	 * @param data
	 * @return 
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String query, int ColumnIndex, String expdata, String data) throws Throwable
	{
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			data = result.getString(ColumnIndex);
			if(data.equalsIgnoreCase(expdata))
			{
				flag = true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(data +"------> data verified");
			return expdata;
		}
		else
		{
			System.out.println(data +"------> data not verified");
			return "";
		}
	}
	
	
	/**
	 * This method is used to close the Database
	 * @author ROOMAN
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable
	{
	con.close();	
	}
}
