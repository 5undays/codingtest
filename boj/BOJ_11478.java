package boj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 서로 다른 부분 문자열의 개수
 * https://www.acmicpc.net/problem/11478
 */
public class BOJ_11478 {
    static Set<String> arr = new HashSet<>();
    static String s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();

        for (int i = 0; i < s.length(); i++) {
            dfs(s.charAt(i) + "", i);
        }

        System.out.println(arr.size());
    }

    private static void dfs(String str, int depth) {
        arr.add(str);

        if (depth >= s.length() - 1) {
            return;
        }

        dfs(str + s.charAt(depth + 1), depth + 1);
    }
}
