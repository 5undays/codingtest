package boj;

import java.io.IOException;
import java.util.Scanner;

/**
 * 부등호
 * https://www.acmicpc.net/problem/2529
 */
public class BOJ_2529 {
    static String min = "", max = "";
    static String[] arr;
    static boolean[] visited = new boolean[10];
    static int k;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        arr = new String[k];
        for (int i = 0; i < k; i++) {
            arr[i] = sc.next();
        }

        dfs(0, "");
        System.out.println(max + "\n" + min);
    }

    private static void dfs(int depth, String s) {
        if (depth == k + 1) {
            if (min.isEmpty()) {
                min = s;
            } else {
                max = s;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visited[i] && (depth == 0 || possible(s.charAt(depth - 1), i + '0', arr[depth - 1]))) {
                visited[i] = true;
                dfs(depth + 1, s + String.valueOf(i));
                visited[i] = false;
            }

        }
    }

    private static boolean possible(int i, int j, String k) {
        if (k.equals("<")) {
            return i < j;
        } else {
            return i > j;
        }
    }
}
