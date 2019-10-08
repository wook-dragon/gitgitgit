package al;

import java.util.Scanner;



public class No_11653 {
	
	public static void divide(int num) {
		for (int i = 2; num !=0; i++) { //소인수분해라서 2부터 시작, 0이 아닐때까지 
			if (num ==1) { //만약 1이면 
				break; //멈추고
			}else if (num % i == 0) { // 입력한 숫자 값에 2부터 나눴을 때 0으로 떨어지면
				System.out.println(i); //i값을 출력. 
				num = num /i; //ex) 72 = 72/2 
				i--; // 1
			}
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("아무 숫자나 입력해보세요");
		int n = sc.nextInt();
		divide(n);
	}
	
}
