package j2ee.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc3 {
	public static void main(String[] args) {
		Driver d;
		try {
			//step1 load and register the driver...
			d = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(d);
			//step2 establish the connection...
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
			//step3 create the statement and issue the query...
			Statement st = conn.createStatement();
			//step4 process the result...
			ResultSet rs = st.executeQuery("select id,name,contactno from student where name like 's%' ;");
			while (rs.next()) {

				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getLong(3));
			}
			//step5 close the connection...
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
