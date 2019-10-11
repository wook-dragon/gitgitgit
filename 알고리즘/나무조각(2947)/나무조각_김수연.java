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
 
        while (check(arr)) {//배열의 숫자끼리 비교하고,
            for (int x = 0; x <= 3; x++) {
                if (compare(arr, x, x + 1) && check(arr)) {
                    swap(arr, x, x + 1);// 앞에 숫자와 비교가 잘 안된다면,swap함수 불르고 
                    print(arr);
                }
            }
        }
    }
 
    // x번째와 y번째 값 바꾸기
    public static void swap(int[] arr, int x, int y) {
        int swap; //정수 타입의 swap선언;
        swap = arr[x]; //배열 안에 넣고
        arr[x] = arr[y];
        arr[y] = swap;
    }
 
    // x번째와 y번째 값 비교하기
    public static boolean compare(int[] arr, int x, int y) {
        if (arr[x] > arr[y]) { //만약 x값이 더 크면 return true;
            return true;
        }
        return false;
    }
 
    // 나무조각 5개이기 때문에 1,2,3,4,5 로 정렬됐는지 체크
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
    //출력한다
    public static void print(int[] arr) {
        for (int i = 0; i < 5; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
 
    }
}
 
