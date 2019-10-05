import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.or.bit.utils.ConnectionHelper;
import kr.or.bit.utils.SingletonHelper;

public class Ex08_Oracle_PreparedStatement_update {

	public static void main(String[] args) {
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "update dememp set comm =?, sal =? where deptno =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1000);
			pstmt.setInt(2, 2000);
			pstmt.setInt(3, 10);
			
			int row = pstmt.executeUpdate(); 
			
			if(row > 0) {
				System.out.println("update row count :" + row);
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

