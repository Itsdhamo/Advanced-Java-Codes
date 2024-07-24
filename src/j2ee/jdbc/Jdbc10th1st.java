package j2ee.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Jdbc10th1st {
public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	FileInputStream fis=new FileInputStream("C:\\j2eeworkspace\\j2ee\\src\\j2ee\\jdbc\\abc.properties");
	
	Properties pro=new Properties();
	pro.load(fis);
	
	String url=pro.getProperty("url");
	
	Connection conn=DriverManager.getConnection(url, pro);
	PreparedStatement pst=conn.prepareStatement("select * from bank");
	
	ResultSet result=pst.executeQuery();
	
	while(result.next()) {
		System.out.println(result.getLong(1)+" "+result.getString(2)+" "+result.getDouble(3)+" "+result.getInt(4));
	}
}
}
