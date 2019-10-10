import java.io.Serializable;
import java.util.Scanner;

public class MyBMI implements Serializable{
	double height;
	double weight;
	double result;
	String you;
	public MyBMI() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Ű�� �Է��ϼ��� : ");
		this.height = Double.parseDouble(scan.nextLine());
		System.out.print("�����Ը� �Է��ϼ��� : ");
		this.weight = Double.parseDouble(scan.nextLine());
		this.result = this.weight/((this.height/100.0)*(this.height/100.0));
		if(this.result<18.5){
			this.you = "ü�� ����";
		}else if(18.5<=this.result && this.result<=22.9){
			this.you = "����";
		}else if(23.0<=this.result && this.result<=24.9){
			this.you = "��ü��";
		}else if(25.0<=this.result){
			this.you = "��";
		}
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public String getYou() {
		return you;
	}
	public void setYou(String you) {
		this.you = you;
	}
	@Override
	public String toString() {
		return "[Ű=" + height + " / ������=" + weight + " / BMI=" + result + " / ���=" + you + "]";
	}
	
}
