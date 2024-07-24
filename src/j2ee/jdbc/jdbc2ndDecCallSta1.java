package j2ee.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc2ndDecCallSta1 {
public static void main(String[] args) throws SQLException {
	Driver d=new com.mysql.cj.jdbc.Driver();
	DriverManager.registerDriver(d);
	
	Connection conn=DriverManager.getConnection( "jdbc:mysql://localhost:3306/db1?user=root&password=root");
	CallableStatement cst=conn.prepareCall("call db1.update(?,?)");
	cst.setInt(1, 4);
	cst.setLong(2, 9778987678l);
	
	boolean status=cst.execute();
	System.out.println(status);
	int result=cst.getUpdateCount();
	System.out.println(result+" row updated...");
	conn.close();
}
}
