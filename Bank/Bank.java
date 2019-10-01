import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank {
	public HashMap<String, Account> accounts;
	public static Scanner sc;
	
	Bank(){
		this.accounts = new HashMap<String, Account>();
		Bank.sc = new Scanner(System.in);
	}
	public void addAccount(String accountNo, String name) {
		accounts.put(accountNo, new Account(name));
	}
	public Account getAccount(String accountNo) {
		if(accounts.containsKey(accountNo)) {
			for(int i=0;i<accounts.size();i++) {
				return accounts.get(accountNo);
			}
		}else {
			System.out.println("ã���ô� ���°� �����ϴ�");
		}
		return null;
	}
	public ArrayList<Account> findAccounts(String name){
		ArrayList<Account> findName = new ArrayList<Account>();
		for(Map.Entry m : accounts.entrySet()) {
			if(((Account)m.getValue()).name.equals(name)) {
				findName.add(((Account)m.getValue()));
			}
		}
		if(findName.size()==0) {
			System.out.println("ã���ô� �̸��� �����ϴ�");
		}
		return findName;
	}
	public void getAccounts(){
		for(Map.Entry m : accounts.entrySet()) {
			System.out.println("�������� : "+m.getKey()+" / ���� : "+((Account)m.getValue()).name + " / �ܾ� : "+ ((Account)m.getValue()).balance+ " / Ʈ����� : "+((Account)m.getValue()).transactions);
		}
	}
	
}
