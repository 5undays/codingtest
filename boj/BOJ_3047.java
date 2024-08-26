package boj;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_3047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        String s = sc.next();
        for (int i = 0; i < 3; i++) {
            char k = s.charAt(i);
            sb.append(arr[k - 'A']).append(" ");
        }
        System.out.println(sb);
    }
}
