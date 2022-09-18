package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 큐
 * https://www.acmicpc.net/problem/10845
 */
public class BOJ_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int tail = 0, head = 0;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            String cmd = line[0];
            if (cmd.equals("push")) { // 큐에 자료 넣는 연산
                int data = Integer.parseInt(line[1]);
                if (q.isEmpty()) {
                    head = data;
                }
                tail = data;
                q.add(data);
            } else if (cmd.equals("back")) { // 큐의 가장 뒤에 있는 자료를 보는 연산
                if (q.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(tail).append("\n");
                }
            } else if (cmd.equals("size")) { // 큐에 저장되어있는 자료의 개수를 알아보는 연산
                sb.append(q.size()).append("\n");
            } else if (cmd.equals("empty")) { // 큐가 비어있는지 아닌지를 알아보는 연산
                if (q.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (cmd.equals("pop")) { // 큐에서 자료를 빼는 연산
                if (q.isEmpty()) {
                    head = 0;
                    sb.append(-1).append("\n");
                } else {
                    int remove = q.remove();
                    sb.append(remove).append("\n");
                    if (!q.isEmpty()) {
                        head = q.peek();
                    } else {
                        head = 0;
                    }
                }
            } else if (cmd.equals("front")) { // 큐의 가장 앞에 있는 자료를 보는 연산
                if (q.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(q.peek()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
