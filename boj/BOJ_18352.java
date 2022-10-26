package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 특정 거리의 도시 찾기
 * https://www.acmicpc.net/problem/18352
 */
public class BOJ_18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 도시의 개수
        int m = Integer.parseInt(st.nextToken()); // 도로의 개수
        int k = Integer.parseInt(st.nextToken()); // 거리 정보
        int x = Integer.parseInt(st.nextToken()); // 출발 도시 번호

        ArrayList<Integer>[] city = new ArrayList[n+1];
        for (int i = 0 ;i <= n; i++) {
            city[i] = new ArrayList<>();
        }

        for (int i = 0 ;i < m ;i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            city[a].add(b);
        }

        int[] check = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        while(!q.isEmpty()) {
            int c = q.poll();
            for (int i = 0; i < city[c].size(); i++) {
                int t = city[c].get(i);
                if (check[t] == 0 && t != x) {
                    check[t] = check[c] + 1;
                    q.add(t);
                }
            }
        }

        if (Arrays.stream(check).anyMatch(value -> k == value)) {
            for (int i = 0 ;i < check.length; i++) {
                if (check[i] == k) {
                    System.out.println(i);
                }
            }
        } else {
            System.out.println(-1);
        }
    }
}
