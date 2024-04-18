package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 탑
 * https://www.acmicpc.net/problem/2493
 */
public class BOJ_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        Stack<int[]> s = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            while (!s.isEmpty()) {
                if (arr[i] < s.peek()[1]) {
                    sb.append(s.peek()[0]).append(" ");
                    break;
                }
                s.pop();
            }
            if (s.isEmpty()) {
                sb.append(0).append(" ");
            }
            s.push(new int[] {i, arr[i]});
        }

        System.out.println(sb);
    }
}
