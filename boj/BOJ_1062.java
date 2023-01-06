package boj;

import java.util.Scanner;

/**
 * 가르침
 * https://www.acmicpc.net/problem/1062
 */
public class BOJ_1062 {
    static String[] arr;
    static int n;
    static int k;
    static int answer = 0;
    static boolean[] alphabet = new boolean[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        if (k >= 5) {
            arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.next();
            }
            alphabet[0] = true;
            alphabet['n' - 'a'] = true;
            alphabet['t' - 'a'] = true;
            alphabet['i' - 'a'] = true;
            alphabet['c' - 'a'] = true;
            k -= 5;
            dfs(0, 0);
        }
        System.out.println(answer);
    }

    private static void dfs(int depth, int index) {
        if (depth == k) {
            answer = Math.max(answer, check());
        }

        for (int i = index; i < 26; i++) {
            if (alphabet[i]) continue;
            alphabet[i] = true;
            dfs(depth + 1, i);
            alphabet[i] = false;
        }
    }

    private static int check() {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            String a = arr[i];
            boolean check = true;
            for (int j = 0; j < a.length(); j++) {
                if (!alphabet[a.charAt(j) - 'a']) {
                    check = false;
                    break;
                }
            }
            if (check) {
                result++;
            }
        }
        return result;
    }
}
