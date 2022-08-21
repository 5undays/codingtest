package boj;

import java.util.Scanner;

/**
 * 스택
 * https://www.acmicpc.net/problem/10828
 */
public class BOJ_10828 {

    public static int[] stack;
    public static int current_size = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        stack = new int[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String method = sc.next();
            if (method.equals("push")) {
                int number = sc.nextInt();
                push(number);
            } else if (method.equals("empty")) {
                sb.append(empty()).append("\n");
            } else if (method.equals("size")) {
                sb.append(size()).append("\n");
            } else if (method.equals("pop")) {
                sb.append(pop()).append("\n");
            } else if (method.equals("top")) {
                sb.append(top()).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static int top() {
        if (current_size == 0) {
            return -1;
        } else {
            return stack[current_size - 1];
        }
    }

    public static void push(int number) {
        current_size++;
        stack[current_size - 1] = number;
    }

    public static int pop() {
        if (current_size == 0) {
            return -1;
        } else {
            int pop = stack[current_size - 1];
            current_size--;
            return pop;
        }
    }

    public static int size() {
        return current_size;
    }

    public static int empty() {
        if (current_size == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}