package boj;

import java.util.Scanner;
import java.util.Stack;

// https://www.acmicpc.net/problem/10799
public class BOJ_10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < text.length(); i++) {
            char t = text.charAt(i);
            if (t == ')') {
                if (s.peek() + 1 == i) { // 레이저
                    s.pop();
                    answer += s.size();
                } else { // 막대
                    s.pop();
                    answer++;
                }
            } else {
                s.push(i);
            }
        }
        System.out.println(answer);
    }
}
