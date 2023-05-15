package database.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTesting {
	public static void main(String[] args) throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/QADB", "root", "root");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("Select * from employeeinfo");
		while (rs.next()) {
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("location"));
			System.out.println(rs.getInt("age"));
		}
	}
}
