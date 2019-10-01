import java.util.ArrayList;
import java.util.Scanner;

public class Yaksu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 0;
		int K = 0;
		ArrayList arrlist = new ArrayList();
		N = sc.nextInt();
		K = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			if (N % i == 0) {
				arrlist.add(i);
			}
		}
		  for(int j =arrlist.size();j<N;j++) {
		         arrlist.add(0);
		        
		      }
		System.out.println(arrlist.get(K - 1));
	}

}
