import java.util.Scanner;

public class BMI {

	private double result;

	public BMI input(BMI bmi) {
	Scanner length = new Scanner(System.in);
	System.out.print("키 입력:");
	Scanner weight = new Scanner(System.in);
	System.out.print("몸무게 입력:");
	
	double result = weight/((length/100)*(length/100));
	if(this.result<18.5){
		System.out.print("저체중");
	}else if(18.5<=result && result<=22.9){
		System.out.print("정상");
	}else if(23.0<=result && result<=24.9){
		System.out.print("과체중");
	}else if(25.0<=result){
		System.out.print("비만");
	}

		return bmi;
	}

}
