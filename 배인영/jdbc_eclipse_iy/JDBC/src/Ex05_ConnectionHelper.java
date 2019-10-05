import java.sql.Connection;
import java.sql.SQLException;

import kr.or.bit.utils.ConnectionHelper;
import kr.or.bit.utils.SingletonHelper;

public class Ex05_ConnectionHelper {

	public static void main(String[] args) throws SQLException {
		
		//1번째 케이스
		Connection conn = null;
		conn = ConnectionHelper.getconnection("oracle");
		System.out.println(conn.toString());
		//--metadata 함수를 통해 버젼, 이름을 알 수 있음
		System.out.println(conn.getMetaData().getDatabaseProductName());     //Oracle
		System.out.println(conn.getMetaData().getDatabaseProductVersion());  //Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production
		System.out.println("연결여부 : " + conn.isClosed());  //false (연결되어있어!)
		
		// close하는 함수를 오버로딩으로 다 만들어서 사용. (ConnectionHelper함수는 static으로 만들어서 new하는것 없이 바로 사용. 
		ConnectionHelper.close(conn);
		System.out.println("연결여부 : " + conn.isClosed()); //true (응. 끊어져있어!)
		
		
		System.out.println("-----------------------------------------------------");
		
		////////////////////////////////////////////////////////////////////////// 
		//2번째 케이스 
		// bituser말고, 다른 아이디로 접속하고싶어요! 
		//overloading 함수 만듦.
		
		
		Connection conn2 = null;
		conn2 = ConnectionHelper.getconnection("oracle","hr","1004");
		System.out.println(conn2.toString());
		//--metadata 함수를 통해 버젼, 이름을 알 수 있음
		System.out.println(conn2.getMetaData().getDatabaseProductName());     //Oracle
		System.out.println(conn2.getMetaData().getDatabaseProductVersion());  //Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production
		System.out.println("연결여부 : " + conn2.isClosed());  //false (연결되어있어!)
		
		// close하는 함수를 오버로딩으로 다 만들어서 사용. (ConnectionHelper함수는 static으로 만들어서 new하는것 없이 바로 사용. 
		ConnectionHelper.close(conn2);
		System.out.println("연결여부 : " + conn2.isClosed()); //true (응. 끊어져있어!)
		
		/////////////////////////////////////////////////////////////////////////
		//3번째 케이스 
		conn2 = null;
		conn2 = ConnectionHelper.getconnection("oracle","hr","1004");
		System.out.println(conn2.toString());
		//--metadata 함수를 통해 버젼, 이름을 알 수 있음
		System.out.println(conn2.getMetaData().getDatabaseProductName());     //Oracle
		System.out.println(conn2.getMetaData().getDatabaseProductVersion());  //Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production
		System.out.println("연결여부 : " + conn2.isClosed());  //false (연결되어있어!)
		
		// close하는 함수를 오버로딩으로 다 만들어서 사용. (ConnectionHelper함수는 static으로 만들어서 new하는것 없이 바로 사용. 
		ConnectionHelper.close(conn2);
		System.out.println("연결여부 : " + conn2.isClosed()); //true (응. 끊어져있어!)
		
		
		//1.연결객체 주소 : oracle.jdbc.driver.T4CConnection@4629104a
		//2.연결객체 주소 : oracle.jdbc.driver.T4CConnection@7fac631b
		//3.연결객체 주소 : oracle.jdbc.driver.T4CConnection@5b87ed94
		// 다른 연결객체 주소가 됨 
		
		// 하나의 APP 연결할때마다 객체를 생성하고 그 것을 사용하는게 맞을까?
		// 자바에서 배운것이 하나 있는데, 하나의 객체를 만들고 공유하는방법 ..
		
		//////////////////////////////////////////////////////////////////////////////////////
		//singletone : 하나를 만들고 그 주소를 갖다 쓴다. (한개의 객체를 재사용하고싶음)  -- but, 이 방법이 JDBC에서 권장하는 방법은 아니예요. / 수업용으로 좋아요.!
		
		
	    Connection conn3 = null;
	    conn3 = SingletonHelper.getConnection("oracle");
	    System.out.println(conn3.toString());
	    System.out.println(conn3.getMetaData().getDatabaseProductName());
	    System.out.println(conn3.getMetaData().getDatabaseProductVersion());
	    //System.out.println("연결여부 : " + conn.isClosed());
	    //객체 리턴 : oracle.jdbc.driver.T4CConnection@6e0e048a
	    ConnectionHelper.close(conn3);  // 이렇게 연결을 해제하면 과연, Connection conn3 객체가 null을 가질까?
	    //연결을 해제한거랑, connection conn3 객체가 가진 주소가 없어진건 아니예요. 
	    
	    //이미 얻어낸 연결은 주소는 있는데, 그 주소가 연결이 끊어진 주소. 
	    //그럼 밑에 conn4는 연결이 끊어진 주소를 받음. conn = null을 타는게 아니라, conn !null 구문을 타게 됨. 
	    // Exception in thread "main" java.sql.SQLRecoverableException: 접속 종료   라고 뜸
	    
	    
	    
	    //***************
	    //그럼, 아래 싱글톤 객체 get Connection이 새로운 연결 객체를 받아오게 하고 싶음 
	    //if를 타지않게 만들어줘야함. 
	    // 해결방법 !  (객체를 다시 열어주는 함수를 만들어서 사용)
	    SingletonHelper.dbClose();
	    
	   
	    
	    
	    Connection conn4 = null;
	    conn4 = SingletonHelper.getConnection("oracle");
	    System.out.println(conn4.toString());
	    System.out.println(conn4.getMetaData().getDatabaseProductName());
	    System.out.println(conn4.getMetaData().getDatabaseProductVersion());
	    //객체 리턴 : conn is not null.. return : oracle.jdbc.driver.T4CConnection@6e0e048a
		
		
	    
	    //** 이렇게 singleton 사용시 문제점은 무엇일까요?
	    //** DB연결 해제 어느시점에 적용해야 할까요? 
	    //음.. 공유객체의 문제점은 누군가 바꾸면 모두가 바뀐다는 문제점을 가짐. 
	    
	    /////////////////////////////////////////////////////////////////////////////////////
	    
		
	}
}
