package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                stack.push((double) arr[c - 'A']);
            } else {
                double a = stack.pop();
                double b = stack.pop();

                double result = 0;
                if (c == '*') {
                    result = b * a;
                } else if (c == '-') {
                    result = b - a;
                } else if (c == '+') {
                    result = b + a;
                } else {
                    result = b / a;
                }
                stack.push(result);
            }
        }
        System.out.printf("%.2f",stack.pop());
    }
}
