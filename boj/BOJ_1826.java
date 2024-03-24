package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1826 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 주유소의 개수
        StringTokenizer st;
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((o1,o2)->o1[0]-o2[0]);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 성경이의 시작 위치에서 주유소 까지의 거리
            int b = Integer.parseInt(st.nextToken()); //  주유소에서 채울 수 있는 연료의 양
            q.add(new int[] { a, b});
        }

        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken()); // 성경이의 위치에서 마을까지의 거리
        int fuel = Integer.parseInt(st.nextToken()); // 트럭에 원래 있던 연료의 양

        q.add(new int[] {l, 0});
        int answer = 0;
        int current = 0; // 현재 위치
        while (q.size() > 1) {
            if (current >= l) {
                break;
            }

            int[] station = q.poll();

            fuel -= (station[0] - current);
            current = station[0]; // 현재 위치

            if (fuel < 0) {
                answer = -1;
                break;
            }

            if (current == l) {
                break;
            }

            int[] next = q.peek();

            if (fuel < next[0] - current) {
                answer++;
                fuel += station[1];
            }
        }

        System.out.println(answer);
    }
}
