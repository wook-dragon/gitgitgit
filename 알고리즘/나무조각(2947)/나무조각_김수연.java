package al;

import java.util.*;
 
public class No_2947 {
    public static void main(String args[]) throws Exception {
    	
        Scanner sc = new Scanner(System.in);
         
        int[] arr = new int[5];
        int[] answer = new int[5];
 
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }
 
        while (check(arr)) {//�迭�� ���ڳ��� ���ϰ�,
            for (int x = 0; x <= 3; x++) {
                if (compare(arr, x, x + 1) && check(arr)) {
                    swap(arr, x, x + 1);// �տ� ���ڿ� �񱳰� �� �ȵȴٸ�,swap�Լ� �Ҹ��� 
                    print(arr);
                }
            }
        }
    }
 
    // x��°�� y��° �� �ٲٱ�
    public static void swap(int[] arr, int x, int y) {
        int swap; //���� Ÿ���� swap����;
        swap = arr[x]; //�迭 �ȿ� �ְ�
        arr[x] = arr[y];
        arr[y] = swap;
    }
 
    // x��°�� y��° �� ���ϱ�
    public static boolean compare(int[] arr, int x, int y) {
        if (arr[x] > arr[y]) { //���� x���� �� ũ�� return true;
            return true;
        }
        return false;
    }
 
    // �������� 5���̱� ������ 1,2,3,4,5 �� ���ĵƴ��� üũ
    public static boolean check(int[] arr) {
        boolean flags = false;
        for (int i = 0; i < 5; i++) {
            if (arr[i] != (i + 1)) {
                flags = true;
                break;
            }
        }
        return flags;
    }
    //����Ѵ�
    public static void print(int[] arr) {
        for (int i = 0; i < 5; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
 
    }
}
 
