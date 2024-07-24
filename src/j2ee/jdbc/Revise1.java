package j2ee.jdbc;

import java.util.Scanner;

class User{
	final long accno;
	String accname;
	double accbalance;
	int accpinno;
	public User(long accno, String accname, double accbalance, int accpinno) {
		this.accno = accno;
		this.accname = accname;
		this.accbalance = accbalance;
		this.accpinno = accpinno;
	}
}
public class Revise1 {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the account number = ");
	long accno=sc.nextLong();
	System.out.println("Enter the account holder name = ");
	String accname=sc.next();
	System.out.println("Enter the amount = ");
	double accbalance=sc.nextDouble();
	System.out.println("Enter the Account pinno = ");
	int accpinno=sc.nextInt();
	System.out.println("");
	User u1=new User(accno,accname,accbalance,accpinno);
	
	
	System.out.println(u1.accbalance);
	System.out.println(u1.accname);
	sc.close();
}
}
