package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 덱
 * https://www.acmicpc.net/problem/10866
 */
public class BOJ_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> d = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            String cmd = line[0].toString();
            if (cmd.equals("push_front")) {
                int data = Integer.parseInt(line[1]);
                d.addFirst(data);
            } else if (cmd.equals("push_back")) {
                int data = Integer.parseInt(line[1]);
                d.addLast(data);
            } else if (cmd.equals("pop_front")) {
                if (d.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(d.pollFirst()).append("\n");
                }
            } else if (cmd.equals("pop_back")) {
                if (d.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(d.pollLast()).append("\n");
                }
            } else if (cmd.equals("size")) {
                sb.append(d.size()).append("\n");
            } else if (cmd.equals("empty")) {
                if (d.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (cmd.equals("front")) {
                if (d.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(d.peekFirst()).append("\n");
                }
            } else if (cmd.equals("back")) {
                if (d.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(d.peekLast()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
