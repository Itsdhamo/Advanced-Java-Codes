package j2ee.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbc30thtask3 {
	public static void main(String[] args) throws SQLException {
		// step1 load and register the driver...
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.deregisterDriver(d);
		// step2 establish the connection...
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the service number = ");
		int servicenumber = sc.nextInt();
		if (servicenumber == 1) {
			// step3 create the statement and issue the query...
			PreparedStatement pst1 = conn.prepareStatement("update employee set contactno=? where id=?");
			System.out.println("Enter the id = ");
			int id = sc.nextInt();
			System.out.println("Enter the new Contact no =");
			long contactno = sc.nextLong();
			pst1.setLong(1, contactno);
			pst1.setInt(2, id);
			// step4 process the result...
			int res = pst1.executeUpdate();
			System.out.println(res + " has been updated...");
		} else if (servicenumber == 2) {
			PreparedStatement pst2 = conn.prepareStatement("update employee set name=? where id=?");
			System.out.println("Enter the id = ");
			int id = sc.nextInt();
			System.out.println("Enter the new name =");
			String name = sc.next();
			pst2.setString(1, name);
			pst2.setInt(2, id);
			int res = pst2.executeUpdate();
			System.out.println(res + " has been updated...");
		}
		// step5 close the connection...
		conn.close();
	}
}
