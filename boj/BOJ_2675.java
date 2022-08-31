package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문자열 반복
 * https://www.acmicpc.net/problem/2675
 */
public class BOJ_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()); // 반복 횟수
            String s = st.nextToken(); // 문자열

            StringBuilder answer = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                for (int i = 0; i < r; i++) {
                    answer.append(s.charAt(j));
                }
            }
            System.out.println(answer);
        }
    }
}
