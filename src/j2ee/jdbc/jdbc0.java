package j2ee.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc0 {
	public static void main(String[] args) {
		try {
			// step1
			Driver d = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(d);
			// step2
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
			// step3
			Statement st = conn.createStatement();
			// step
			int result = st.executeUpdate("update employee set id=4 where id=33;");
			System.out.println(result + " is affected");
			// step5
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
