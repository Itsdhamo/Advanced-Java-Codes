package j2ee.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BatchExecute9thDec1 {
public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	FileInputStream fis=new FileInputStream("C:\\j2eeworkspace\\j2ee\\src\\j2ee\\jdbc\\abc.properties");
	
	Properties p=new Properties();
	p.load(fis);
	
	String url=p.getProperty("url");
	
	Connection conn=DriverManager.getConnection(url, p);
	
	Statement st=conn.createStatement();
	
	ResultSet result=st.executeQuery("select * from product");
	
	while(result.next()) {
		System.out.println(result.getInt(1)+" "+result.getDouble(1)+" "+result.getInt(3)+" "+result.getString(4));
	}
}
}
