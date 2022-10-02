package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * 포인터 공부
 * https://www.acmicpc.net/problem/25703
 */
public class BOJ_25703 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("int a;").append("\n");
        sb.append("int *ptr = &a;").append("\n");
        String repeat = "*";
        for (int i = 2; i <= N; i++) {
            String k = (i - 1) > 1 ? i - 1 + "" : "";
            sb.append("int " + repeat.repeat(i) + "ptr" + i + " = &ptr" + k + ";").append("\n");
        }
        System.out.println(sb);
    }
}
