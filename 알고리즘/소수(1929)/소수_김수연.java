

	import java.util.ArrayList;
	import java.util.Scanner;

	public class No3_1929{
		public static void main(String[] args){

			Scanner sc = new Scanner(System.in);
			int M = sc.nextInt();
			int N = sc.nextInt();
		      
		      int[] data = new int[1000001];
		      int sum = 0;
		      ArrayList<Integer> list = new ArrayList<Integer>();
		      for(int i=1;i<1000001;i++)
		    	  data[i]=i;
		      
		      for(int i=2;i<1000001;i++) {
		    	  for(int j=i*2;j<1000001;j+=i) {
		    		  if(data[j]==0) continue;
		    		  data[j] = 0;
		    	  }
		      }
		      for(int i=2;i<=N;i++) {
		    	  if(data[i]!=0 && data[i]>=M && data[i]<=N) {
		    		  list.add(i);
		    	  }
		      }
		      for(int i=0; i<list.size(); i++) {
		   System.out.println(list.get(i));
		      }
		}
	}