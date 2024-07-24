package j2ee.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class jdbc11thassignment {
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		// step-1 load and register the driver...
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		FileInputStream fis = new FileInputStream("C:\\j2eeworkspace\\j2ee\\src\\j2ee\\jdbc\\abc.properties");

		Properties pro = new Properties();
		pro.load(fis);

		String url = pro.getProperty("url");

		// step-2 establish the connection...
		Connection conn = DriverManager.getConnection(url, pro);

		// step-3 create the statement and issue the query...
		PreparedStatement pst = conn.prepareStatement("select accname from bank");

		// step-4 process the result...
		ResultSet result = pst.executeQuery();
 
		while (result.next()) {
			System.out.println(result.getString(1));
		}
		// step-5 close the connection...
		conn.close();
	}
}
