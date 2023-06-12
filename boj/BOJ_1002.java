package boj;

import java.util.Scanner;

/**
 * 터렛
 * https://www.acmicpc.net/problem/1002
 */
public class BOJ_1002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            double substact = r1 > r2 ? r1 - r2 : r2 - r1;

            if (d == 0 && r1 == r2) { // 무한히 많을 경우
                sb.append(-1);
            } else if (d < r1 + r2 && d > substact) { // 2개 일경우
                sb.append(2);
            } else if (d == r1 + r2 || d == substact) { // 1개 일경우
                sb.append(1);
            } else { // 안 만난다
                sb.append(0);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
