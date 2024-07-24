package Revision;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Sample1 {
public static void main(String[] args) throws Exception {
	Driver d=new com.mysql.cj.jdbc.Driver();
	DriverManager.registerDriver(d);

	FileInputStream fis=new FileInputStream("C:\\j2eeworkspace\\j2ee\\src\\Revision\\data.properties");

	Properties pro=new Properties();
	pro.load(fis);

	String url=pro.getProperty("url");
	Connection conn=DriverManager.getConnection(url, pro);

	PreparedStatement pst=conn.prepareStatement("select * from bank");
	ResultSet res=pst.executeQuery();
	while(res.next()) {
		res.getLong(1);
		res.getString(2);
		res.getDouble(3);
		res.getInt(4);
	}
	conn.close();
}
}
