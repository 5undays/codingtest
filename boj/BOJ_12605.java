package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_12605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            String[] s = br.readLine().split(" ");
            Stack<String> st = new Stack<>();
            for (int j = 0; j < s.length; j++) {
                st.push(s[j]);
                st.push(" ");
            }
            sb.append("Case #" + i + ":");
            while (!st.isEmpty()) {
                sb.append(st.pop());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
