import java.util.Scanner;
/*
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000)

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다. 
 */
public class P1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m;
		int n;
		int c;
		
		do {
			System.out.print("첫번째 숫자 입력 : ");
			m = Integer.parseInt(sc.nextLine());
			System.out.print("두번째 숫자 입력 : ");
			n = Integer.parseInt(sc.nextLine());
		} while (1 > m || m > 1000000 || 1 > n || n > 1000000);

		if(m>n) {
			for(int i = n; i <= m; i ++) {
				if(i%m == 0 && m%1 == 0) {
					c=i;
					System.out.println(c);
				} 
			}

		}else {
			for(int i = m; i <= n; i++) {
				if(i%n == 0 && n%1 == 0) {
					c=i;
					System.out.println(c);
				} 
			}
		}



	}
}