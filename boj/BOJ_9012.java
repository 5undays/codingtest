package boj;

import java.util.Scanner;
import java.util.Stack;

import javax.naming.spi.DirStateFactory.Result;

public class BOJ_9012 {
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
