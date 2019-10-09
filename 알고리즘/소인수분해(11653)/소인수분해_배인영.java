package Algorithm;

/*문제
정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.

출력
N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다.
*/
import java.util.Scanner;

public class Quiz11653 {

	 public static void main(String[] args){
	        Scanner sc = new Scanner(System.in);
	        System.out.println("정수를 입력하세요 : ");
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
