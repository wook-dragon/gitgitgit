import java.util.Scanner;
/*
M�̻� N������ �Ҽ��� ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �ڿ��� M�� N�� �� ĭ�� ���̿� �ΰ� �־�����. (1 �� M �� N �� 1,000,000)

���
�� �ٿ� �ϳ���, �����ϴ� ������� �Ҽ��� ����Ѵ�. 
 */
public class P1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m;
		int n;
		int c;
		
		do {
			System.out.print("ù��° ���� �Է� : ");
			m = Integer.parseInt(sc.nextLine());
			System.out.print("�ι�° ���� �Է� : ");
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