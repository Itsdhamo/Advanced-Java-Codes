package j2ee.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Properties;

public class BatchExecuteDec10th1st {
public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	FileInputStream fis=new FileInputStream("C:\\j2eeworkspace\\j2ee\\src\\j2ee\\jdbc\\abc.properties");
	
	Properties pro=new Properties();
	pro.load(fis);
	
	String url=pro.getProperty("url");
	
	Connection conn=DriverManager.getConnection(url, pro);
	
	Statement st=conn.createStatement();
	
	st.addBatch("update product set name='appleiphonepromax' where id=1");
	st.addBatch("insert into product values(4,1000.0,3,'redmi')");
	
	int [] arr=st.executeBatch();
	
	System.out.println(Arrays.toString(arr));
	
}
}
