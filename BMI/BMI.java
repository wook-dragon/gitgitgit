import java.util.Scanner;

public class BMI {

	private double result;

	public BMI input(BMI bmi) {
	Scanner sc1 = new Scanner(System.in);
	System.out.println("키 입력:");
	
	Scanner sc2 = new Scanner(System.in);
	System.out.println("몸무게 입력:");
    double a = sc1.nextInt();
    double b = sc2.nextInt();
    
	double result = b/((a/100)*(a/100));
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
