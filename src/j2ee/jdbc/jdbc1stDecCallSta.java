package j2ee.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc1stDecCallSta {
public static void main(String[] args) throws SQLException {
	//insert....
	Driver d=new com.mysql.cj.jdbc.Driver();
	DriverManager.registerDriver(d);
	
	Connection conn=DriverManager.getConnection( "jdbc:mysql://localhost:3306/db1?user=root&password=root");
	CallableStatement cst=conn.prepareCall("call db1.insert(?,?,?,?)");
	cst.setInt(1, 5);
	cst.setString(2,"ChethanKumar");
	cst.setLong(3, 987654321);
	cst.setString(4, "M");
	
	int result=cst.executeUpdate();
	System.out.println(result+" row inserted...");
	conn.close();
}
}
