package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최대 상승
 * https://www.acmicpc.net/problem/25644
 */
public class BOJ_25644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int min = Integer.MAX_VALUE;
        while (n -- > 0) {
            int current = Integer.parseInt(st.nextToken());
            answer = Math.max(answer, current - min);
            min = Math.min(min, current);
        }
        System.out.println(answer);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int max = arr[0];
//        int min = arr[0];
//        for (int i = 0; i < n; i++) {
//            if (max < arr[i]) {
//                max = arr[i];
//            }
//            if (min > arr[i]) {
//                min = arr[i];
//                max = arr[i];
//            }
//        }
//        System.out.println(max - min);
//    }
}
