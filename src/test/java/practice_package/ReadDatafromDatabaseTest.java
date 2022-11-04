package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDatafromDatabaseTest {

	public static void main(String[] args) throws SQLException {
		Driver driver = new Driver();
		/* Step 1: Register the database */
		DriverManager.registerDriver(driver);

		/* Step 2: Get connection for database */
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qspider", "root", "root");

		/* Step 3: Issue create statement */
		Statement stat = con.createStatement();
		String query = "select * from mysore";

		/* Step 4: Execute query */
		ResultSet result = stat.executeQuery(query);
		while (result.next()) {
			System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getString(3));
		}
		/* Step 5: Close the database */
		con.close();
	}

}
