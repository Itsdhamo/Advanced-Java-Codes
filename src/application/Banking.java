package application;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import j2ee.jdbc.preparedstajdbc;

public class Banking {
	static void credit(double balance, double amt, int pinno) throws SQLException {
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?user=root&password=root");
		Scanner sc = new Scanner(System.in);
		balance = balance + amt;
		PreparedStatement st = conn.prepareStatement("update bank set accbalance=? where accpinno=?");
		st.setDouble(1, balance);
		st.setInt(2, pinno);
		int res = st.executeUpdate();
		System.out.println("your amount is deposited");
		referenceid();
		System.out.println("Available Balance = " + balance + " rupees");
		System.out.println("---------------------");
	}

	static void debit(double balance, double amt, int pinno) throws SQLException {
		Driver d = new com.mysql.cj.jdbc.Driver(); 
		DriverManager.registerDriver(d);          

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?user=root&password=root");
		Scanner sc = new Scanner(System.in);
		balance = balance - amt;                      
		PreparedStatement st = conn.prepareStatement("update bank set accbalance=? where accpinno=?");
		st.setDouble(1, balance);
		st.setInt(2, pinno);
		int res = st.executeUpdate();
		System.out.println("your amount is debited");
		referenceid();
		System.out.println("Available Balance = " + balance + " rupees");
		System.out.println("---------------------");
	}

	static void balanceenquiry(double balance) {
		System.out.println("your balance = " + balance + " rupees");
		System.out.println("---------------------");
	}

	static void changepinnumber(int newpin, int existpinno) throws SQLException {
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?user=root&password=root");
		Scanner sc = new Scanner(System.in);

		PreparedStatement st = conn.prepareStatement("update bank set accpinno=? where accpinno=?");
		st.setInt(1, newpin);
		st.setInt(2, existpinno);
		int res = st.executeUpdate();
		existpinno = newpin;
		System.out.println("Your pin number changed sucessfully");
		System.out.println("your new pin no is = " + newpin);
	}

	static void referenceid() {
		System.out.println("Reference id = " + (int) (Math.random() * 1000000000));
	}

	public static void main(String[] args) throws SQLException {
		final String bankname = "BANK OF SPAIN";
		int existpinno = 0;
		String name = null;
		long accno = 0;
		double balance = 0.0;
		System.out.println("-----welcome to " + bankname + " -----");
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?user=root&password=root");
		Scanner sc = new Scanner(System.in);

		PreparedStatement st1 = conn.prepareStatement("select accpinno from bank where accname=?");
		System.out.println("Enter the accholder name = ");
		String accname = sc.next();
		System.out.println("Enter the Four Digit PIN no = ");
		int pinno = sc.nextInt();
		st1.setString(1, accname);
		ResultSet res1 = st1.executeQuery();
		while (res1.next()) {
			existpinno = res1.getInt(1);
		}

		System.out.println("-------------------");
		PreparedStatement st2 = conn.prepareStatement("select accname from bank where accpinno=?");
		st2.setInt(1, existpinno);
		ResultSet res2 = st2.executeQuery();
		while (res2.next()) {
			name = res2.getString(1);
		}
		PreparedStatement st3 = conn.prepareStatement("select accno from bank where accpinno=?");
		st3.setInt(1, existpinno);
		ResultSet res3 = st3.executeQuery();
		while (res3.next()) {
			accno = res3.getLong(1);
		}
		PreparedStatement st4 = conn.prepareStatement("select accbalance from bank where accpinno=?");
		st4.setInt(1, existpinno);
		ResultSet res4 = st4.executeQuery();
		while (res4.next()) {
			balance = res4.getDouble(1);
		}
		for (;;) {
			if (existpinno == pinno) {
				System.out.println("Welcome " + name);
				System.out.println("Account no : " + accno);
				System.out.println("Deposit = 1,Withdrawal = 2");
				System.out.println("balance enqiry = 3,Change Pin no= 4");
				System.out.println("Enter the service number = ");
				int servicenum = sc.nextInt();
				if (servicenum < 5) {
					if (servicenum == 1) {
						System.out.println("Enter the deposit amt = ");
						double amt = sc.nextDouble();
						credit(balance, amt, existpinno);
					} else if (servicenum == 2) {
						System.out.println("Enter the withdrawal amt = ");
						double amt = sc.nextDouble();
						debit(balance, amt, existpinno);
					} else if (servicenum == 3) {
						balanceenquiry(balance);
					} else if (servicenum == 4) {
						System.out.println("Enter the old pin number = ");
						int oldpin = sc.nextInt();
						if (oldpin == existpinno) {
							System.out.println("Enter the new pin no = ");
							int newpin = sc.nextInt();
							changepinnumber(newpin, existpinno);
						} else {
							System.out.println("Plz enter your old pin no correctly...");
							System.out.println("--------------------------------");
						}
					}
				} else {
					System.out.println("Plz enter valid service number");
				}
			} else {
				System.out.println("Wrong pin number please enter valid pin number");
				break;
			}
			System.out.println("----THANK YOU----");
			System.out.println("---VISIT AGAIN---");
			conn.close();
		}
	}
}