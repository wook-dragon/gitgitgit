import java.util.Scanner;
/*
 ����
�� ���� �ڿ����� �Է¹޾� �ִ� ������� �ּ� ������� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ��� �� ���� �ڿ����� �־�����. �� ���� 10,000������ �ڿ����̸� ���̿� �� ĭ�� ������ �־�����.

���
ù° �ٿ��� �Է����� �־��� �� ���� �ִ�������,��° �ٿ��� �Է����� �־��� �� ���� �ּ� ������� ����Ѵ�.
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
			System.out.print("ù��° ���� �Է� : ");
			a = Integer.parseInt(sc.nextLine());
		} while (a > 10000);

		do {
			System.out.print("�ι�° ���� �Է� : ");
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
			System.out.println(/*"�ִ����� : " + */c);
			System.out.println(/*"�ּҰ���� : " + */d);

	}
}
