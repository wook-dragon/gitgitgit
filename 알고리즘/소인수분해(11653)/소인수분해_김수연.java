package al;

import java.util.Scanner;



public class No_11653 {
	
	public static void divide(int num) {
		for (int i = 2; num !=0; i++) { //���μ����ض� 2���� ����, 0�� �ƴҶ����� 
			if (num ==1) { //���� 1�̸� 
				break; //���߰�
			}else if (num % i == 0) { // �Է��� ���� ���� 2���� ������ �� 0���� ��������
				System.out.println(i); //i���� ���. 
				num = num /i; //ex) 72 = 72/2 
				i--; // 1
			}
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�ƹ� ���ڳ� �Է��غ�����");
		int n = sc.nextInt();
		divide(n);
	}
	
}
