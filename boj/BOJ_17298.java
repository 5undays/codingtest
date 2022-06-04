package boj;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_17298 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }
            while (!stack.isEmpty() && answer[stack.peek()] < answer[i]) {
                answer[stack.pop()] = answer[i];
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            answer[stack.pop()] = -1;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(answer[i]);
        }
    }
}
