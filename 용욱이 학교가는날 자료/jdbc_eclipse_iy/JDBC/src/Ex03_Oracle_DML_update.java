import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 DML(insert, update, delete)
 JDBC �۾�
 1. ��� ������ ����. (�ݿ����ɻ�, �������°� ����) SO. resultSet�� �ʿ� X 
 2. �ݿ��� ���� ����� return�Ѵ�. (�ݿ��� ���� ������ return) -- ���� update�� 14�� ���� �����Ǹ�, 14�� �� 
 ex. JAVA�ڵ� 
 update emp set sal = 0 >> �ǹݿ� >> return 14 
 update emp set sal = 100 where empno=9999 >> ���� >> return 0
 
 KEY POINT 
 DB�۾��� (sqlplus, DB developer)
 insert, update, delete >> �� Ʈ������� ����Ű�� �۾�. >> �ݵ�� commit, rollback�� ���� : ��ü�ݿ�, ��ü ��� ó����
 
 JDBC API�� ���ؼ� DML �۾��� �Ұſ���.  >> �� DML�۾��� defaul��  autocommit 
 java code�� ���� delete from emp �����ϸ� >> ���� �ݿ���. >> �ڵ����� commit
  ����� �ʿ��ϴٸ� commit, rollback java�ڵ忡 ���� ����. 
  
  ����
    A���� ���� (update .. 
    
    B���� �Ա�(update)
  �� commit, rollback �����ϵ��� �ڵ�� �۾�����. 
  
  ex. ����, �Ա��� �� update �۾��ε� �ѹ��� �̷�������ϴµ�, �߰��� ������ ���� ���⸸ �ǰ� �Ա��� �ȵǴ� ��Ȳ.
  �̷�����  commit, rollback �����ϵ��� �ڵ�� �۾�����
  autocommit �ɼ� >> false�� �ٲٰ� >> �ݵ�� ���α׷����� commit, rollback 
 */
public class Ex03_Oracle_DML_update {  //�̷��� ����Ȱ� commit�� rollback�� �� �ʿ䰡 ����.
	public static void main(String[] args) {
		Connection conn = null;
	      Statement stmt = null;
	      
	      try {
	         Class.forName("oracle.jdbc.OracleDriver");   // ��� �޸𸮿� �ε� �ϴ� �ų� = new driver
	         System.out.println("����Ŭ ����̹� �ε�");
	         
	         //1. DB���� 
	         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bituser", "1004");
	         System.out.println(conn.isClosed() + "  :  False  >>  ����");
	         
	         //2. ��ɻ��� (CRUD)
	         stmt = conn.createStatement();
	         
			 //3. ���౸��
	         
	         //update dememp set sal =0;
	         int deptno = 0;
	         
	         Scanner sc = new Scanner(System.in);
	         System.out.println("�μ���ȣ");
	         deptno =Integer.parseInt(sc.nextLine());
	         
	         //�������� ��� (...)
	         String sql ="update dememp set sal =0 where deptno =" +deptno;
	 
			  //4. ���� (��������� ������ X) �����ϴ� ��ɾ �ٸ�
	         int resultrow = stmt.executeUpdate(sql);
	         // ResultSet��  ���� �ʿ䰡 X
	         
			  //5. ó��
	         if(resultrow >0) {
	            System.out.println("�ݿ��� ���� ���� : " + resultrow);
	         }else {
	        	 //update �߻��ÿ��� ���ǿ� �´� ����� ������ 0���� ��ȯ 
	        	 // insert�� �޸� update�� else������ ����ȴ�. (�ǹ̰� �ִ�.)
	        	 
	            System.out.println("Update Fail : " + resultrow);
	         }
	         
	         
	      }catch(Exception e){
	         System.out.println("Update Fail  ���� �߻�: " + e.getMessage());
	         
	      }finally {
	         try {
	            stmt.close(); //�ʳ� Ȥ�� �̰� �������� �ʾҴµ� �ݴ°žƴϾ�? �ϰ� ����ó�� �ش޶�� ��
	            conn.close();
	         } catch (SQLException e) {

	            e.printStackTrace();
	         }
	         
	      }
	}
}
