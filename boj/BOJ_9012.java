package boj;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_9012 {

    public static boolean isValid(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt < 0) {
                return false;
            }
        }
        if (cnt == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Stack<String> s = new Stack<>();
            String text = sc.next();
            boolean result = true;
            for (int j = 0; j < text.length(); j++) {
                char t = text.charAt(j);
                if (t == '(') {
                    if (j == text.length() - 1) {
                        result = false;
                    } else {
                        s.push(t + "");
                    }
                } else if (t == ')') {
                    if (s.isEmpty()) {
                        result = false;
                    } else {
                        s.pop();
                    }
                }
            }
            if (result == true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
