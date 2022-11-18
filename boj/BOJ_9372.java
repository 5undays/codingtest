package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 상근이의 여행
 * https://www.acmicpc.net/problem/9372
 */
public class BOJ_9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] arr = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                arr[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x].add(y);
                arr[y].add(x);
            }

            Queue<Integer> q = new LinkedList<>();
            boolean[] check = new boolean[n + 1];
            q.add(1);
            check[1] = true;
            int answer = 0;
            while (!q.isEmpty()) {
                int x = q.poll();
                for (int city : arr[x]) {
                    if (!check[city]) {
                        check[city] = true;
                        answer++;
                        q.add(city);
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
