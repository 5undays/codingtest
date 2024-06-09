package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 카드놀이
 * https://www.acmicpc.net/problem/2511
 */
public class BOJ_2511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[10];
        int[] b = new int[10];
        for (int i = 0; i < 10; i ++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int sumA = 0;
        int sumB = 0;
        String answer = "D";

        for (int i = 0 ; i< 10; i++) {
            if (a[i] > b[i]) {
                sumA += 3;
                answer = "A";
            } else if (a[i] < b[i]){
                sumB += 3;
                answer = "B";
            } else {
                sumA += 1;
                sumB += 1;
            }
        }

        if (sumA > sumB) {
            answer = "A";
        } else if (sumA < sumB){
            answer = "B";
        }

        System.out.println(sumA + " " + sumB + "\n" + answer);
    }
}
