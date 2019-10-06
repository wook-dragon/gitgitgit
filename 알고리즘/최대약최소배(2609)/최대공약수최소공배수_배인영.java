package Algorithm;

//�ִ�����(gcd), �ּҰ����(lcm)

/*
 
 �� ���� �ڿ����� �Է¹޾� �ִ� ������� �ּ� ������� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 
 �Է�
 ù° �ٿ��� �� ���� �ڿ����� �־�����. �� ���� 10,000������ �ڿ����̸� ���̿� �� ĭ�� ������ �־�����.

 ���
 ù° �ٿ��� �Է����� �־��� �� ���� �ִ�������,��° �ٿ��� �Է����� �־��� �� ���� �ּ� ������� ����Ѵ�.
 
 */
import java.util.Scanner;

public class Quiz2609 {
	static Scanner scan = new Scanner(System.in);
	
	public int gcb(int a, int b) { //�ִ�����
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
		System.out.println("ù��° ���ڸ� �Է����ּ���.");
		int num1 = Integer.parseInt(scan.nextLine());
		
		System.out.println("�ι�° ���ڸ� �Է����ּ���.");
		int num2 = Integer.parseInt(scan.nextLine());
		

		Quiz2609 quiz = new Quiz2609();
		int gcb = quiz.gcb(num1, num2); 
		int lcm = quiz.lcm(num1, num2);
		
		System.out.println("�ִ����� : " + gcb);
		System.out.println("�ּҰ���� : " + lcm);
		
		

	}

}
