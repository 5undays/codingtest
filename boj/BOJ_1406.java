package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 에디터
 * https://www.acmicpc.net/problem/1406
 */
public class BOJ_1406 {

    static int cursor = 0;
    static Stack<String> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (int i = 0; i < text.length(); i++) {
            left.push(text.charAt(i));
        }
        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            String[] line = br.readLine().split(" ");
            char cmd = line[0].charAt(0);
            if (cmd == 'L') { // 커서를 왼쪽으로 옮김
                if (!left.empty()) {
                    right.push(left.pop());
                }
            } else if (cmd == 'D') { // 커서를 오른쪽으로 옮김
                if (!right.empty()) {
                    left.push(right.pop());
                }
            } else if (cmd == 'B') { // 커서에 왼쪽에 있는 문자를 삭제
                if (!left.empty()) {
                    left.pop();
                }
            } else if (cmd == 'P') { // 문자를 추가함
                char c = line[1].charAt(0);
                left.push(c);
            }
        }
        while (!left.empty()) {
            right.push(left.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!right.empty()) {
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}
