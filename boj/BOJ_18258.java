package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 큐 2
 * https://www.acmicpc.net/problem/18258
 */
public class BOJ_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new LinkedList<>();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            if (oper.equals("push")) {
                int k = Integer.parseInt(st.nextToken());
                q.add(k);
            } else if (oper.equals("pop")) {
                if (q.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(q.poll());
                }
                sb.append("\n");
            } else if (oper.equals("size")) {
                sb.append(q.size());
                sb.append("\n");
            } else if (oper.equals("empty")) {
                if (q.isEmpty()) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
                sb.append("\n");
            } else if (oper.equals("front")) {
                if (q.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(q.getFirst());
                }
                sb.append("\n");
            } else if (oper.equals("back")) {
                if (q.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(q.getLast());
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
