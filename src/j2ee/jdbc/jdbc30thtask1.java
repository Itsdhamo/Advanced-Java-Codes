package j2ee.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class jdbc30thtask1 {
	public static void main(String[] args) throws SQLException {
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
		PreparedStatement pst = conn.prepareStatement("insert into employee values(?,?,?,?)");
		Scanner sc = new Scanner(System.in);
		System.out.println("how many rows want to enter = ");
		int rows = sc.nextInt();
		for (int i = 0; i < rows; i++) {
			System.out.println("enter the id = ");
			int id = sc.nextInt();
			System.out.println("enter the name = ");
			String name = sc.next();
			System.out.println("enter the contactno = ");
			long contactno = sc.nextLong();
			System.out.println("enter the gender = ");
			String gender = sc.next();
			char[] arr = gender.toCharArray();
			gender = String.valueOf(arr[0]);
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setLong(3, contactno);
			pst.setString(4, gender);
			int result = pst.executeUpdate();
			System.out.println(result+" rows is created...");
		}
		conn.close();
	}
}
