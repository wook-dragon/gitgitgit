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
			System.out.println("찾으시는 계좌가 없습니다");
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
			System.out.println("찾으시는 이름이 없습니다");
		}
		return findName;
	}
	public void getAccounts(){
		for(Map.Entry m : accounts.entrySet()) {
			System.out.println("계좌정보 : "+m.getKey()+" / 성명 : "+((Account)m.getValue()).name + " / 잔액 : "+ ((Account)m.getValue()).balance+ " / 트랜잭션 : "+((Account)m.getValue()).transactions);
		}
	}
	
}
