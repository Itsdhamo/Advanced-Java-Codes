package j2ee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class BatchExecute2 {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	// step-1 load and register the driver...
	Class.forName( "com.mysql.cj.jdbc.Driver");
	// step-2 establish the connection...
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?user=root&password=root");
	//step-3 create the statement and issue the query...
	Statement st=conn.createStatement();
 
	st.addBatch("insert into product values(5,700.0,5,'poco')");
	st.addBatch("insert into product values(6,600.0,7,'realme')");
	st.addBatch("insert into product values(7,800.0,10,'oneplus')");
	st.addBatch("update product set name='Appleiphonemax' where id=1");
//	st.addBatch("delete from product where id>3");
	// step-4 process the result...
	int[] res=st.executeBatch();
	
	System.out.println(Arrays.toString(res)+"rows are affected...");

	// step-5 close the connection...
	conn.close();
}
}
