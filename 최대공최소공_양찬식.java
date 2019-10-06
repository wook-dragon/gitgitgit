import java.util.Scanner;
/*
 문제
두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.

출력
첫째 줄에는 입력으로 주어진 두 수의 최대공약수를,둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
 */
public class P2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		int b;
		int c = 0;
		int d = 0;
		int e = 0;
		int f = 0;

		do {
			System.out.print("첫번째 숫자 입력 : ");
			a = Integer.parseInt(sc.nextLine());
		} while (a > 10000);

		do {
			System.out.print("두번째 숫자 입력 : ");
			b = Integer.parseInt(sc.nextLine());
		} while (b > 10000); 

		//		System.out.println(a + " " + b);

		if(a>b) {
			for(int i= 1; i <= a; i++) {
				if(a % i == 0 && b %i ==0) {
					if(i != 0) {
						c = i;
	//					System.out.println(c);
					} else {
	//					System.out.println(i);
						c=i;
						break;
					}
				}
			}
		} else {
			for(int i= 1; i <= b; i++) {
				if(a % i == 0) {
					if(i != 0) {
						c = i;
//						System.out.println(c);
					} else {
//						System.out.println(i);
						c=i;
						break;
					}
				}
			}
		}
			e = a/c;
			f = b/c;
			d = e * f * c;
			System.out.println(a + " " + b);
			System.out.println(/*"최대공약수 : " + */c);
			System.out.println(/*"최소공배수 : " + */d);

	}
}
