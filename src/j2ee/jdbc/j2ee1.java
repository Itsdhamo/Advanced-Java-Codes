package j2ee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class j2ee1 {
	// Insert the records
	public static void main(String[] args) {
		try {
			// step 1
			Driver d = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(d);

			// step 2
			String path = "jdbc:mysql://localhost:3306/db1";
			Connection conn = DriverManager.getConnection(path, "root", "root");

			// step 3
			Statement st = conn.createStatement();
			String query = "insert into student values(3,'Kamala',7094885981)";
			int result1 = st.executeUpdate(query);

			// process the result
			System.out.println(result1 + " rows affected");

			// step5
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
