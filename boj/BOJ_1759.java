package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 암호 만들기
 * https://www.acmicpc.net/problem/1759
 */
public class BOJ_1759 {
    static String[] arr;
    static int l;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr = new String[c];
        visited = new boolean[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken();
        }
        Arrays.parallelSort(arr);
        backtracking(0,  "");

    }

    private static void backtracking(int depth, String password) {
        if (l == password.length()) {
            if (isValid(password)) {
                System.out.println(password);
            }
            return;
        }
        if (depth >= arr.length) {
            return;
        }
        backtracking(depth + 1, password + arr[depth]);
        backtracking(depth + 1, password);
    }

    private static boolean isValid(String password) {
        int v = 0, c = 0;
        for (int i = 0; i < password.length(); i++) {
            char k = password.charAt(i);
            if (k == 'a' || k == 'e' || k == 'i' || k == 'o' || k == 'u') {
                v++;
            } else {
                c++;
            }
        }
        return v >= 1 && c >= 2;
    }
}
