package boj;

import java.util.Scanner;
import java.util.Stack;

/**
 * 균형잡힌 세상
 * https://www.acmicpc.net/problem/4949
 */
public class BOJ_4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            if (s.equals(".")) {
                break;
            }
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isLetter(c) || c == '.' || c == ' ') {
                    continue;
                }
                if (c == ']' || c == ')') {
                    if (stack.isEmpty()) {
                        stack.push('.');
                        break;
                    }
                    if (c == ']') {
                        if (stack.peek() == '[') {
                            stack.pop();
                        } else {
                            break;
                        }
                    } else if (c == ')') {
                        if (stack.peek() == '(') {
                            stack.pop();
                        } else {
                            break;
                        }
                    }
                } else {
                    stack.push(c);
                }
            }

            if (stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
