import java.util.ArrayList;
import java.util.Scanner;

public class Sosu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int count =0;
		ArrayList<Integer> sosu = new ArrayList<Integer>();
		for(int i=a;i<=b;i++) {
			count = 0;
			for(int j=1;j<=i;j++) {
				if(i%j==0) {
					count ++;
				}
				
			}
			if(count==2) {
				sosu.add(i);
			}
		}
		for(int i=0;i<sosu.size();i++) {
			System.out.println(sosu.get(i));
		}
	}

}
