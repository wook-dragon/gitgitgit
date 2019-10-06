package Algorithm;

//최대공약수(gcd), 최소공배수(lcm)

/*
 
 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
 
 입력
 첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.

 출력
 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를,둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
 
 */
import java.util.Scanner;

public class Quiz2609 {
	static Scanner scan = new Scanner(System.in);
	
	public int gcb(int a, int b) { //최대공약수
		int minNum = Math.min(a, b);
		while(true) {
			if(a % minNum == 0 && b % minNum == 0) {
				return minNum;
			}
			minNum--;
		}
	}
	
	public int lcm(int a, int b) {
		return a*b /gcb(a,b);
	}
	
	
	public static void main(String[] args) {
		System.out.println("첫번째 숫자를 입력해주세요.");
		int num1 = Integer.parseInt(scan.nextLine());
		
		System.out.println("두번째 숫자를 입력해주세요.");
		int num2 = Integer.parseInt(scan.nextLine());
		

		Quiz2609 quiz = new Quiz2609();
		int gcb = quiz.gcb(num1, num2); 
		int lcm = quiz.lcm(num1, num2);
		
		System.out.println("최대공약수 : " + gcb);
		System.out.println("최소공배수 : " + lcm);
		
		

	}

}
