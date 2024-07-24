package j2ee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class Task1 {
	public static void main(String[] args) throws SQLException {
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
		PreparedStatement pst = conn.prepareStatement("insert into bank values(?,?,?,?)");
		int count = 0;
		for (int i = 0; i < 3; i++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the accno = ");
			long accno = sc.nextLong();
			System.out.println("enter the accname  = ");
			String accname = sc.next();
			System.out.println("enter the accbalance = ");
			double accbalance = sc.nextDouble();
			System.out.println("enter the pinno = ");
			int pinno=sc.nextInt();
			pst.setLong(1, accno);
			pst.setString(2, accname);
			pst.setDouble(3, accbalance);
			pst.setInt(4, pinno);
			int result = pst.executeUpdate();
			// System.out.println(result+" row is created...");
			count++;
		}
		System.out.println(count + " row(s) is inserted..-");
		conn.close();
	}
}
