import java.util.Scanner;

public class Bubble {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] intarr = new int[5];
		int temp = 0;
		for(int i=0;i<intarr.length;i++) {
			intarr[i]= sc.nextInt();
		}
		while(!(intarr[0]==1&&intarr[1]==2&&intarr[2]==3&&intarr[3]==4&&intarr[4]==5)) {
			for(int i=0;i<intarr.length-1;i++) {
				if(intarr[i]>intarr[i+1]) {
					temp = intarr[i];
					intarr[i]=intarr[i+1];
					intarr[i+1]=temp;
					for(int j=0;j<intarr.length-1;j++) {
						System.out.print(intarr[j]+" ");
					}System.out.print(intarr[4]);
					System.out.println();
				}
			}
		}
	}

}
