package Revision;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sample2 {
public static void main(String[] args) throws SQLException {
	Driver d=new com.mysql.cj.jdbc.Driver();
	DriverManager.registerDriver(d);
	
	Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?user=root&password=root");
	PreparedStatement pst=conn.prepareStatement("Select * from bio");
	ResultSet res=pst.executeQuery();
	while(res.next()) {
	System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getLong(4));}
	conn.close();
}
}
