package kr.or.bit.utils;
/*
 	Class.forName("oracle.jdbc.OracleDriver"); //memery 로드 >> new driver
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bituser", "1004"); 
	모든 CRUD 선행 작업시 위 코드 필수 

	1. 반복적인 작업을 줄이자 ( 드라이버 로딩, 연결객체, 명령객체, .. 자원해제) - 많이 쓰이는 작업
	2. 다른계정이나 다른 DB를 연결하면 어떻게 하지? 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//01,02,03,04 를 보면 동일한 코드가 들어감
public class ConnectionHelper {
	// 기능 (연결등의 내용을) - 함수 >> static (자주사용하는거니까 static !) >> overloading >> interface

	public static Connection getconnection(String dsn) { // DB랑 CONNECTION 하는 함수
		// oracle들어오면 oracle로 , mysql은 mysql로 // dsn - datasourcename

		Connection conn = null;
		try {
			if (dsn.equals("oracle")) {
				Class.forName("oracle.jdbc.OracleDriver"); // memery 로드 >> new driver
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bituser", "1004");
			} else if (dsn.equals("mysql")) {
				Class.forName("com.mysql.jdbc.Driver"); // memery 로드 >> new driver
				conn = DriverManager.getConnection("jdc:mysql://localhost:3306/bitsqldb?useSSL=true", "bituser",
						"1004");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public static Connection getconnection(String dsn, String id, String pwd) { // DB랑 CONNECTION 하는 함수
		// oracle들어오면 oracle로 , mysql은 mysql로 // dsn - datasourcename

		Connection conn = null;
		try {
			if (dsn.equals("oracle")) {
				Class.forName("oracle.jdbc.OracleDriver"); // memery 로드 >> new driver
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", id, pwd);
			} else if (dsn.equals("mysql")) {
				Class.forName("com.mysql.jdbc.Driver"); // memery 로드 >> new driver
				conn = DriverManager.getConnection("jdc:mysql://localhost:3306/bitsqldb?useSSL=true",id, pwd);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	
	/*
	 * try {
	 * 
	 * conn.close(); } catch (SQLException e) {
	 * 
	 * e.printStackTrace(); }
	 */

	public static void close(Connection conn) {// 객체의 주소값을 받아서 이 안에서 try가지고 close 하는 함수
		if (conn != null) {
			try {

				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
	
	
	public static void close(ResultSet rs) {
		if (rs != null) {
			try {

				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement stmt) {
		if (stmt != null) {
			try {

				stmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
	
	public static void close(PreparedStatement pstmt) {// 객체의 주소값을 받아서 이 안에서 try가지고 close 하는 함수
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
	
}
