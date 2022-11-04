package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectVariable {
	public static void main(String[] args) throws SQLException  {
		
		int result=0;
		
		Driver driver = new Driver();
		/* Step 1: Register the database */
		DriverManager.registerDriver(driver);

		/* Step 2: Get connection for database */
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qspider", "root", "root");

		/* Step 3: Issue create statement */
		Statement stat = con.createStatement();
		String query = "insert into mysore values('Alu','Java',2)";

		/* Step 4: Execute query */
		result = stat.executeUpdate(query);
		
		if(result==1)
			System.out.println("data is updated");
		else
			System.out.println("data sis not updated");
		
		/* Step 5: Close the database */
		con.close();
	}

}


