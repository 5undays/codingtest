package boj;

import java.util.Scanner;
import java.util.Stack;

// https://www.acmicpc.net/problem/10828
public class BOJ_10828 {

    public static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 9; i < n; i++) {
            String method = sc.next();
            if (method.equals("push")) {
                int number = sc.nextInt();
                push(number);
            } else if (method.equals("empty")){
                System.out.println(empty());
            } else if (method.equals("size")) {
                System.out.println(size());
            } else if (method.equals("pop")) {
                System.out.println(pop());
            } else if (method.equals("top")) {
                System.out.println(top());
            }
        }
    }

    public static int top() {
        return stack.peek();
    }

    public static void push(int number) {
        stack.push(number);
    }

    public static int pop() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            return stack.pop();
        }
    }

    public static int size() {
        return stack.size();
    }

    public static int empty() {
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
} 