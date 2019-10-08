import java.util.ArrayList;
import java.util.Scanner;

public class Soinsu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = Integer.parseInt(sc.nextLine());
		int savenum = 2;
		while(number!=1) {
			if(number%savenum==0) {
				number = number / savenum;
				System.out.println(savenum);
			}else {
				savenum++;
			}
		}
	}

}
