package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hashing
 * https://www.acmicpc.net/problem/15829
 */
public class BOJ_15829 {
    public static void main(String[] args) throws IOException {
        int m = 1234567891;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        String number = br.readLine();
        long pow = 1;
        long answer = 0;
        for (int i = 0; i < l; i++) {
            answer += ((number.charAt(i) - 96) * pow);
            pow = (pow * 31) % m;
        }
        System.out.println(answer % m);
    }
}
