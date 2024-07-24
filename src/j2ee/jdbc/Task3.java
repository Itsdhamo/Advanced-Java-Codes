package j2ee.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task3 {
public static void main(String[] args) throws SQLException {
	// update the contactno using prepared statement...
	Driver d=new com.mysql.cj.jdbc.Driver();
	DriverManager.registerDriver(d);
	Connection conn=DriverManager.getConnection( "jdbc:mysql://localhost:3306/db1","root","root");
   PreparedStatement pst=conn.prepareStatement( "update student set contactno=8760335551 where id=?");
   pst.setInt(1, 1);
   int rs=pst.executeUpdate();
   System.out.println(rs+" row is updated...");
}
}
