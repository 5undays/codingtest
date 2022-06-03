package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// https://www.acmicpc.net/problem/17413
public class BOJ_17413 {

    static void print(BufferedWriter bw, Stack<Character> s) throws IOException {
        while (!s.isEmpty()) {
            bw.write(s.pop());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = bf.readLine();
        boolean tag = false; // 태그 여부
        Stack<Character> s = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '<') {
                tag = true; // 태그 시작
                print(bw, s); // 이전 내용 프린트
                bw.write(c);
            } else if (c == '>') {
                tag = false; // 태그 종료
                bw.write(c);
            } else if (tag) { // 태그 내용은 반전 없음
                bw.write(c);
            } else { // 태그가 아닌 내용들은 반대로 출력
                if (c == ' ') { // 공백이 단위가 된다
                    print(bw, s);
                    bw.write(c);
                } else {
                    s.push(c);
                }

            }
        }
        print(bw, s);
        bw.flush();

    }
}
