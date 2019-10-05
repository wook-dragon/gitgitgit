package kr.or.bit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
public static Connection getConnection(String dsn) { //oracle , mysql
		Connection conn = null;
		try {
			if(dsn.equals("oracle")) {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bituser","1004");
			}else if(dsn.equals("mysql")) {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bitsqldb?useSSL=true","bituser","1004");
			}
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
*/
public class SingletonHelper {
	//�̱��� ��ȯ �ϼ��� 
	private static Connection conn = null; // conn�� �ּҸ� �޴°Ŵϱ�, �װ� null�� ����. 
	private SingletonHelper() {} //new SingletonHelper ...
	
	public static Connection getConnection(String dsn) {
		if( conn != null) { // conn�� ���� �ƴ϶�� �̹� ��������� �ִ� ����. ���� ��������� return�Ұ�.  (�̱����� �ϳ��� �����°Ŵϱ�)
			//POINT conn ��ü�� null ���� �ƴϸ� ����  conn  �ּҸ�  return .....
			System.out.println("conn is not null.. return : " + conn);
			return conn;
		}
		
		try {
			if(dsn.equals("oracle")) {
				Class.forName("oracle.jdbc.OracleDriver");
				//DriverManager.getConnection ���ο� ���� ��ü�� �����ϴ� �ڵ� 
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bituser","1004");
			}else if(dsn.equals("mysql")) {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bitsqldb?useSSL=true","bituser","1004");
			}
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
//		System.out.println("conn is null  conn  ��ü ���� : " + conn);
		return conn;
	}
	
	
	
	
	
	public static void dbClose() {  // but �̱����� ��� �̷��� �Ⱦ�. �н���!
		if (conn != null) {
			try {

				conn.close();
				conn = null; // Connection getConnection�� if�� Ÿ���ʰ� ���ο� ��ü�� ����. 
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
}

