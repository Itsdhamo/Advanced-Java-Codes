package j2ee.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class jdbc30thtask2 {
	public static void main(String[] args) throws SQLException {
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?user=root&password=root");
		Scanner sc = new Scanner(System.in);
		PreparedStatement pst = conn.prepareStatement("select * from employee");
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(2) + " " + rs.getString(4) + " " + rs.getInt(1));
		}
		rs.close();
	}
}
