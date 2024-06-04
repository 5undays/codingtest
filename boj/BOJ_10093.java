package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * 숫자
 */
public class BOJ_10093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        StringJoiner sj = new StringJoiner(" ");

        if (b > a) {
            for (long i = a + 1; i < b; i++) {
                sj.add(String.valueOf(i));
            }
            System.out.println( b - a - 1 + "\n" + sj);
        } else if (a > b) {
            for (long i = b + 1; i < a; i++) {
                sj.add(String.valueOf(i));
            }
            System.out.println( a - b - 1 + "\n" + sj);
        } else {
            System.out.println("0");
        }
    }
}
