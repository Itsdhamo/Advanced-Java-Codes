package j2ee.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class j2ee2 {
	public static void main(String[] args) throws SQLException {
		// step 1
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		// step2
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
		// step3
		Statement st = conn.createStatement();
		// step4
		ResultSet rs = st.executeQuery("select contactno from student where name='shruthi nisha';");
		while (rs.next()) {
			System.out.println(rs.getLong(1));
		}
		// step5
		conn.close();

	}
}
