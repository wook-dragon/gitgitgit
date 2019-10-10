import java.io.Serializable;
import java.util.Scanner;

public class MyBMI implements Serializable{
	double height;
	double weight;
	double result;
	String you;
	public MyBMI() {
		Scanner scan = new Scanner(System.in);
		System.out.print("키를 입력하세요 : ");
		this.height = Double.parseDouble(scan.nextLine());
		System.out.print("몸무게를 입력하세요 : ");
		this.weight = Double.parseDouble(scan.nextLine());
		this.result = this.weight/((this.height/100.0)*(this.height/100.0));
		if(this.result<18.5){
			this.you = "체중 부족";
		}else if(18.5<=this.result && this.result<=22.9){
			this.you = "정상";
		}else if(23.0<=this.result && this.result<=24.9){
			this.you = "과체중";
		}else if(25.0<=this.result){
			this.you = "비만";
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
		return "[키=" + height + " / 몸무게=" + weight + " / BMI=" + result + " / 결과=" + you + "]";
	}
	
}
