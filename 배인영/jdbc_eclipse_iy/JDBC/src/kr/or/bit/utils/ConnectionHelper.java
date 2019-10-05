package kr.or.bit.utils;
/*
 	Class.forName("oracle.jdbc.OracleDriver"); //memery �ε� >> new driver
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bituser", "1004"); 
	��� CRUD ���� �۾��� �� �ڵ� �ʼ� 

	1. �ݺ����� �۾��� ������ ( ����̹� �ε�, ���ᰴü, ��ɰ�ü, .. �ڿ�����) - ���� ���̴� �۾�
	2. �ٸ������̳� �ٸ� DB�� �����ϸ� ��� ����? 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//01,02,03,04 �� ���� ������ �ڵ尡 ��
public class ConnectionHelper {
	// ��� (������� ������) - �Լ� >> static (���ֻ���ϴ°Ŵϱ� static !) >> overloading >> interface

	public static Connection getconnection(String dsn) { // DB�� CONNECTION �ϴ� �Լ�
		// oracle������ oracle�� , mysql�� mysql�� // dsn - datasourcename

		Connection conn = null;
		try {
			if (dsn.equals("oracle")) {
				Class.forName("oracle.jdbc.OracleDriver"); // memery �ε� >> new driver
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bituser", "1004");
			} else if (dsn.equals("mysql")) {
				Class.forName("com.mysql.jdbc.Driver"); // memery �ε� >> new driver
				conn = DriverManager.getConnection("jdc:mysql://localhost:3306/bitsqldb?useSSL=true", "bituser",
						"1004");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public static Connection getconnection(String dsn, String id, String pwd) { // DB�� CONNECTION �ϴ� �Լ�
		// oracle������ oracle�� , mysql�� mysql�� // dsn - datasourcename

		Connection conn = null;
		try {
			if (dsn.equals("oracle")) {
				Class.forName("oracle.jdbc.OracleDriver"); // memery �ε� >> new driver
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", id, pwd);
			} else if (dsn.equals("mysql")) {
				Class.forName("com.mysql.jdbc.Driver"); // memery �ε� >> new driver
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

	public static void close(Connection conn) {// ��ü�� �ּҰ��� �޾Ƽ� �� �ȿ��� try������ close �ϴ� �Լ�
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
	
	public static void close(PreparedStatement pstmt) {// ��ü�� �ּҰ��� �޾Ƽ� �� �ȿ��� try������ close �ϴ� �Լ�
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
	
}
