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
			System.out.println("�ȳ��ϼ��� MyBMI�Դϴ�");
			System.out.println("<1>�α��� <2>ȸ������ <3>�ý�������");
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
				System.out.println("�ٽ� �Է��ϼ���");
				break;
			}
		}while(true);
		
	}
	public void login() {
		if(f1.exists()) {
			memberload();
		}
		System.out.println("�α����Դϴ�");
		System.out.println("���̵� �Է����ּ���");
		insertid = sc.nextLine();
		if(member.containsKey(insertid)) {
			System.out.println("��й�ȣ�� �Է����ּ���");
			String insertpw = sc.nextLine();
			if(member.get(insertid).equals(insertpw)) {
				System.out.println("�α��� �Ǽ̽��ϴ�");
				usermenu();
			}else {
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�");
				return;
			}
		}else {
			System.out.println("���̵� Ʋ�Ƚ��ϴ�");
			return;
		}
	}
	public void signin() {
		if(f1.exists()) {
			memberload();
		}
		System.out.println("�ȳ��ϼ��� ȸ�������Դϴ�");
		System.out.println("����Ͻ� ���̵� �Է����ּ���");
		id = sc.nextLine();
		if(!member.containsKey(id)) {
			System.out.println("����Ͻ� ��й�ȣ�� �Է����ּ���");
			pw=sc.nextLine();
			member.put(id, pw);
			membersave();
		}else {
			System.out.println("�̹� ������� ���̵��Դϴ�");
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
			System.out.println("<1>�߰� <2>���� <3>��� <4>���� <5>�ε� <6>�α׾ƿ�");
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
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
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
			System.out.println("�����Ͻ� ��ȣ�� �Է����ּ���");
			int select = Integer.parseInt(sc.nextLine());
			if(mybmi.containsKey(select)) {
				mybmi.remove(select);
			}
	}
	public void print() {
			Set<Integer> set = mybmi.keySet();
			for(Integer number : set) {
				System.out.println(number +"�� : "+ mybmi.get(number));
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
				System.out.println("���� ������ �����ϴ�");
			}
		}
}
