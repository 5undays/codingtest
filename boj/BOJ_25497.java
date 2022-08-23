package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_25497 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        Stack<Character> s = new Stack<>();
        Stack<Character> s1 = new Stack<>();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c == 'L') {
                s1.push(c);
            } else if (c == 'S') {
                s.push(c);
            } else if (c == 'K') {
                if (!s.isEmpty()) {
                    answer++;
                    s.pop();
                } else {
                    break;
                }
            } else if (c == 'R') {
                if (!s1.isEmpty()) {
                    answer++;
                    s1.pop();
                } else {
                    break;
                }
            } else {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
