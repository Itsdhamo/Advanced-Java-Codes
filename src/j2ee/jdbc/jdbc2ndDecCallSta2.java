package j2ee.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbc2ndDecCallSta2 {
	public static void main(String[] args) throws SQLException {
		// step 1 load and register the driver...
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		// step 2 establish the connection...
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?user=root&password=root");
		// step 3 create the statement and issue the query...
		CallableStatement cst = conn.prepareCall("select * from employee ");
		// step 4 process the result...
		boolean result = cst.execute();
		System.out.println(result + "...");
		ResultSet res=cst.getResultSet();
		while(res.next()) {
			System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getLong(3)+" "+res.getString(4));
		}
		// step 5 close the statement...
		conn.close();
	}

}
