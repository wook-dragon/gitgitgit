import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
JDBC
1. Java �� ���ؼ� Oracle ���� �ϰ� CRUD �۾�(insert, select, update, delete)
2. ��� DB ����Ʈ���� ��� ���� (Oracle , mysql , ms-sql) 
2.1 ��ǰ�� �´� ����̹��ʿ� (�� ���� ����Ʈ���� �ٿ�ε� �޾Ƽ� ���)
2.2 ����Ŭ (���� PC ����Ŭ DB ���� ��ġ) >> ojdbc6.jar (����̹� ����)
     C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib
     >>(�̵����ѵ�) C:\SmartWeb\Database\JDBC\Connect_Utils\oracleDriver
     
3. Cmd ����� Java Project ������ ����̹� ����ϱ� ���ؼ� ���� 
3.1 java Build Path (jar �߰�) �ϴ� �۾�
3.2 ����̹� ����غ� �Ϸ�  >> ����̹� ����� �� �ֵ��� �޸� (new ..)
3.3 class.forName("class �̸�") >> new ������ ȿ�� 

***
�ڹ� 1.6 �̻���ʹ� 
Console ����� ������Ʈ���� ������Ʈ ���� ������ ��� ��� �����մϴ�
���񽺷δ�(http://docs.oracle.com/javase/6/docs/api/java/util/ServiceLoader.html)) ������� JDBC Driver�� �ڵ����� ��ϵ˴ϴ�.
�׷��� Class.forName("com.mysql.jdbc.Driver") ���� �ڵ带 ȣ������ �ʾƵ� �˴ϴ�. :)
//class.forName�� �ؼ� ����̹��� �޸𸮿� �÷�����ϴµ�, jar ���� �߰������ε� �� �۾��� �����ϰ� ��. 
***
�׷��� �غ���! 





4.JAVA ( JDBC API)
4.1 import java.sql.*; �����ϴ� �ڿ� (��κ��� �ڿ��� : interface , class)
4.2 �����ڴ� interface �� ���ؼ� �۾� ( �ñ��� : why interface �ϱ�?  hint)Oracle �Ӹ� �ƴ϶� �ٸ� �پ��� DB ��� )

5. DB����  -> ��� -> ���� -> ó��  -> �ڿ�����
5.1 ��� (CRUD) : select , insert , update , delete
5.2 ó�� : select ȭ�� ����Ҳ���  �ƴϾ�  �� Ȯ�θ� ...........
5.3 �ڿ����� (����)  :(IO�� ���. �������÷��Ͱ� DB����, ��Ʈ��ũ ���°� �� �� ����. �޸𸮿��� �Ͼ�� ���� �ƴϱ⶧��) .. �ڿ����� ���ϸ� �޸� FULL��

*���� ���ڿ� (ConnectionString) ����
ä�� (client  ->  server �����ϱ� ���ؼ�)
��Ʈ��ũ DB (���� IP , PORT , SID(���� �����ͺ��̽� �̸�) , ���Ӱ��� , ���� ���)
   

 
*/

public class Ex01_Oracle_Connection {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver"); //���ܹ߻�. �̷��� �������� ���� �� ������
		//�̷�����̺긦 new�ؼ� �޸𸮿��� ���ڴ�. class.forName�� new driver�� ���� �ǹ�
		System.out.println("����Ŭ ����̹� �ε�");
		
		//1. DB���� 
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bituser", "1004"); 
		//jdbc:oracle:thin:@������ ���! �ٲٸ� X
		//localhost ȣ��Ʈ ��ȣ. ���߿��� ip�� ���⿡ �����. ex. @192.168.0.3
		
		//getConnection ���ο��� new Connection�ؼ� ��ü ���� >> Connection �������̽��� �θ�� .. ������ ��ü �ּҸ� ����. 
		//�����Ѱ� Connection �������̽��� ����  
		//����Ŭ , mysql�� �� Connection�� ���� �� ���� 
		System.out.println(conn.isClosed()+ " : false >> ����"); //�� ���� ��������? false�� ������ DB���� ���� �Ǿ����� . 

		
		//2. ��ɻ��� (CRUD)
		Statement stmt = conn.createStatement(); //��ɿ� �ʿ��� ��ü�� ȹ���ϴ� ���� 
		
		String sql ="select empno, ename, sal from emp";  //�� ������ ����Ŭ �������� ������ ��. 
		
		//3. 2���� �� ����� ���� + ó���� ���� >> ó������� ������ ��ȸ�� 
		//��� select�Ұų� or insert, update, delete�Ұų�. �ѷ� ���� / insert, update, delete�� ��� ������ ����.
		ResultSet rs = stmt.executeQuery(sql);//db������ ������ �������(�޸�)�� �����ؼ� �����͸� ���� �� ����.
		//ResultSet�� �̸� ���� �� �ִ� �������̽� 
		
		
		//4. ó��(��ȸ)
		while(rs.next()) {//next�� select�� ������ �ִ�? �ϰ� ����. �ִٰ�true �ϸ� while������ �� 
			System.out.println(rs.getInt("empno")+ " / " + rs.getString("ename") + " / " + rs.getInt("sal"));
			//	System.out.println(rs.getInt(1)+ " / " + rs.getString(2) + " / " + rs.getInt(3)); 
				//  -- �÷��� ������ �����. �̶� ���ڴ� index�� �ƴϱ� ������ 1���� ����
			//�Լ��� �����͸� ������. getter�� �����   getInt �������°� ����Ÿ��. empno�����ž�.   ename�� String Ÿ��
			//ù��° ������ �Ѹ��� while���� �����Ͱ� ���������� ���ƿ�. ������ false�� return�ϱ� ����
		}
	
		
		//5. ���� ���� 
		rs.close();
		conn.close();
		System.out.println("DB���� : True " + conn.isClosed());   //�����ִ�? true�� ���;� �ߵȰ�. 
		
	}

}
