package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 좌표 정렬하기 2
 * https://www.acmicpc.net/problem/11651
 */
public class BOJ_11651 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] xy = new int[n][2];
        for (int i = 0; i < n; i++) {
            xy[i][0] = sc.nextInt(); // x
            xy[i][1] = sc.nextInt(); // y
        }

        Arrays.sort(xy, (o1, o2) -> {
            if (o1[1] == o2[1]) { // y 가 같으면
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < xy.length; i++) {
            sb.append(xy[i][0]).append(" ").append(xy[i][1]).append("\n");
        }

        System.out.println(sb);
    }
}
