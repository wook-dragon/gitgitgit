import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import kr.or.bit.utils.ConnectionHelper;
import kr.or.bit.utils.SingletonHelper;

/*
  Statement stmt = conn.createStatement(); //명령에 필요한 객체를 획득하는 과정 
  String sql ="select empno, ename, sal from emp";  //이 구문을 오라클 서버한테 던지는 것. 
  ResultSet rs = stmt.executeQuery(sql);//db서버에 생성된 결과집합(메모리)에 접근해서 데이터를 읽을 수 있음.
 
 
   장점 : Query문을 바꾸어서 실행이 가능하다. ex. "select empno, ename, sal from emp" 를 "select deptno, dname from dept";로 바꿔서 사용
             고정문 컬럼명, 테이블명, 조건이 같으면 성능이 좋음.
   단점 : Query문이 변화가 생기면 성능이 떨어짐. (새로운 쿼리를 보낼때마다 다시 뭔가를 실행하기 때문에)
   
   쿼리문이 조건만 바뀌어도 성능을 유지하는 방법은 없을까?
   A query문 : sql ="select empno, ename, sal from emp where deptno = 10";
   B query문 : sql ="select empno, ename, sal from emp where deptno = 20";
   
   이 둘을 다르게 인식함. 
  
   이에 대한 대안으로 나온 것,
   A query문을 먼저 DB에서 가지고 있게 하고, 
   parameter부분만 바꾸어서 
   A와 B를 같은 query로 인정하게 하자. 
   
    그럼. 이제 statemet는 버리세요~~
    
    PreparedStatement pstmt;를 쓰게 된다면 
    PreparedStatement pstmt = conn.prepareStatement("select * from emp");   미리 쿼리를 보내요. [준비된 실행]
    // 쿼리문을 DB에 미리 보내서 컴파일 시켜놓고, 쿼리의 정보를 가지고 있는 객체를 리턴 -> 이걸 가지고 실행 
    // 그럼 파라미터가 다른걸 줘도 같은걸로 인정함
    pstmt.executeQuery()'   -- 안에 쿼리문 sql이 안들어감.  위에 Statement에서는 쿼리문이 들어감. 
    
     장점: 보안(해킹을 당하지않아요), 미리 쿼리문 컴파일 -> parameter 설정 (성능)
     단점: 재사용성 떨어짐 
     
     잘모르겠다.. 싶으면 그냥 preparedStatement 사용하세요. (권장사항)
 */
public class Ex06_Oracle_Preparestatement {

	public static void main(String[] args) {
		Connection conn = null; // 서버랑 연결하는 것
		PreparedStatement pstmt = null;  //쿼리문을 미리 보내놓는것
		ResultSet rs = null; // 쿼리문 실행결과를 받는것. 
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select empno, ename, deptno from emp where deptno=?";  // ? 는 parameter를 의미함 
			//혹, where empno =? and ename =? and sal > ? (parameter 3개)
			// where empno = 1000 and ename ='KING' and sal > 1000
			// ? 는 순서에 따라서 값을 설정함. 
			pstmt = conn.prepareStatement(sql);
			// 실행객체를 얻을때 미리 쿼리문을 보내서 그 객체정보 얻기 
			//준비된 쿼리문을 오라클한테 던져서 너 좀 가지고있어. 하는것
			
			// 이제 parameter 설정만 하면 됨 
			pstmt.setInt(1, 30);  // 1번째 파라미터에 30을 넣어준다. 
			// 파마리터만 바꾸는것이기 떄문에 오라클은 항상 같은 쿼리라고 생각함. 구문 따로 실행안해요. 성능 up (재사용)
			
			rs = pstmt.executeQuery();
			//rs = stmt.executeQuery(sql);    -- statment는 이렇게 했었음.
			
			
			//**공식같은 로직 
			// 데이터가 없는 경우         - if문 안타고, else문 타서 끝.
			// 데이터가 1건인 경우       - if문 타고 do까지 타고 끝. 
			// 데이터가 2건이상인 경우  - if문타고 do 타고, while문 ture 되니까 다시 돌아요.
			
			if(rs.next())  {//조회된 결과가 하나라도 있다면
				do {
					System.out.println(rs.getInt("empno")+ " / " + rs.getString("ename") + " / " + rs.getInt("deptno"));
				}while(rs.next());
			}else {
				System.out.println("조회된 데이터가 없습니다.");
			}
			
		}catch(Exception e) {
			
		}finally {
			//싱글톤쓰면 닫으면 안되니까 연결은 끊으면 안돼요! rs 
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
		}
				
		

	}

}
