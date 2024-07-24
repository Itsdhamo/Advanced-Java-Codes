package j2ee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BatchExecute3 {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	// step-1 load and register the driver... 
	Class.forName("com.mysql.cj.jdbc.Driver");
	// step-2 establish the connection...
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?user=root&password=root");
	// step-3 create the statement and issue the query...
	PreparedStatement pst=conn.prepareStatement("select * from product");
	 
	PreparedStatement pst1=conn.prepareStatement("select name,costprice-discount/100 as sellingprice from product");
	// step-4 process the result...
	ResultSet res= pst.executeQuery();
	ResultSet res1=pst1.executeQuery();
	System.out.println("id costprice discount name");
	while(res.next()) {
	System.out.println(res.getInt(1)+"   "+res.getDouble(2)+"   "+res.getDouble(3)+"   "+res.getString(4));
	}
	System.out.println("--------------------------");
	System.out.println("name     sellingprice");
	while(res1.next()) {
		System.out.println(res1.getString(1)+"     "+res1.getDouble(2));
	}
	// step-5 close the connection...
	conn.close();
}
}
