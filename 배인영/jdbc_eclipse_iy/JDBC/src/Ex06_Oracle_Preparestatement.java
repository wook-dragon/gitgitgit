import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import kr.or.bit.utils.ConnectionHelper;
import kr.or.bit.utils.SingletonHelper;

/*
  Statement stmt = conn.createStatement(); //��ɿ� �ʿ��� ��ü�� ȹ���ϴ� ���� 
  String sql ="select empno, ename, sal from emp";  //�� ������ ����Ŭ �������� ������ ��. 
  ResultSet rs = stmt.executeQuery(sql);//db������ ������ �������(�޸�)�� �����ؼ� �����͸� ���� �� ����.
 
 
   ���� : Query���� �ٲپ ������ �����ϴ�. ex. "select empno, ename, sal from emp" �� "select deptno, dname from dept";�� �ٲ㼭 ���
             ������ �÷���, ���̺��, ������ ������ ������ ����.
   ���� : Query���� ��ȭ�� ����� ������ ������. (���ο� ������ ���������� �ٽ� ������ �����ϱ� ������)
   
   �������� ���Ǹ� �ٲ� ������ �����ϴ� ����� ������?
   A query�� : sql ="select empno, ename, sal from emp where deptno = 10";
   B query�� : sql ="select empno, ename, sal from emp where deptno = 20";
   
   �� ���� �ٸ��� �ν���. 
  
   �̿� ���� ������� ���� ��,
   A query���� ���� DB���� ������ �ְ� �ϰ�, 
   parameter�κи� �ٲپ 
   A�� B�� ���� query�� �����ϰ� ����. 
   
    �׷�. ���� statemet�� ��������~~
    
    PreparedStatement pstmt;�� ���� �ȴٸ� 
    PreparedStatement pstmt = conn.prepareStatement("select * from emp");   �̸� ������ ������. [�غ�� ����]
    // �������� DB�� �̸� ������ ������ ���ѳ���, ������ ������ ������ �ִ� ��ü�� ���� -> �̰� ������ ���� 
    // �׷� �Ķ���Ͱ� �ٸ��� �൵ �����ɷ� ������
    pstmt.executeQuery()'   -- �ȿ� ������ sql�� �ȵ�.  ���� Statement������ �������� ��. 
    
     ����: ����(��ŷ�� �������ʾƿ�), �̸� ������ ������ -> parameter ���� (����)
     ����: ���뼺 ������ 
     
     �߸𸣰ڴ�.. ������ �׳� preparedStatement ����ϼ���. (�������)
 */
public class Ex06_Oracle_Preparestatement {

	public static void main(String[] args) {
		Connection conn = null; // ������ �����ϴ� ��
		PreparedStatement pstmt = null;  //�������� �̸� �������°�
		ResultSet rs = null; // ������ �������� �޴°�. 
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select empno, ename, deptno from emp where deptno=?";  // ? �� parameter�� �ǹ��� 
			//Ȥ, where empno =? and ename =? and sal > ? (parameter 3��)
			// where empno = 1000 and ename ='KING' and sal > 1000
			// ? �� ������ ���� ���� ������. 
			pstmt = conn.prepareStatement(sql);
			// ���ఴü�� ������ �̸� �������� ������ �� ��ü���� ��� 
			//�غ�� �������� ����Ŭ���� ������ �� �� �������־�. �ϴ°�
			
			// ���� parameter ������ �ϸ� �� 
			pstmt.setInt(1, 30);  // 1��° �Ķ���Ϳ� 30�� �־��ش�. 
			// �ĸ����͸� �ٲٴ°��̱� ������ ����Ŭ�� �׻� ���� ������� ������. ���� ���� ������ؿ�. ���� up (����)
			
			rs = pstmt.executeQuery();
			//rs = stmt.executeQuery(sql);    -- statment�� �̷��� �߾���.
			
			
			//**���İ��� ���� 
			// �����Ͱ� ���� ���         - if�� ��Ÿ��, else�� Ÿ�� ��.
			// �����Ͱ� 1���� ���       - if�� Ÿ�� do���� Ÿ�� ��. 
			// �����Ͱ� 2���̻��� ���  - if��Ÿ�� do Ÿ��, while�� ture �Ǵϱ� �ٽ� ���ƿ�.
			
			if(rs.next())  {//��ȸ�� ����� �ϳ��� �ִٸ�
				do {
					System.out.println(rs.getInt("empno")+ " / " + rs.getString("ename") + " / " + rs.getInt("deptno"));
				}while(rs.next());
			}else {
				System.out.println("��ȸ�� �����Ͱ� �����ϴ�.");
			}
			
		}catch(Exception e) {
			
		}finally {
			//�̱��澲�� ������ �ȵǴϱ� ������ ������ �ȵſ�! rs 
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
		}
				
		

	}

}
