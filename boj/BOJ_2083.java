package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 럭비 클럽
 * https://www.acmicpc.net/problem/2083
 */
public class BOJ_2083 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (name.equals("#") && age == 0 && weight == 0) {
                break;
            }
            if (age > 17 || weight >= 80) {
                sb.append(name + " Senior");
            } else {
                sb.append(name + " Junior");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
