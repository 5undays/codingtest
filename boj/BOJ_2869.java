package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 달팽이는 올라가고 싶다
 * https://www.acmicpc.net/problem/2869
 */
public class BOJ_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken()); // 올라갈수 있는 거리
        int b = Integer.parseInt(st.nextToken()); // 미끄러지는 거리
        int v = Integer.parseInt(st.nextToken()); // 올라가야하는 거리

        System.out.println((v - b - 1) / (a - b) + 1);
    }
}
