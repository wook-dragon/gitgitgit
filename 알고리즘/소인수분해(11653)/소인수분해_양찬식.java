/*
���� N�� �־����� ��, ���μ������ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� N (1 �� N �� 10,000,000)�� �־�����.

���
N�� ���μ����� ����� �� �ٿ� �ϳ��� ������������ ����Ѵ�. 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class P11653 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
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
//				if(b.get(i)%2==0 && b.get(i)%j!=0 ) {	//2�� ����������, j�� 
//					b.remove(i);
//					System.out.println("a" + b.get(i) + " j : " + j);
//				}
//			}
//		}
		/*--------------------��Ǯ�����------------------------*/


		int N = sc.nextInt();
		divide(N);
	}
	public static void divide(int num) {

		for (int i = 2; num != 0; i++) {
			if (num == 1) {	//�Է��� ���ڰ� 1�̸� break
				break;
			} else if (num % i == 0) {	//�Է��� ���ڰ� i�� ���� ���� 0�̸�
				System.out.println(i);
				num = num / i;
				i--; 	//i-- �ϰ� 0�� �ƴҶ� ����
			}
		}
	}



}

