package Algorithm;
/*
 M�̻� N������ �Ҽ��� ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �ڿ��� M�� N�� �� ĭ�� ���̿� �ΰ� �־�����. (1 �� M �� N �� 1,000,000)

���
�� �ٿ� �ϳ���, �����ϴ� ������� �Ҽ��� ����Ѵ�.
 */
import java.util.Scanner;

public class Quiz1929 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("ù��° ���ڸ� �Է��ϼ���.");
		int num1 = Integer.parseInt(scan.nextLine());
		System.out.println("�ι�° ���ڸ� �Է��ϼ���.");
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
