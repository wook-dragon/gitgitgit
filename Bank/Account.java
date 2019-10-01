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
		this.transactions.add(new Transaction("�Ա�", amount, this.balance));
		System.out.println(name +"�� "+amount+"�� �ԱݵǾ����ϴ�");
	}
	public void withdraw(long amount) {
		if(balance>=amount) {
			balance -= amount;
			transactions.add(new Transaction("���", amount, balance));
			System.out.println(name +"�� "+amount+"�� ��ݵǾ����ϴ�");
		}else {
			System.out.println("�ܾ��� �����մϴ�");
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
		return "�������� [�̸� : " + name + "/ �ܾ� : " + balance + "/ Ʈ����� : " + transactions + "]";
	}
	public String getName() {
		return name;
	}
	
}
