/*
정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.

출력
N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다. 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class P11653 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
//		int a = Integer.parseInt(sc.nextLine());
//		ArrayList<Integer> b = new ArrayList<Integer>();
//		for(int i = 1; i <= a; i++) {
//			if(a%i==0) {
//				b.add(i);
//			}
//		}
//
//		for(int i = 0; i < b.size(); i++) {
//			System.out.println(b.get(i));
//			for(int j = 1 ; j <i; j++) {
//				if(b.get(i)%2==0 && b.get(i)%j!=0 ) {	//2로 나누어지고, j로 
//					b.remove(i);
//					System.out.println("a" + b.get(i) + " j : " + j);
//				}
//			}
//		}
		/*--------------------못풀었어요------------------------*/


		int N = sc.nextInt();
		divide(N);
	}
	public static void divide(int num) {

		for (int i = 2; num != 0; i++) {
			if (num == 1) {	//입력한 숫자가 1이면 break
				break;
			} else if (num % i == 0) {	//입력한 숫자가 i로 나눈 값이 0이면
				System.out.println(i);
				num = num / i;
				i--; 	//i-- 하고 0이 아닐때 까지
			}
		}
	}



}

