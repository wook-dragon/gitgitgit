/*
0���� ũ�ų� ���� ���� N�� �־�����. �̶�, N!�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
�Է�
ù° �ٿ� ���� N(0 �� N �� 12)�� �־�����.
���
ù° �ٿ� N!�� ����Ѵ�.
 */
public class P10872 {
	public static void main(String[] args) {
		int ran = (int)(Math.random()*12 +1);
		System.out.println(ran);
		
		
		int a = 1;
		
		for(int i = 1; i <= ran; i++) {
			a *= i;
		}
		System.out.printf("%d", a);
		
		
	}
}