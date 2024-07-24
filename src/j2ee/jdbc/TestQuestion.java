package j2ee.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestQuestion {
	public static void main(String[] args) throws SQLException {
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");

		PreparedStatement pst = conn
				.prepareStatement("select name,(costprice-discount/100) as sellingprice from product");

		ResultSet res = pst.executeQuery();
		System.out.println();
		System.out.println("name  selling price");
		while (res.next()) {
			System.out.println(res.getString(1) + " " + res.getDouble(2));
		}
	}
}
