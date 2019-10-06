package Algorithm;
/*
 M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000)

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
 */
import java.util.Scanner;

public class Quiz1929 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("첫번째 숫자를 입력하세요.");
		int num1 = Integer.parseInt(scan.nextLine());
		System.out.println("두번째 숫자를 입력하세요.");
		int num2 = Integer.parseInt(scan.nextLine());
		
		for(int i = num1; i <= num2; i++) {
			int count = 0; 
			for(int j = 1; j<=i; j++) {
				if(i % j == 0) {
					count++;
				}
			}
			if(count == 2) {
				System.out.println(i);
			}
		}

	}
}
