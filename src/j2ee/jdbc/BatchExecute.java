package j2ee.jdbc;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class BatchExecute {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// step-1 load and register the driver...
		Class.forName("com.mysql.cj.jdbc.Driver");
		
        // step-2 establish the connection...
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
        
		// step-3 create the statement and issue the query...
		Statement st = conn.createStatement();
		st.addBatch("insert into product values (1,2000,4,'oneplus')");
		st.addBatch("update product set name='realme' where id=3");
		st.addBatch("delete from product where id>1");
        
		// step-4 process the result...
		int[] arr = st.executeBatch();
		System.out.println(Arrays.toString(arr));
		
		// step-5 close the connection...
		conn.close();
	}
}
