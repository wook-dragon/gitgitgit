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
			System.out.println("안녕하세요 뱅크입니다^^");
			  System.out.println("1. 계좌생성");
		      System.out.println("2. 계좌입금");
		      System.out.println("3. 계좌출금");
		      System.out.println("4. 계좌찾기(계좌번호)");
		      System.out.println("5. 계좌찾기(소유자명)");
		      System.out.println("6. 계좌목록");
		      System.out.println("7. 총계좌수");
		      System.out.println("8. 트랜잭션 확인");
		      System.out.println("9. 시스템종료");
		      System.out.println("1~9까지중에 눌러주세요");
		      String select = sc.nextLine();
		      switch (select) {
			case "1":
				if(file.exists()) {
					loadBank();
				}
				System.out.println("계좌 생성입니다");
				System.out.println("생성하실 계좌의 계좌번호를 입력해주세요");
				String accountNo = sc.nextLine();
				System.out.println("성함을 입력해주세요");
				String name = sc.nextLine();
				b.addAccount(accountNo, name);
				saveBank();
				break;
			case "2":
				if(file.exists()) {
					loadBank();
				}else {
					System.out.println("아직 계좌가 없습니다");
					return;
				}
				System.out.println("계좌 입금입니다");
				System.out.println("계좌번호를 입력해주세요");
				String deposit = sc.nextLine();
				if(b.accounts.containsKey(deposit)) {
					System.out.println("입금액을 입력해주세요");
					long amount = Long.parseLong(sc.nextLine());
					b.accounts.get(deposit).deposit(amount);
					saveBank();
				}else {
					System.out.println("계좌번호가 틀렸습니다");
				}
				break;
			case "3":
				if(file.exists()) {
					loadBank();
				}else {
					System.out.println("아직 계좌가 없습니다");
					return;
				}
				System.out.println("계좌 출금입니다");
				System.out.println("계좌번호를 입력해주세요");
				String withraw = sc.nextLine();
				if(b.accounts.containsKey(withraw)) {
					System.out.println("입금액을 입력해주세요");
					long amount = Long.parseLong(sc.nextLine());
					b.accounts.get(withraw).withdraw(amount);
					saveBank();
				}else {
					System.out.println("계좌번호가 틀렸습니다");
				}
				break;
			case "4":
				if(file.exists()) {
					loadBank();
				}else {
					System.out.println("아직 계좌가 없습니다");
					return;
				}
				System.out.println("계좌찾기 입니다");
				System.out.println("계좌번호를 입력해주세요");
				String findnum = sc.nextLine();
				System.out.println(b.getAccount(findnum));
				break;
			case "5":
				if(file.exists()) {
					loadBank();
				}else {
					System.out.println("아직 계좌가 없습니다");
					return;
				}
				System.out.println("계좌찾기 입니다");
				System.out.println("성함을 입력해주세요");
				String namefind = sc.nextLine();
				System.out.println(b.findAccounts(namefind));
				break;
			case "6":
				if(file.exists()) {
					loadBank();
				}else {
					System.out.println("아직 계좌가 없습니다");
					return;
				}
				b.getAccounts();
				break;
			case "7":
				if(file.exists()) {
					loadBank();
				}else {
					System.out.println("아직 계좌가 없습니다");
					return;
				}
				System.out.println("총 계좌수는 "+b.accounts.size()+"개 입니다");
				break;
			case "8":
				if(file.exists()) {
					loadBank();
				}else {
					System.out.println("아직 계좌가 없습니다");
					return;
				}
				System.out.println("트랜잭션을 확인할 계좌번호를 입력해주세요");
				String trancheck = sc.nextLine();
				if(b.accounts.containsKey(trancheck)) {
					System.out.println(b.accounts.get(trancheck).getTransactions());
				}else {
					System.out.println("계좌번호가 틀렸습니다");
				}
//				for(int i=0;i<b.accounts.size();i++){
//					System.out.println(b.accounts.get(i).getTransactions());
//				}
				break;
			case "9":
				System.out.println("안녕히가세요");
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
