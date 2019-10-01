import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable{
	String name;
	long balance;
	ArrayList<Transaction> transactions;
	public Account(String name){
		this.name = name;
		this.balance=this.balance;
		this.transactions=new ArrayList<Transaction>();
	}
	public void deposit(long amount) {
		this.balance += amount;
		this.transactions.add(new Transaction("입금", amount, this.balance));
		System.out.println(name +"님 "+amount+"원 입금되었습니다");
	}
	public void withdraw(long amount) {
		if(balance>=amount) {
			balance -= amount;
			transactions.add(new Transaction("출금", amount, balance));
			System.out.println(name +"님 "+amount+"원 출금되었습니다");
		}else {
			System.out.println("잔액이 부족합니다");
		}
		
	}
	public long getBalance() {
		return balance;
	}
	public ArrayList<Transaction> getTransactions(){
		return transactions;
	}
	@Override
	public String toString() {
		return "계좌정보 [이름 : " + name + "/ 잔액 : " + balance + "/ 트랜잭션 : " + transactions + "]";
	}
	public String getName() {
		return name;
	}
	
}
