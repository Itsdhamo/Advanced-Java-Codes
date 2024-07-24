package j2ee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class BatchExecute9thDec {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?user=root&password=root");
	
	PreparedStatement pst=conn.prepareStatement("insert into product values(?,?,?,?)");
	
	int num=3;
	while(num>0) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the id = ");
		int id=sc.nextInt();
		System.out.println("enter the costprice = ");
		double costprice=sc.nextDouble();
	    System.out.println("enter the discount = ");
	    int discount=sc.nextInt();
	    System.out.println("enter the name = ");
	    String name=sc.next();
	    pst.setInt(1,id);
	    pst.setDouble(2,costprice);
	    pst.setInt(3, discount);
	    pst.setString(4, name);
	    pst.addBatch();
	    num--;
	}
	int[] arr=pst.executeBatch();
	System.out.println(Arrays.toString(arr));
}
}