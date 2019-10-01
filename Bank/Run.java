import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

public class Run {
	Bank b=new Bank();
	Scanner sc = new Scanner(System.in);
	File file = new File("bank.txt");
	void run() {
		do {
			System.out.println("�ȳ��ϼ��� ��ũ�Դϴ�^^");
			  System.out.println("1. ���»���");
		      System.out.println("2. �����Ա�");
		      System.out.println("3. �������");
		      System.out.println("4. ����ã��(���¹�ȣ)");
		      System.out.println("5. ����ã��(�����ڸ�)");
		      System.out.println("6. ���¸��");
		      System.out.println("7. �Ѱ��¼�");
		      System.out.println("8. Ʈ����� Ȯ��");
		      System.out.println("9. �ý�������");
		      System.out.println("1~9�����߿� �����ּ���");
		      String select = sc.nextLine();
		      switch (select) {
			case "1":
				if(file.exists()) {
					loadBank();
				}
				System.out.println("���� �����Դϴ�");
				System.out.println("�����Ͻ� ������ ���¹�ȣ�� �Է����ּ���");
				String accountNo = sc.nextLine();
				System.out.println("������ �Է����ּ���");
				String name = sc.nextLine();
				b.addAccount(accountNo, name);
				saveBank();
				break;
			case "2":
				if(file.exists()) {
					loadBank();
				}else {
					System.out.println("���� ���°� �����ϴ�");
					return;
				}
				System.out.println("���� �Ա��Դϴ�");
				System.out.println("���¹�ȣ�� �Է����ּ���");
				String deposit = sc.nextLine();
				if(b.accounts.containsKey(deposit)) {
					System.out.println("�Աݾ��� �Է����ּ���");
					long amount = Long.parseLong(sc.nextLine());
					b.accounts.get(deposit).deposit(amount);
					saveBank();
				}else {
					System.out.println("���¹�ȣ�� Ʋ�Ƚ��ϴ�");
				}
				break;
			case "3":
				if(file.exists()) {
					loadBank();
				}else {
					System.out.println("���� ���°� �����ϴ�");
					return;
				}
				System.out.println("���� ����Դϴ�");
				System.out.println("���¹�ȣ�� �Է����ּ���");
				String withraw = sc.nextLine();
				if(b.accounts.containsKey(withraw)) {
					System.out.println("�Աݾ��� �Է����ּ���");
					long amount = Long.parseLong(sc.nextLine());
					b.accounts.get(withraw).withdraw(amount);
					saveBank();
				}else {
					System.out.println("���¹�ȣ�� Ʋ�Ƚ��ϴ�");
				}
				break;
			case "4":
				if(file.exists()) {
					loadBank();
				}else {
					System.out.println("���� ���°� �����ϴ�");
					return;
				}
				System.out.println("����ã�� �Դϴ�");
				System.out.println("���¹�ȣ�� �Է����ּ���");
				String findnum = sc.nextLine();
				System.out.println(b.getAccount(findnum));
				break;
			case "5":
				if(file.exists()) {
					loadBank();
				}else {
					System.out.println("���� ���°� �����ϴ�");
					return;
				}
				System.out.println("����ã�� �Դϴ�");
				System.out.println("������ �Է����ּ���");
				String namefind = sc.nextLine();
				System.out.println(b.findAccounts(namefind));
				break;
			case "6":
				if(file.exists()) {
					loadBank();
				}else {
					System.out.println("���� ���°� �����ϴ�");
					return;
				}
				b.getAccounts();
				break;
			case "7":
				if(file.exists()) {
					loadBank();
				}else {
					System.out.println("���� ���°� �����ϴ�");
					return;
				}
				System.out.println("�� ���¼��� "+b.accounts.size()+"�� �Դϴ�");
				break;
			case "8":
				if(file.exists()) {
					loadBank();
				}else {
					System.out.println("���� ���°� �����ϴ�");
					return;
				}
				System.out.println("Ʈ������� Ȯ���� ���¹�ȣ�� �Է����ּ���");
				String trancheck = sc.nextLine();
				if(b.accounts.containsKey(trancheck)) {
					System.out.println(b.accounts.get(trancheck).getTransactions());
				}else {
					System.out.println("���¹�ȣ�� Ʋ�Ƚ��ϴ�");
				}
//				for(int i=0;i<b.accounts.size();i++){
//					System.out.println(b.accounts.get(i).getTransactions());
//				}
				break;
			case "9":
				System.out.println("�ȳ���������");
				System.exit(0);
			default:
				break;
			}
		}while(true);

	}
	void saveBank() {
		File f=null;
		FileOutputStream fos = null;
		BufferedOutputStream bos= null;
		ObjectOutputStream oos = null;
		try {
			f = new File("bank.txt");
			fos = new FileOutputStream(f);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			oos.writeObject(b.accounts);
		} catch (Exception e) {
			// TODO: handle exception
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
	void loadBank() {
		File f= null;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			f = new File("bank.txt");
			fis = new FileInputStream(f);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			b.accounts = (HashMap<String, Account>) ois.readObject();
		} catch (Exception e) {
			// TODO: handle exception
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
}
