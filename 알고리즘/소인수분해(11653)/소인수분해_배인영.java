package Algorithm;

/*����
���� N�� �־����� ��, ���μ������ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� N (1 �� N �� 10,000,000)�� �־�����.

���
N�� ���μ����� ����� �� �ٿ� �ϳ��� ������������ ����Ѵ�.
*/
import java.util.Scanner;

public class Quiz11653 {

	 public static void main(String[] args){
	        Scanner sc = new Scanner(System.in);
	        System.out.println("������ �Է��ϼ��� : ");
	        int num = sc.nextInt();
	 
	        while(num!=1){
	            for(int i=2; i<=num; i++){
	                if(num%i==0){
	                    num /= i;
	                    System.out.println(i);
	                    break;
	                }
	            }
	        }
	    }
	}
