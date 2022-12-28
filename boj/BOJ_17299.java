package boj;

import java.util.Scanner;
import java.util.Stack;

/**
 * 오등큰수
 * https://www.acmicpc.net/problem/17299
 */
public class BOJ_17299 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] answer = new int[n];
        int[] data = new int[n];
        int[] frequence = new int[1000001];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
            frequence[data[i]]++;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }
            while (!stack.isEmpty() && frequence[data[stack.peek()]] < frequence[data[i]]) {
                answer[stack.pop()] = data[i];
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            answer[stack.pop()] = -1;
        }

        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
