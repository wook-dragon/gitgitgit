import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Member implements Serializable{
	static String id;
	static String pw;
	static String select;
	static String insertid;
	static int count;
	static Scanner sc;
	static HashMap<String, String> member;
	static HashMap<Integer, MyBMI> mybmi;
	File f1 = new File("member.txt");
	public Member() {
		this.id="";
		this.pw="";
		this.select="";
		this.insertid="";
		this.count=1;
		this.sc = new Scanner(System.in);
		this.member = new HashMap<String, String>();
		this.mybmi = new HashMap<Integer, MyBMI>();
	}
	public void FirstMenu() {
		do {
			System.out.println("안녕하세요 MyBMI입니다");
			System.out.println("<1>로그인 <2>회원가입 <3>시스템종료");
			select = sc.nextLine();
			switch(select) {
			case "1":
				login();
				break;
			case "2":
				signin();
				break;
			case "3":
				System.exit(0);
			default:
				System.out.println("다시 입력하세요");
				break;
			}
		}while(true);
		
	}
	public void login() {
		if(f1.exists()) {
			memberload();
		}
		System.out.println("로그인입니다");
		System.out.println("아이디를 입력해주세요");
		insertid = sc.nextLine();
		if(member.containsKey(insertid)) {
			System.out.println("비밀번호를 입력해주세요");
			String insertpw = sc.nextLine();
			if(member.get(insertid).equals(insertpw)) {
				System.out.println("로그인 되셨습니다");
				usermenu();
			}else {
				System.out.println("비밀번호가 틀렸습니다");
				return;
			}
		}else {
			System.out.println("아이디가 틀렸습니다");
			return;
		}
	}
	public void signin() {
		if(f1.exists()) {
			memberload();
		}
		System.out.println("안녕하세요 회원가입입니다");
		System.out.println("사용하실 아이디를 입력해주세요");
		id = sc.nextLine();
		if(!member.containsKey(id)) {
			System.out.println("사용하실 비밀번호를 입력해주세요");
			pw=sc.nextLine();
			member.put(id, pw);
			membersave();
		}else {
			System.out.println("이미 사용중인 아이디입니다");
			return;
		}
	}
	public void membersave() {
		File file = new File("member.txt");
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			oos.writeObject(member);
		} catch (Exception e) {
			
		}finally {
			try {
				oos.close();
				bos.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void memberload() {
		File file = new File("member.txt");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			member = (HashMap)ois.readObject();
		} catch (Exception e) {
			
		}finally {
			try {
				ois.close();
				bis.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//////////////////////////////////////////////////////////////////
	public void usermenu() {
		do {
			System.out.println("<1>추가 <2>삭제 <3>출력 <4>저장 <5>로드 <6>로그아웃");
			select = sc.nextLine();
			switch (select) {
			case "1":
				add();
				break;
			case "2":
				delete();
				break;
			case "3":
				print();
				break;
			case "4":
				bmisave();
				break;
			case "5":
				bmiload();
				break;
			case "6":
				FirstMenu();
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}while(!select.equals("6"));
		
	}
	public void add() {
		mybmi.put(count, new MyBMI());
		count++;
	}
	public void delete() {
			print();
			System.out.println("삭제하실 번호를 입력해주세요");
			int select = Integer.parseInt(sc.nextLine());
			if(mybmi.containsKey(select)) {
				mybmi.remove(select);
			}
	}
	public void print() {
			Set<Integer> set = mybmi.keySet();
			for(Integer number : set) {
				System.out.println(number +"번 : "+ mybmi.get(number));
			}
			
	}
	public void bmisave() {
		File file = new File(insertid+"'s bmi.txt");
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			oos.writeObject(mybmi);
		} catch (Exception e) {

		}finally {
			try {
				oos.close();
				bos.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void bmiload() {
			File file = new File(insertid+"'s bmi.txt");
			if(file.exists()) {
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				ObjectInputStream ois = null;
				try {
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					ois = new ObjectInputStream(bis);
					mybmi = (HashMap)ois.readObject();
					
				} catch (Exception e) {

				}finally {
					try {
						ois.close();
						bis.close();
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}else {
				System.out.println("아직 파일이 없습니다");
			}
		}
}
