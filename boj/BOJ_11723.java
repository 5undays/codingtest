package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 집합
 * https://www.acmicpc.net/problem/11723
 */
public class BOJ_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arr = new ArrayList<>();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int data = 0;
            if (command.equals("add")) {
                data = Integer.parseInt(st.nextToken());
                arr.add(data);
            } else if (command.equals("check")) {
                data = Integer.parseInt(st.nextToken());
                if (arr.contains(data)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (command.equals("remove")) {
                data = Integer.parseInt(st.nextToken());
                if (arr.contains(data)) {
                    arr.remove(arr.indexOf(data));
                }
            } else if (command.equals("toggle")) {
                data = Integer.parseInt(st.nextToken());
                if (arr.contains(data)) {
                    arr.remove(arr.indexOf(data));
                } else {
                    arr.add(data);
                }
            } else if (command.equals("all")) {
                arr.clear();
                for (int i = 1; i <= 20; i++) {
                    arr.add(i);
                }
            } else if (command.equals("empty")) {
                arr.clear();
            }
        }
        System.out.println(sb);
        br.close();
    }
}
