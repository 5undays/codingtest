package boj;

import java.util.Scanner;

/**
 * 백설 공주와 일곱 난쟁이
 * https://www.acmicpc.net/problem/3040 
 */
public class BOJ_3040 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int total_height = 0;
        for (int i = 0 ; i < 9 ;i ++) {
            arr[i] = sc.nextInt();
            total_height += arr[i];
        }

        int find_height = total_height - 100;

        //Arrays.sort(arr);
        
        for (int i = 0 ; i < 9 ; i++) {
            for (int j = 1; j < 9; j++) {
                if (arr[i] + arr[j] == find_height) {
                    for (int k = 0; k < 9; k++) {
                        if (k == i || k == j)
                            continue;
                        System.out.println(arr[k]);
                    }
                    System.exit(0);
                }
            }
        }
    }
}
