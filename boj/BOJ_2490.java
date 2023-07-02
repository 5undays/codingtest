package boj;

import java.util.Scanner;

/**
 * 윷놀이
 * https://www.acmicpc.net/problem/2490
 */
public class BOJ_2490 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 0; j < 4; j++) {
                int k = sc.nextInt();
                if (k == 1) {
                    count++;
                }
            }

            if (count == 3) { // 도(배 한 개, 등 세 개)
                sb.append("A");
            } else if (count == 2){ // 개(배 두 개, 등 두 개)
                sb.append("B");
            } else if (count == 1) { // 걸(배 세 개, 등 한 개)
                sb.append("C");
            } else if (count == 0){ // 윷(배 네 개)
                sb.append("D");
            } else {
                sb.append("E");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
