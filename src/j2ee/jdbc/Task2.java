package j2ee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class Task2 {
	public static void main(String[] args) throws SQLException {
		int count = 0;
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
		PreparedStatement pst = conn.prepareStatement("delete from student where id=?");
		Scanner sc = new Scanner(System.in);
		System.out.println("how may rows you want to delete =");
		int rows = sc.nextInt();
		for (int i = 0; i < rows; i++) {
			System.out.println("enter the id");
			int id = sc.nextInt();
			pst.setInt(1,id);
			count++;
		int result = pst.executeUpdate();
		result = count;
		//System.out.println(result);

	}
 		System.out.println(count +" row is deleted...");
		conn.close();
	}
}
