package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 요세푸스 문제
 * https://www.acmicpc.net/problem/1158
 */
public class BOJ_1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int per = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        
        sb.append("<");
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < per - 1; j++) {
                q.offer(q.poll()); // per 이전 값들은 다시 큐에 넣어줌
            }
            sb.append(q.poll() + ", "); // per 에 해당하는 데이터 제거
        }
        sb.append(q.poll() + ">"); // 마지막 하나
        System.out.println(sb);
    }
}
