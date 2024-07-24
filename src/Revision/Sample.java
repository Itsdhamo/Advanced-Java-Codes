package Revision;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Sample {
public static void main(String[] args) throws SQLException {
	Driver d=new com.mysql.cj.jdbc.Driver();
	DriverManager.registerDriver(d);
	
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
	Statement st=conn.createStatement();
	int result=st.executeUpdate("update bio set name='shruthi' where id=4007;");
	System.out.println(result+" rows is affected");
	conn.close();
}
}
