import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 DML(insert, update, delete)
 JDBC 작업
 1. 결과 집합이 없음. (반영만될뿐, 가져오는게 없음) SO. resultSet이 필요 X 
 2. 반영에 대한 결과를 return한다. (반영된 행의 갯수를 return) -- 만약 update로 14개 행이 수정되면, 14가 옴 
 ex. JAVA코드 
 update emp set sal = 0 >> 실반영 >> return 14 
 update emp set sal = 100 where empno=9999 >> 실행 >> return 0
 
 KEY POINT 
 DB작업시 (sqlplus, DB developer)
 insert, update, delete >> 는 트랙잭션은 일으키는 작업. >> 반드시 commit, rollback을 강제 : 전체반영, 전체 취소 처리함
 
 JDBC API를 통해서 DML 작업을 할거예요.  >> 이 DML작업은 defaul가  autocommit 
 java code를 통해 delete from emp 실행하면 >> 실제 반영됨. >> 자동으로 commit
  당신이 필요하다면 commit, rollback java코드에 제어 가능. 
  
  시작
    A계좌 인출 (update .. 
    
    B계좌 입금(update)
  끝 commit, rollback 제어하도록 코드로 작업가능. 
  
  ex. 인출, 입금이 다 update 작업인데 한번에 이루어져야하는데, 중간에 정전이 나면 인출만 되고 입금이 안되는 상황.
  이럴때는  commit, rollback 제어하도록 코드로 작업가능
  autocommit 옵션 >> false로 바꾸고 >> 반드시 프로그램에서 commit, rollback 
 */

public class Ex02_Oracle_DML_insert {  //이렇게 실행된건 commit과 rollback을 할 필요가 없다.
	public static void main(String[] args) {
		  Connection conn = null;
	      Statement stmt = null;
	      
	      try {
	         Class.forName("oracle.jdbc.OracleDriver");   // 요건 메모리에 로드 하는 거나 = new driver
	         System.out.println("오라클 드라이버 로딩");
	         
	         //1. DB연결 
	         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bituser", "1004");
	         System.out.println(conn.isClosed() + "  :  False  >>  연결");
	         
	         
	         //2. 명령생성 (CRUD)
	         stmt = conn.createStatement();
	         
	         
			 //3. 실행구문
	         
	         //1.입력받는 값을 insert 할떄 
	         int empno =0; 
	         String ename = "";
	         int deptno = 0;
	         
	         Scanner sc = new Scanner(System.in);
	         System.out.println("사번 입력");
	         empno =Integer.parseInt(sc.nextLine());
	         
	         System.out.println("이름입력");
	         ename =sc.nextLine();
	         
	         System.out.println("부서번호");
	         deptno =Integer.parseInt(sc.nextLine());
	         
	         //고전적인 방법 (...)
	         String sql ="insert into dememp(empno,ename, deptno) values(" +empno+ ",'" +ename+ "'," +deptno+ ")";
	         //values(100,'홍길동',10)" 랑 똑같이 
	         
	         //현대적인 방법 (parameter 처리) >> 실제로 사용.. 
	         //String sal = "insert into dememp(empno,ename, deptno) values(?,?,?)";
	         
	        
	         //2.값을 입력받는게 아닌 그냥 내가 집어 넣을떄
	         //String sql ="insert into dememp(empno,ename, deptno) values(100,'홍길동',10)";  
	         
	        
	         
		     //4. 실행 (결과집합을 만들지 X) 실행하는 명령어가 다름
	         int resultrow = stmt.executeUpdate(sql);
	         // ResultSet에  담을 필요가 X  
	         
	         
	         
			  //5. 처리
	         if(resultrow >0) {
	            System.out.println("반영된 행의 개수 : " + resultrow);
	         }else {
	        	// 의미가 없다. // 반영된 행이 없다면 // insert가 안되었다면
	            System.out.println("Insert Fail : " + resultrow);
	              //else를 탈일이 없음. 예외가 발생. else를 타는것이 아니라 catch로 빠져버림 
	            
				  //"insert into table dememp(empno, ename, deptno) values(100,'홍길동',10)"; 이 부분에서 잘못되면 예외발생으로 가버림. 
				  // empno에 primary key를 걸어놨기때문에 두번하면 터짐. 
	         }
	         
	         
	      }catch(Exception e){
	         System.out.println("Insert Fail  예외 발생: " + e.getMessage());
	         
	      }finally {
	         try {
	            stmt.close(); //너네 혹시 이거 만들지도 않았는데 닫는거아니야? 하고 예외처리 해달라고 함
	            conn.close();
	         } catch (SQLException e) {

	            e.printStackTrace();
	         }
	         
	      }
	}
}
