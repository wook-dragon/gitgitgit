import java.sql.Connection;
import java.sql.SQLException;

import kr.or.bit.utils.ConnectionHelper;
import kr.or.bit.utils.SingletonHelper;

public class Ex05_ConnectionHelper {

	public static void main(String[] args) throws SQLException {
		
		//1��° ���̽�
		Connection conn = null;
		conn = ConnectionHelper.getconnection("oracle");
		System.out.println(conn.toString());
		//--metadata �Լ��� ���� ����, �̸��� �� �� ����
		System.out.println(conn.getMetaData().getDatabaseProductName());     //Oracle
		System.out.println(conn.getMetaData().getDatabaseProductVersion());  //Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production
		System.out.println("���Ῡ�� : " + conn.isClosed());  //false (����Ǿ��־�!)
		
		// close�ϴ� �Լ��� �����ε����� �� ���� ���. (ConnectionHelper�Լ��� static���� ���� new�ϴ°� ���� �ٷ� ���. 
		ConnectionHelper.close(conn);
		System.out.println("���Ῡ�� : " + conn.isClosed()); //true (��. �������־�!)
		
		
		System.out.println("-----------------------------------------------------");
		
		////////////////////////////////////////////////////////////////////////// 
		//2��° ���̽� 
		// bituser����, �ٸ� ���̵�� �����ϰ�;��! 
		//overloading �Լ� ����.
		
		
		Connection conn2 = null;
		conn2 = ConnectionHelper.getconnection("oracle","hr","1004");
		System.out.println(conn2.toString());
		//--metadata �Լ��� ���� ����, �̸��� �� �� ����
		System.out.println(conn2.getMetaData().getDatabaseProductName());     //Oracle
		System.out.println(conn2.getMetaData().getDatabaseProductVersion());  //Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production
		System.out.println("���Ῡ�� : " + conn2.isClosed());  //false (����Ǿ��־�!)
		
		// close�ϴ� �Լ��� �����ε����� �� ���� ���. (ConnectionHelper�Լ��� static���� ���� new�ϴ°� ���� �ٷ� ���. 
		ConnectionHelper.close(conn2);
		System.out.println("���Ῡ�� : " + conn2.isClosed()); //true (��. �������־�!)
		
		/////////////////////////////////////////////////////////////////////////
		//3��° ���̽� 
		conn2 = null;
		conn2 = ConnectionHelper.getconnection("oracle","hr","1004");
		System.out.println(conn2.toString());
		//--metadata �Լ��� ���� ����, �̸��� �� �� ����
		System.out.println(conn2.getMetaData().getDatabaseProductName());     //Oracle
		System.out.println(conn2.getMetaData().getDatabaseProductVersion());  //Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production
		System.out.println("���Ῡ�� : " + conn2.isClosed());  //false (����Ǿ��־�!)
		
		// close�ϴ� �Լ��� �����ε����� �� ���� ���. (ConnectionHelper�Լ��� static���� ���� new�ϴ°� ���� �ٷ� ���. 
		ConnectionHelper.close(conn2);
		System.out.println("���Ῡ�� : " + conn2.isClosed()); //true (��. �������־�!)
		
		
		//1.���ᰴü �ּ� : oracle.jdbc.driver.T4CConnection@4629104a
		//2.���ᰴü �ּ� : oracle.jdbc.driver.T4CConnection@7fac631b
		//3.���ᰴü �ּ� : oracle.jdbc.driver.T4CConnection@5b87ed94
		// �ٸ� ���ᰴü �ּҰ� �� 
		
		// �ϳ��� APP �����Ҷ����� ��ü�� �����ϰ� �� ���� ����ϴ°� ������?
		// �ڹٿ��� ������ �ϳ� �ִµ�, �ϳ��� ��ü�� ����� �����ϴ¹�� ..
		
		//////////////////////////////////////////////////////////////////////////////////////
		//singletone : �ϳ��� ����� �� �ּҸ� ���� ����. (�Ѱ��� ��ü�� �����ϰ����)  -- but, �� ����� JDBC���� �����ϴ� ����� �ƴϿ���. / ���������� ���ƿ�.!
		
		
	    Connection conn3 = null;
	    conn3 = SingletonHelper.getConnection("oracle");
	    System.out.println(conn3.toString());
	    System.out.println(conn3.getMetaData().getDatabaseProductName());
	    System.out.println(conn3.getMetaData().getDatabaseProductVersion());
	    //System.out.println("���Ῡ�� : " + conn.isClosed());
	    //��ü ���� : oracle.jdbc.driver.T4CConnection@6e0e048a
	    ConnectionHelper.close(conn3);  // �̷��� ������ �����ϸ� ����, Connection conn3 ��ü�� null�� ������?
	    //������ �����ѰŶ�, connection conn3 ��ü�� ���� �ּҰ� �������� �ƴϿ���. 
	    
	    //�̹� �� ������ �ּҴ� �ִµ�, �� �ּҰ� ������ ������ �ּ�. 
	    //�׷� �ؿ� conn4�� ������ ������ �ּҸ� ����. conn = null�� Ÿ�°� �ƴ϶�, conn !null ������ Ÿ�� ��. 
	    // Exception in thread "main" java.sql.SQLRecoverableException: ���� ����   ��� ��
	    
	    
	    
	    //***************
	    //�׷�, �Ʒ� �̱��� ��ü get Connection�� ���ο� ���� ��ü�� �޾ƿ��� �ϰ� ���� 
	    //if�� Ÿ���ʰ� ����������. 
	    // �ذ��� !  (��ü�� �ٽ� �����ִ� �Լ��� ���� ���)
	    SingletonHelper.dbClose();
	    
	   
	    
	    
	    Connection conn4 = null;
	    conn4 = SingletonHelper.getConnection("oracle");
	    System.out.println(conn4.toString());
	    System.out.println(conn4.getMetaData().getDatabaseProductName());
	    System.out.println(conn4.getMetaData().getDatabaseProductVersion());
	    //��ü ���� : conn is not null.. return : oracle.jdbc.driver.T4CConnection@6e0e048a
		
		
	    
	    //** �̷��� singleton ���� �������� �����ϱ��?
	    //** DB���� ���� ��������� �����ؾ� �ұ��? 
	    //��.. ������ü�� �������� ������ �ٲٸ� ��ΰ� �ٲ�ٴ� �������� ����. 
	    
	    /////////////////////////////////////////////////////////////////////////////////////
	    
		
	}
}
