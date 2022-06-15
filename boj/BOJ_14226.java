package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 이모티콘
// https://www.acmicpc.net/problem/14226
public class BOJ_14226 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] display = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(display[i], -1);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1); // 이모티콘 1개 입력
        q.add(0);

        display[1][0] = 0;
        while (!q.isEmpty()) {
            int s = q.remove(); // 화면에 이모티콘의 개수
            int c = q.remove(); // 클립보드에 이모티콘의 개수

            // 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장
            if (display[s][s] == -1) {
                display[s][s] = display[s][c] + 1;
                q.add(s);
                q.add(s);
            }

            // 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
            if (s + c <= n && display[s + c][c] == -1) {
                display[s+c][c] = display[s][c] + 1;
                q.add(s+c);
                q.add(c);
            }

            // 화면에 있는 이모티콘 중 하나를 삭제
            if (s - 1 >= 0 && display[s - 1][c] == -1) {
                display[s-1][c] = display[s][c] + 1;
                q.add(s - 1);
                q.add(c);
            }
        }

        int ans = -1;
        for (int i = 0; i <= n; i++) {
            if (display[n][i] != -1) {
                if (ans == -1 || ans > display[n][i]) {
                    ans = display[n][i];
                }
            }
        }

        System.out.println(ans);
    }
}
