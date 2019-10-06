import java.util.Scanner;

public class GongYaksu_Baesu {

	public static void main(String[] args) {
		int mod = 1;
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int gop = a*b;
		if(a>b) {
			while(mod!=0) {
				mod = a%b;
				if(mod==0) {
					System.out.println(b);
				}else {
					a=b;
					b=mod;
				}
			}
		}else {
			int temp = b;
			b = a;
			a=temp;
			while(mod!=0) {
				mod = a%b;
				if(mod==0) {
					System.out.println(b);
				}else {
					a=b;
					b=mod;
				}
			}
		}
		int gongbaesu = gop/b;
		System.out.println(gongbaesu);
	}

}
