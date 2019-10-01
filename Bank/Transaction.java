import java.io.Serializable;
import java.util.Calendar;

public class Transaction implements Serializable{
	String transactionDate;
	String transactionTime;
	String kind;
	long amount;
	long balance;
	Calendar cal = Calendar.getInstance();
	public Transaction(String kind, long amount, long balance) {
		this.transactionDate = cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH+1)+"-"+cal.get(Calendar.DATE);
		this.transactionTime = cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND);
		this.kind=kind;
		this.amount = amount;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Ʈ����� [��¥ : " + transactionDate + "/ �ð� : " + transactionTime + "/ �ݾ� : "
				+ amount + "/ �ܾ�=" + balance + "]";
	}
	
}
