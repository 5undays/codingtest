package boj;

import java.util.Scanner;

/**
 * 암호제작
 * https://www.acmicpc.net/problem/1837
 */
public class BOJ_1837 {
    static boolean[] prime = new boolean[1000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String p = sc.next();
        int k = sc.nextInt();
        int r = Integer.MAX_VALUE;
        for (int i = 2; i <= 1000000; i++) {
            if (prime[i]) continue;
            for (int j = i + i; j <= 1000000; j += i) {
                prime[j] = true;
            }
        }

        for (int i = 2; i <= k; i++) {
            if (prime[i]) continue;
            int m = 0;
            for (int j = 0; j < p.length(); j++) {
                m = (m * 10 + p.charAt(j) - '0') % i;
            }
            if (m == 0) {
                r = i;
                break;
            }
        }
        if (r < k) {
            System.out.println("BAD " + r);
        } else {
            System.out.println("GOOD");
        }
    }

}
