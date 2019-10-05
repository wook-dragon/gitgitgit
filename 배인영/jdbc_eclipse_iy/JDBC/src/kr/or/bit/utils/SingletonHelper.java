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
	//싱글톤 변환 하세요 
	private static Connection conn = null; // conn은 주소를 받는거니까, 그게 null인 상태. 
	private SingletonHelper() {} //new SingletonHelper ...
	
	public static Connection getConnection(String dsn) {
		if( conn != null) { // conn이 널이 아니라면 이미 만들어진게 있는 상태. 원래 만들어진걸 return할게.  (싱글톤은 하나로 돌리는거니까)
			//POINT conn 객체가 null 값이 아니면 같은  conn  주소를  return .....
			System.out.println("conn is not null.. return : " + conn);
			return conn;
		}
		
		try {
			if(dsn.equals("oracle")) {
				Class.forName("oracle.jdbc.OracleDriver");
				//DriverManager.getConnection 새로운 연결 객체를 생성하는 코드 
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bituser","1004");
			}else if(dsn.equals("mysql")) {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bitsqldb?useSSL=true","bituser","1004");
			}
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
//		System.out.println("conn is null  conn  객체 리턴 : " + conn);
		return conn;
	}
	
	
	
	
	
	public static void dbClose() {  // but 싱글톤은 사실 이렇게 안씀. 학습용!
		if (conn != null) {
			try {

				conn.close();
				conn = null; // Connection getConnection시 if를 타지않고 새로운 객체를 만듦. 
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
}

