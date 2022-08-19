package boj;

import java.util.Scanner;
import java.util.Stack;

/**
 * 팰린드롬수
 * https://www.acmicpc.net/problem/1259
 */
public class BOJ_1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String x = sc.next();
            if (x.equals("0"))
                break;
            Stack<Character> s = new Stack<>();
            StringBuilder compare = new StringBuilder();
            for (int i = 0; i < x.length(); i++) {
                s.push(x.charAt(i));
            }

            for (int i = 0; i < x.length(); i++) {
                compare.append(s.pop());
            }

            if (x.equals(compare.toString())) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
