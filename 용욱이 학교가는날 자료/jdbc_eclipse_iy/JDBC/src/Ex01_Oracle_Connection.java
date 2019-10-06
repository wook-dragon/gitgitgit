import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
JDBC
1. Java 를 통해서 Oracle 연결 하고 CRUD 작업(insert, select, update, delete)
2. 어떠한 DB 소프트웨어 사용 결정 (Oracle , mysql , ms-sql) 
2.1 제품에 맞는 드라이버필요 (각 벤더 사이트에서 다운로드 받아서 사용)
2.2 오라클 (로컬 PC 오라클 DB 서버 설치) >> ojdbc6.jar (드라이버 파일)
     C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib
     >>(이동시켜둠) C:\SmartWeb\Database\JDBC\Connect_Utils\oracleDriver
     
3. Cmd 기반의 Java Project 에서는 드라이버 사용하기 위해서 참조 
3.1 java Build Path (jar 추가) 하는 작업
3.2 드라이버 사용준비 완료  >> 드라이버 사용할 수 있도록 메모리 (new ..)
3.3 class.forName("class 이름") >> new 동일한 효과 

***
자바 1.6 이상부터는 
Console 기반의 프로젝트에서 프로젝트 참조 만으로 등록 사용 가능합니다
서비스로더(http://docs.oracle.com/javase/6/docs/api/java/util/ServiceLoader.html)) 기반으로 JDBC Driver가 자동으로 등록됩니다.
그래서 Class.forName("com.mysql.jdbc.Driver") 류의 코드를 호출하지 않아도 됩니다. :)
//class.forName을 해서 드라이버를 메모리에 올려줘야하는데, jar 파일 추가만으로도 이 작업이 가능하게 됨. 
***
그래도 해보자! 





4.JAVA ( JDBC API)
4.1 import java.sql.*; 제공하는 자원 (대부분의 자원은 : interface , class)
4.2 개발자는 interface 를 통해서 작업 ( 궁긍증 : why interface 일까?  hint)Oracle 뿐만 아니라 다른 다양한 DB 사용 )

5. DB연결  -> 명령 -> 실행 -> 처리  -> 자원해제
5.1 명령 (CRUD) : select , insert , update , delete
5.2 처리 : select 화면 출력할꺼야  아니야  난 확인만 ...........
5.3 자원해제 (성능)  :(IO떄 배움. 가비지컬렉터가 DB연결, 네트워크 끊는건 할 수 없음. 메모리에서 일어나는 일이 아니기때문) .. 자원해제 안하면 메모리 FULL됨

*연결 문자열 (ConnectionString) 설정
채팅 (client  ->  server 연결하기 위해서)
네트워크 DB (서버 IP , PORT , SID(전역 데이터베이스 이름) , 접속계정 , 접속 비번)
   

 
*/

public class Ex01_Oracle_Connection {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver"); //예외발생. 이런게 존재하지 않을 수 있으니
		//이런드라이브를 new해서 메모리에서 쓰겠다. class.forName은 new driver랑 같은 의미
		System.out.println("오라클 드라이버 로딩");
		
		//1. DB연결 
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bituser", "1004"); 
		//jdbc:oracle:thin:@정해진 약속! 바꾸면 X
		//localhost 호스트 번호. 나중에는 ip를 여기에 써야함. ex. @192.168.0.3
		
		//getConnection 내부에서 new Connection해서 객체 생성 >> Connection 인터페이스를 부모로 .. 생성된 객체 주소를 리턴. 
		//리턴한걸 Connection 인터페이스가 받음  
		//오라클 , mysql꺼 다 Connection이 받을 수 있음 
		System.out.println(conn.isClosed()+ " : false >> 연결"); //너 연결 끊어졌니? false가 찍혀야 DB한테 연결 되어있음 . 

		
		//2. 명령생성 (CRUD)
		Statement stmt = conn.createStatement(); //명령에 필요한 객체를 획득하는 과정 
		
		String sql ="select empno, ename, sal from emp";  //이 구문을 오라클 서버한테 던지는 것. 
		
		//3. 2에서 한 명령을 실행 + 처리도 같이 >> 처리방식은 데이터 조회로 
		//명령 select할거냐 or insert, update, delete할거냐. 둘로 나뉨 / insert, update, delete는 결과 집합이 없음.
		ResultSet rs = stmt.executeQuery(sql);//db서버에 생성된 결과집합(메모리)에 접근해서 데이터를 읽을 수 있음.
		//ResultSet은 이를 담을 수 있는 인터페이스 
		
		
		//4. 처리(조회)
		while(rs.next()) {//next는 select한 집합이 있니? 하고 물음. 있다고true 하면 while안으로 들어감 
			System.out.println(rs.getInt("empno")+ " / " + rs.getString("ename") + " / " + rs.getInt("sal"));
			//	System.out.println(rs.getInt(1)+ " / " + rs.getString(2) + " / " + rs.getInt(3)); 
				//  -- 컬럼의 순서를 적어도됨. 이때 숫자는 index가 아니기 때문에 1부터 시작
			//함수가 데이터를 가져옴. getter와 비슷함   getInt 받으려는게 숫자타입. empno받을거야.   ename은 String 타입
			//첫번째 데이터 뿌리고 while문은 데이터가 없을때까지 돌아요. 없으면 false값 return하기 때문
		}
	
		
		//5. 연결 해제 
		rs.close();
		conn.close();
		System.out.println("DB연결 : True " + conn.isClosed());   //닫혀있니? true가 나와야 잘된것. 
		
	}

}
