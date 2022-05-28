package boj;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_9093 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0 ; i < n ; i++) {
            String text = sc.next();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < text.length(); j++) {
                stack.push(text.charAt(j));
            }

            for (int u = 0 ; u < text.length(); u++) {
                System.out.print(stack.pop());
            }
        }
    }
}
