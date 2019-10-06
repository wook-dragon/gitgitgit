import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.or.bit.utils.ConnectionHelper;
import kr.or.bit.utils.SingletonHelper;

//똑같은 작업인데 insert를 하고싶어요
//앞이랑 똑같은 구문인데 하나만 바껴요.
//그리고 Resultset 할필요 X
public class Ex07_Oracle_PreparedStatement_dml {

	public static void main(String[] args) {
		//insert into dememp(empno, ename, sal, deptno)
		//values(?, ?, ?, ?)
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "insert into dememp(empno, ename, sal, deptno) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 5555);
			pstmt.setString(2, "김유신");
			pstmt.setInt(3, 1000);
			pstmt.setInt(4, 10);
			
			int row = pstmt.executeUpdate(); // insert, update, delete >> executeUpdate()
			
			if(row > 0) {
				System.out.println("insert row count :" + row);
			}else {
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			ConnectionHelper.close(pstmt);
		}
	}

}
