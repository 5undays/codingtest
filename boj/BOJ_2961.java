package boj;

import java.util.Scanner;

/**
 * 도영이가 만든 맛있는 음식
 * https://www.acmicpc.net/problem/2961
 */
public class BOJ_2961 {
    static int[][] arr;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n][2];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt(); // 신맛
            arr[i][1] = sc.nextInt(); // 쓴맛
        }

        backtracking(0);
        System.out.println(answer);
    }

    private static void backtracking(int depth) {
        if (depth == arr.length) {
            int count = 0, sour = 1, bitter = 0;
            for (int i = 0; i < arr.length; i++) {
                if (!visited[i]) {
                    count++;
                    sour *= arr[i][0];
                    bitter += arr[i][1];
                }
            }
            if (count > 0) {
                answer = Math.min(answer, Math.abs(sour - bitter));
            }
            return;
        }

        visited[depth] = true;
        backtracking(depth + 1);
        visited[depth] = false;
        backtracking(depth + 1);
    }
}
