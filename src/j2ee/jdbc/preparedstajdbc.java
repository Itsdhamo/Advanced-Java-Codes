package j2ee.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class preparedstajdbc {
	public static void main(String[] args) throws SQLException {
		//step1 load and register the driver
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		//step2 establish the connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
		//step3 create the statement and issue the query 
		PreparedStatement pst = conn.prepareStatement("insert into student values(?,?,?)");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the id =");
		int id = sc.nextInt();
		System.out.println("enter the name =");
		String name = sc.next();
		System.out.println("enter the contactno =");
		long contactno = sc.nextLong();
		pst.setInt(1, id);
		pst.setString(2, name);
		pst.setLong(3, contactno);
		//step4 process the result
		int rs=pst.executeUpdate();
		System.out.println(rs+" is affected...");
		//step5 close the connection
		conn.close();
	}
}
