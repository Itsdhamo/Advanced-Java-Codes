package j2ee.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Revision {
public static void main(String[] args) {
	try {
		Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?user=root & password=root");
		
		PreparedStatement pst=conn.prepareStatement("select * from employee");
		 ResultSet res=pst.executeQuery();
		 while(res.next()) {
			 System.out.println("employee id = "+res.getInt(1)+" employee name = "+res.getString(2)+" employee contact no = "+res.getLong(3)+" employee gender "+res.getString(4));
		 }
		 conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
