import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.or.bit.utils.ConnectionHelper;
import kr.or.bit.utils.SingletonHelper;

public class Ex09_Oracle_PreparedStatement_delete {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "delete from dememp where sal > ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 2000);
			
			int row = pstmt.executeUpdate(); // insert, update, delete >> executeUpdate()
			
			if(row > 0) {
				System.out.println("delete row count :" + row);
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
