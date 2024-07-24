package j2ee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Jdbc2 {
	public static void main(String[] args) {
try {
	//step 1
	Driver d=new com.mysql.cj.jdbc.Driver();
	DriverManager.registerDriver(d);
	//step2
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
	//step3
	Statement st=conn.createStatement();
	//step4
	int rs=st.executeUpdate("delete from employee where name='dhamo'");
	System.out.println(rs+" is affected");
	conn.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	}
}
